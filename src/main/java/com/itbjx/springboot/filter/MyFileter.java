package com.itbjx.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFileter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter process....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
