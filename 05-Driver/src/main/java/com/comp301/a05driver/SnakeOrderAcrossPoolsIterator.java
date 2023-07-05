package com.comp301.a05driver;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

  private List<Iterator<Driver>> iteratorsList;
  private int index;
  private boolean order;
  private Driver nextDriver;
  private boolean repeatIndex;
  private boolean[] emptyChecker;

  public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
    this.iteratorsList = new ArrayList<>();
    this.index = 0;
    this.order = true;
    this.nextDriver = null;
    this.repeatIndex = true;
    this.emptyChecker = new boolean[driverPools.size()];

    for (int i = 0; i < driverPools.size(); i++){
      Iterable<Driver> driverPool = driverPools.get(i);
      if (driverPool != null) {
        this.iteratorsList.add(driverPool.iterator());
        this.emptyChecker[i] = false;
      } else {
        this.iteratorsList.add(null);
        this.emptyChecker[i] = true;
      }
    }
  }

  private boolean checkIfRemainingElements() {
    boolean elementsRemain = false;
    for (Iterator<Driver> iterator : iteratorsList) {
      if (iterator != null) {
        if (iterator.hasNext()) {
          elementsRemain = true;
          break;
        }
      }
    }
    return elementsRemain;
  }

  private void updateIndex() {

    if (iteratorsList.size() == 1) {
      return;
    }

    if (index == 0 || index == iteratorsList.size() - 1) {
      if (repeatIndex) {
        repeatIndex = false;
        if (order) {
          index++;
        } else {
          index--;
        }
      } else {
        order = !order;
        repeatIndex = true;
      }
    } else {
      if (order) {
        index++;
      } else {
        index--;
      }
    }
  }

  private void loadNextDriver() {
    while (checkIfRemainingElements()) {
      if (iteratorsList.get(index).hasNext()) {
        nextDriver = iteratorsList.get(index).next();
      }
      updateIndex();
      if (nextDriver != null) {
        break;
      }
    }
  }
  @Override
  public boolean hasNext() {
    loadNextDriver();
    if (nextDriver == null){
      return false;
    } else {
        return true;
    }
  }

  @Override
  public Driver next() {
    if (this.hasNext()) {
      Driver next = this.nextDriver;
      this.nextDriver = null;
      return next;
    } else {
      throw new NoSuchElementException();
    }
  }
}
