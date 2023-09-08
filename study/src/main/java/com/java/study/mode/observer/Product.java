package com.java.study.mode.observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject{
    private List<Observer> observers;
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }




    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.update(this.name);
        }
    }
}
