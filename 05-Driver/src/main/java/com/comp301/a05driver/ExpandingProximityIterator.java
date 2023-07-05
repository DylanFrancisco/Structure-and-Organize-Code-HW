package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {

    private Iterable<Driver> driverPool;
    private Iterator<Driver> iterator;
    private Position clientPosition;
    private int expansionStep;
    private int ringLevel;
    private Driver nextDriver;
    private int lastRingValue;
    boolean flag;
    private int counter;

    public ExpandingProximityIterator(
        Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null || clientPosition == null) {
            throw new IllegalArgumentException("Null parameters");
        }
        this.driverPool = driverPool;
        iterator = driverPool.iterator();
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;
        ringLevel = 0;
        nextDriver = null;
        lastRingValue = 0;
        flag = false;
        counter = 0;
    }

    private void expand() { // expands ring size
        lastRingValue = 1 + (ringLevel * expansionStep);
        ringLevel++;
        counter++;
        if (counter == 50) {
            expansionStep = (int) Math.floor((Integer.MAX_VALUE - 1) / ringLevel);
        }
        iterator = driverPool.iterator();
    }

    private void getNextDriver() {
        if (nextDriver == null && counter != 51) {
            while (iterator.hasNext()) {
                Driver currentDriver = iterator.next();
                Vehicle currentVehicle = currentDriver.getVehicle();
                Position currentPosition = currentVehicle.getPosition();
                int difference = clientPosition.getManhattanDistanceTo(currentPosition);

                if (lastRingValue < difference
                    && difference <= (1 + (ringLevel * expansionStep))) {
                    nextDriver = currentDriver;
                    return;
                } else if (difference
                    > (1 + (ringLevel * expansionStep))) {
                    flag = true;
                }
            }

            if (flag) {
                flag = false;
                expand();
                getNextDriver();
            }
        }
    }

    public Driver next() {
        if (this.hasNext()) {
            Driver next = nextDriver;
            nextDriver = null;
            return next;
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext() {
        getNextDriver();
        if (nextDriver == null) {
            return false;
        } else {
            return true;
        }
    }
}
