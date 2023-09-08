package com.java.study.mode.observer;

/**
 * 观察者实现
 */
public class ProjectShelfServiceImpl implements Observer{
    /**
     * 变更商品方法
     * @param name
     */
    @Override
    public void update(String name) {

    }

    public interface CouponStatusSubject{
        //观察者注册
        void registerObserver(Observer observer);
        //观察者移除
        void removeObserver(Observer observer);
        //观察者唤醒
        void notifyObserver();
    }
    class ProductService implements Observer{
        void update(Coupon coupon);
    }
    public interface Observer {
        void update(Coupon coupon);
    }
}
