package com.e.dxy.controller;

import com.e.dxy.service.open.UserService;
import com.e.dxy.utils.Response;
import com.e.dxy.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;

@RestController
@RequestMapping("user")
@Validated
@Api(tags = "-o- 用户")
@SuppressWarnings("unchecked")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    // 新增
    @PostMapping("/add")
    @ApiOperation(value = "用户新增")
    public Response add(@RequestBody @Validated UserVO userData) {

        logger.info("新增成功");
        return userService.add(userData);
    }

    // 修改
    @PostMapping("/update")
    @ApiOperation(value = "用户更新")
    public Response update(@RequestBody @Validated UserVO userData) {

        logger.info("修改成功");
        return userService.update(userData);
    }

    // 删除
    @PostMapping("/delete")
    @ApiOperation(value = "用户删除")
    public Response delete(@RequestParam(name = "id", defaultValue = "") @NotNull(message = "id不能为空") @Min(value = 0, message = "id必须大于0") Integer id) {

        logger.info("删除成功id=" + id);
        return Response.success(userService.delete(id));
    }


    // 列表
    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    public Response list() {

        logger.info("获取列表成功");
        return userService.list();
    }

    // 详情
    @GetMapping("/detail")
    @ApiOperation(value = "用户详情")
    public Response detail(
            @RequestParam(name = "id", defaultValue = "")
            @NotNull(message = "id不能为空")
            @Min(value = 0, message = "id必须大于0") Integer id
    ){

        logger.info("获取成功id=" + id);
        return Response.success(userService.detail(id));
    }

    @GetMapping("/search")
    public Response search(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "username", defaultValue = "10") String username
    ) {

        logger.info("搜索成功");
        return userService.searchByUsername(page, size, username);
    }
}
