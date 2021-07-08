package com.e.dxy.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@Api(tags = "-o- 首页")
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return this.toString() + Math.random();
    }

    // 新增
    @GetMapping("/add")
    public Integer add() {
        return 1;
    }

    // 修改
    @GetMapping("/update")
    public Boolean update() {
        return true;
    }

    // 删除
    @GetMapping("/delete")
    public Boolean delete() {
        return true;
    }


    // 列表
    @GetMapping("/list")
    public Map<Integer, String> list() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1111");
        map.put(2, "2222");
        return map;
    }

    // 详情
    @GetMapping("/detail")
    public List<String> detail() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        return list;
    }

}
