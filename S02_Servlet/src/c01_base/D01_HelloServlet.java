package c01_base;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 入门案例
 */
public class D01_HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("D01_HelloServlet 初始化成功！");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;chartset=utf-8");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Hello from D01_HelloServlet!");
    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return "";
    }

}
