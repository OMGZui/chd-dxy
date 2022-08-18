package com.e.dxy.controller;

import com.e.dxy.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/12/22 4:08 PM
 */
@RestController
@RequestMapping
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        asyncService.executeAsync();
    }
}
