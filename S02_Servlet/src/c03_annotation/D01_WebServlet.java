package c03_annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

/**
 * WebServlet 注解的基本使用
 */
@WebServlet(
        name="WebServletDemo",
        urlPatterns="/web",
        initParams = {
                @WebInitParam(name="module", value = "order", description = "order cpn"),
                @WebInitParam(name="user", value="tom", description = "tom~~")
        },
        loadOnStartup = 1
)
public class D01_WebServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init executed~");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取WebServlet注解配置
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("servletConfig.getServletContext() = " + servletConfig.getServletContext());
        System.out.println("servletConfig.getServletName() = " + servletConfig.getServletName());
        System.out.println("servletConfig.getInitParameterNames() = " + servletConfig.getInitParameterNames());
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        for (String paramName : Collections.list(initParameterNames)) {
            String paramValue = servletConfig.getInitParameter(paramName);
            System.out.println(paramName + ": " + paramValue);
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Web Get handled~");
    }
}
