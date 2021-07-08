package com.e.dxy.controller;

import com.e.dxy.model.UserModel;
import com.e.dxy.repository.UserRepository;
import com.e.dxy.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private UserRepository userRepository;

    // 新增
    @PostMapping("/add")
    @ApiOperation(value = "用户新增")
    public Response<UserModel> add(@RequestBody @Validated UserModel userData) {
        UserModel user = new UserModel();

        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());

        userRepository.save(user);
        logger.info("新增成功");
        return Response.success();
    }

    // 修改
    @PostMapping("/update")
    @ApiOperation(value = "用户更新")
    public Response<UserModel> update(@RequestBody @Validated UserModel userData) {
        Optional<UserModel> _user = userRepository.findById(userData.getId());

        if (!_user.isPresent()) {
            return Response.error("400", "用户不存在");
        }

        UserModel user = _user.get();

        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());

        userRepository.save(user);

        logger.info("修改成功");
        return Response.success();
    }

    // 删除
    @PostMapping("/delete")
    @ApiOperation(value = "用户删除")
    public Response delete(@RequestParam(name = "id", defaultValue = "") @NotNull(message = "id不能为空") @Min(value = 0, message = "id必须大于0") Integer id) {
        Optional<UserModel> _user = userRepository.findById(id);

        if (!_user.isPresent()) {
            return Response.error("400", "用户不存在");
        }

        userRepository.deleteById(id);

        logger.info("删除成功id=" + id);
        return Response.success();
    }


    // 列表
    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    public Response<List<UserModel>> list() {
        Iterable<UserModel> res = userRepository.findAll();

        logger.info("获取列表成功");
        return Response.success(res);
    }

    // 详情
    @GetMapping("/detail")
    @ApiOperation(value = "用户详情")
    public Response detail(@RequestParam(name = "id", defaultValue = "") @NotNull(message = "id不能为空") @Min(value = 0, message = "id必须大于0") Integer id) {
        Optional<UserModel> res = userRepository.findById(id);

        logger.info("获取成功id=" + id);
        return Response.success(res);
    }

    @PostMapping("/search")
    public Response search(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "username", defaultValue = "10") String username
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page - 1, size, sort);

        Page<UserModel> res = userRepository.searchByUsername(pageable, username);

        logger.info("搜索成功");
        return Response.success(res);
    }
}
