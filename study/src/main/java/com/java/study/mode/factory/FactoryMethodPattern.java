package com.java.study.mode.factory;


public interface FactoryMethodPattern {
    /**
     * 定义创建方法，由子类实现，从而实现解耦
     * @return
     */
    public  Goods createGoods();
}
