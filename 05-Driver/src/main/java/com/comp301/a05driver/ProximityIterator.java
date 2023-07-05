package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {

    private final Iterator<Driver> driverPool;
    private final Position clientPosition;
    private final int proximityRange;

    private Driver nextDriver;

    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange){
        if (driverPool == null){
            throw new IllegalArgumentException();
        }
        this.driverPool = driverPool.iterator();
        this.clientPosition = clientPosition;
        if (this.clientPosition == null){
            throw new IllegalArgumentException();
        }
        this.proximityRange = proximityRange;
        this.nextDriver = null;
    }

    private void loadNextDriver(){
        if (this.nextDriver != null) {
            return;
        } else {
            while (driverPool.hasNext()){
                Driver driver = driverPool.next();
                if (driver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition) <= proximityRange){
                    this.nextDriver = driver;
                    break;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        loadNextDriver();
        if (this.nextDriver != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Driver next() {
        boolean c = hasNext();
        if (!c){
            throw new NoSuchElementException();
        }
        Driver next = this.nextDriver;
        this.nextDriver = null;
        return next;
    }
}
