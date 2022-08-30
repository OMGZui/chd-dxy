package com.e.dxy.controller;

import com.e.dxy.service.impl.UserServiceImpl;
import com.e.dxy.utils.Response;
import com.e.dxy.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/18/22 10:39 PM
 */
@Slf4j
@RestController
@RequestMapping("medium")
public class MediumController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/update")
    public Response update(@Validated @RequestBody UserVO userVO) throws Exception{
        return Response.success(userService.updateMedium(userVO));
    }
}
