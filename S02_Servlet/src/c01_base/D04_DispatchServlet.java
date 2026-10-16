package c01_base;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示 GET 和 POST 请求的分发
 */
public class D04_DispatchServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        String method = httpReq.getMethod();
        if("GET".equalsIgnoreCase(method)) {
            resp.getWriter().write("handled GET");
        } else if("POST".equalsIgnoreCase(method)) {
            resp.getWriter().write("handled POST");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
}
