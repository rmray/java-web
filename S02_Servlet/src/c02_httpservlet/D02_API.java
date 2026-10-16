package c02_httpservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api")
public class D02_API extends HttpServlet {
    @Override
    protected long getLastModified(HttpServletRequest req) {
        return (System.currentTimeMillis() /1000) * 1000;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();

        try {
            super.service(req, resp);
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println("excute service take: " + duration);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Get handled~");
    }
}
