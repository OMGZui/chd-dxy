package com.e.dxy.controller;

import com.e.dxy.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("redis")
@SuppressWarnings("unchecked")
@Api(tags = "-o- redis")
public class RedisController {
    final private String key = "redis:1";

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    @ApiOperation(value = "redis设置[hash]")
    public Response set(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "age") Integer age
    ) {
        redisTemplate.opsForHash().put(this.key, "name", name);
        redisTemplate.opsForHash().put(this.key, "age", age);

        return Response.success();
    }

    @GetMapping("/get")
    @ApiOperation(value = "redis获取[hash]")
    public Response get() {

        List<String> fields = new ArrayList<>();

        fields.add("name");
        fields.add("age");

        List<String> res = redisTemplate.opsForHash().multiGet(this.key, fields);

        Map<String, Object> result = new HashMap<>();

        int index = 0;
        for (String field : fields) {
            result.put(field, res.get(index));
            ++index;
        }

        return Response.success(result);
    }
}
