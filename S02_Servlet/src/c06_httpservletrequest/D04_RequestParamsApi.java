package c06_httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * API-请求参数
 */
@WebServlet("/api-request-params")
public class D04_RequestParamsApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // setCharacterEncoding、getCharacterEncoding
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());
        req.setCharacterEncoding("utf-8");
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

        // getParameter
        System.out.println("req.getParameter(\"username\") = " + req.getParameter("username"));

        // getParameterValues
        System.out.println("req.getParameterValues() = " + Arrays.toString(req.getParameterValues("hobbies")));

        // getParameterMap
        Map<String, String[]> paramMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = paramMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println(entry.getKey() + " -> "+ Arrays.toString(entry.getValue()));
        }
    }
}
