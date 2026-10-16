package c06_httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 构造器：拦截并重写 HTTP 请求头
 */
@WebServlet("/api-constructor")
public class D01_ConstructorApi extends HttpServlet {

  // 拦截并重写 HTTP 请求头
  public HttpServletRequest overrideHeader (HttpServletRequest request) {
      HttpServletRequest requestWrapper = new HttpServletRequestWrapper(request){
          @Override
          public String getHeader(String name) {
              if("X-Custom-Auth".equalsIgnoreCase(name)) {
                  return "Injected-Token-Value";
              }

              return super.getHeader(name);
          }
      };

      return requestWrapper;
  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        HttpServletRequest requestWrapper = overrideHeader(req);
        String customAuth = requestWrapper.getHeader("X-Custom-Auth");

        resp.getWriter().write("customAuth -> " + customAuth);
    }
}



























