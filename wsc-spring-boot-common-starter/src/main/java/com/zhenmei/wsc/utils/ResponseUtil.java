package com.zhenmei.wsc.utils;


import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) {
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            //json返回
            out.println(JSON.toJSONString(o));
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error(ResponseUtil.class.getName(), e);
        }
    }

}
