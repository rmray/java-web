package c01_base;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证 Servlet 的单例特性
 */
public class D02_SingletonServlet implements Servlet {
    private int count = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("D01_HelloServlet 初始化成功！");
        count++; // 这里只执行了1次，即表示 Servlet 是一个单例类
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;chartset=utf-8");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Hello from D01_HelloServlet!");
        respWriter.println("count: " + count);
        System.out.println("count(console): " + count);
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
