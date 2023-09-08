package com.java.study.mode.observer;

import com.java.study.mode.SingletonPattern;
import com.java.study.mode.factory.Goods;

public class test {
    public static void main(String[] args){
        Product couponStatusSubject=new Product();
        ProjectShelfServiceImpl projectShelfService=new ProjectShelfServiceImpl();
        couponStatusSubject.registerObserver(projectShelfService);
        couponStatusSubject.setName("触发");
    }
}
