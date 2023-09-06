package com.java.study.mode;


import org.slf4j.Logger;

/**
 * @description study singleton pattern
 * @athor Wangteng
 */
public class SingletonPattern {
    /**
     * brief introduction:
     * A class in a system has only one instance,
     * which is self instantiated within the class and provides a unified access interface to the system;
     * this pattern have two types:
     * Hungry man type:when a class loading,instantiate it
     * sluggard type：when a class is first interfaced,instantiate it
     */
    private volatile static  SingletonPattern singletonPattern;
    private SingletonPattern(){}

    /**
     * Hungry man type
     */
    public static SingletonPattern getHungryInstance(){
        return singletonPattern;
    }
    /**
     * sluggard type
     * problem:
     * if multiple threads access this class,
     * this class maybe multiple instances created,
     * because getSluggardInstance() can not ensure synchronization.
     * @return
     */
    public static  SingletonPattern getSluggardInstance(){
        if(singletonPattern==null){
            singletonPattern=new SingletonPattern();
        }
        return singletonPattern;
    }
    /**
     * so,we can using "synchronized" keywords process code blocks,
     * and using "volatile" keywords process variable.
     */
    public static SingletonPattern getSyncSingletonPattern(){
        if(singletonPattern==null){
            synchronized(SingletonPattern.class){
                singletonPattern=new SingletonPattern();
            }
        }
        return singletonPattern;
    }
}
