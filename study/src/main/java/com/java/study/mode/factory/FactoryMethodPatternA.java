package com.java.study.mode.factory;

public class FactoryMethodPatternA implements FactoryMethodPattern{
    @Override
    public Goods createGoods() {
        return new GoodsA();
    }
    FactoryMethodPattern factoryMethodPattern=new FactoryMethodPatternA();
    Goods goods=factoryMethodPattern.createGoods();
}
