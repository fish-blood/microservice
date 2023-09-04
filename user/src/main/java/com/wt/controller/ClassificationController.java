package com.wt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;


@Validated
@RestController
@RequestMapping("/test")
@Api(tags={"图书接口"})
public class ClassificationController {
    @GetMapping("/tree/{id}")
    String selectClassificationTree(@PathVariable String id) {
        return "";
    }

    static Vector vector = new Vector(5);
    //测试调优参数
    @GetMapping("/test")
    @ApiOperation("删除图书")
    public void createTestObj(){
        while (true){
            Object object = new Object();
            vector .add(object);
            object = null;
        }
    }
}
