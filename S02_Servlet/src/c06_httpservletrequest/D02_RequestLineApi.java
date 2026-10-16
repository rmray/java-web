package c06_httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求行 API
 * 请求地址：http://localhost:8080/servlet/api-requestline?username=tom&age=11#chapter20
 */
@WebServlet(urlPatterns = "/api-requestline")
public class D02_RequestLineApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod(); // GET
        String uri = req.getRequestURI(); // /servlet/api-requestline
        StringBuffer url = req.getRequestURL(); // http://localhost:8080/servlet/api-requestline

        String contextPath = req.getContextPath(); // /servlet
        String servletPath = req.getServletPath(); // /api-requestline

        String pathInfo = req.getPathInfo(); // null
        String queryString = req.getQueryString(); // username=tom&age=11
        String protocol = req.getProtocol(); // HTTP/1.1

        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write("""
            method -> %s\n
            uri -> %s\n
            url -> %s\n
            contextPath -> %s\n
            servletPath -> %s\n
            pathInfo -> %s\n
            queryString -> %s\n
            protocol -> %s\n
        """.formatted(method, uri, url, contextPath, servletPath, pathInfo, queryString, protocol));
    }
}
