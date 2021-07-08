package com.e.dxy.controller;

import com.e.dxy.utils.Response;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("session")
@Api(tags = "-o- session")
@SuppressWarnings("unchecked")
public class SessionController {

    @PostMapping("set")
    public Response set(HttpSession session, @RequestParam("value") String value) {
        session.setAttribute("key", value);
        return Response.success();
    }

    @GetMapping("getAll")
    public Response<Map<String,Object>> getAll(HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        for (Enumeration<String> enumeration = session.getAttributeNames();
             enumeration.hasMoreElements();) {
            String key = enumeration.nextElement();
            Object value = session.getAttribute(key);
            result.put(key, value);
        }
        return Response.success(result);
    }
}
