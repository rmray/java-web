package c01_base;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

// 演示 Servlet 的完整生命周期
public class D03_LifecycleServlet implements Servlet {

    // 如果添加了有参构造方法，就会覆盖该类的无参构造方法，
    // 而Servlet实例化时必须要求有一个无参构造方法，否则就会报错
    // public D03_LifecycleServlet(String test) {
    //     System.out.println("Constructor executed");
    // }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("D03_LifecycleServlet 初始化成功！");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;chartset=utf-8");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Hello from D03_LifecycleServlet!");
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
