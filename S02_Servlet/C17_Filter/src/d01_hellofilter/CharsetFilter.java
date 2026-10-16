package d01_hellofilter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 前置：设置字符编码
        servletRequest.setCharacterEncoding("UTF-8");

        servletResponse.setContentType("text/html;charset=utf-8");

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
