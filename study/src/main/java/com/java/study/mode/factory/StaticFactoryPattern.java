package com.java.study.mode.factory;


public class StaticFactoryPattern {
    /**
     * 简单的静态工厂
     */
    public static Goods createGoods(String type) {
        if (type.equals("A")) {
            return new GoodsA();
        }  else {
            return null;
        }
    }

}
