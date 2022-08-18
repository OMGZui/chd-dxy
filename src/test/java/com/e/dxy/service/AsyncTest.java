package com.e.dxy.service;

import com.e.dxy.DxyApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/12/22 4:10 PM
 */
public class AsyncTest extends DxyApplicationTests {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void doWork(){
        asyncService.executeAsync();
    }
}
