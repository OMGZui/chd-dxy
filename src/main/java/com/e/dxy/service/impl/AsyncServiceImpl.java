package com.e.dxy.service.impl;

import com.e.dxy.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/12/22 4:04 PM
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }
}
