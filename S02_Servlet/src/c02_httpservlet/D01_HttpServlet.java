package c02_httpservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 演示继承 HttpServlet 并重写 doGet 和 doPost 方法
// DEBUG HttpServlet 内部 `this.doGet()` 调用时跳转的位置是不是 D01_HttpServlet 中重写的 doGet() 方法
@WebServlet(urlPatterns="/http")
public class D01_HttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Response from doGet~");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Response from doPost~");
    }
}
