package com.sh.webfilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author sh
 * @date 2020-03-12 15:21
 */
public class TestFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
