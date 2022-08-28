package com.zhenmei.wsc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class SleepFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;

        StringUtils.isEmpty(hsr.getHeader("X-sleep"));

        Long sleep = Long.parseLong(Optional.ofNullable(hsr.getHeader("X-sleep")).orElse("0"));

        if (sleep != 0) {
            try {
                log.info("sleep:{}", sleep);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}