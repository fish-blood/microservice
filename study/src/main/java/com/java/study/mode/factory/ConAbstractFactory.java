package com.java.study.mode.factory;

public class ConAbstractFactory implements AbstractFactory{
    @Override
    public Goods createGoods() {
        return new GoodsA();
    }

    @Override
    public GoodsA createGoodsA() {
        return new GoodsA();
    }

}
