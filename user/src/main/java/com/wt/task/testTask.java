package com.wt.task;

import java.util.Vector;

public class testTask {
    static Vector vector = new Vector(5);
    //测试调优参数
    public void createTestObj(){
        while (true){
            Object object = new Object();
            vector .add(object);
            object = null;
        }
    }
}
