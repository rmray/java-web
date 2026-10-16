package d01_hellofilter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter 初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("请求到达目标资源前：执行预处理");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("目标资源响应返回后：执行后处理");
    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter 已销毁");
    }
}
