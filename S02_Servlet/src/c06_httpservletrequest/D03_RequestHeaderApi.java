package c06_httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * API-请求头
 * host, connection, cache-control, sec-ch-ua, sec-ch-ua-mobile, sec-ch-ua-platform, upgrade-insecure-requests,
 * user-agent, accept, sec-fetch-site, sec-fetch-mode, sec-fetch-user, sec-fetch-dest, accept-encoding, accept-language
 */
@WebServlet(urlPatterns = "/api-requestheader")
public class D03_RequestHeaderApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getHeader
        System.out.println("req.getHeader(\"User-Agent\") = " + req.getHeader("User-Agent"));

        // getHeaderNames
        Enumeration<String> headerNames = req.getHeaderNames();
        ArrayList<String> headerNameList = Collections.list(headerNames);
        System.out.println("Arrays.toString(headerNameList) = " + headerNameList.toString());

        // 遍历打印所有 Header
        for (String headerName : headerNameList) {
            System.out.println("req.getHeaders(" + headerName +") = " + req.getHeader(headerName));
        }

        // getContentType
        System.out.println("req.getContentType() = " + req.getContentType());

        // getIntHeader
        System.out.println("req.getIntHeader(\"upgrade-insecure-requests\") = " + req.getIntHeader("upgrade-insecure-requests"));

    }
}
