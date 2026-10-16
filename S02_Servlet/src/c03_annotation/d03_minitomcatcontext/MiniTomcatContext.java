package c03_annotation.d03_minitomcatcontext;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 实现：简化版 Web 容器
 */
public class MiniTomcatContext {
    private final HashMap<String, Servlet> servletMapping = new HashMap<>();

    public void loadServlets (List<Class<?>> classes) throws Exception {
        for (Class<?> clazz : classes) {
            if(clazz.isAnnotationPresent(WebServlet.class)) {
                WebServlet anno = clazz.getAnnotation(WebServlet.class);
                String[] urls = anno.urlPatterns();

                Servlet servlet = (Servlet) clazz.getDeclaredConstructor().newInstance();

                for (String url : urls) {
                    servletMapping.put(url, servlet);
                }
            }
        }
    }

    public Servlet getServlet(String key) {
        return servletMapping.get(key);
    }

    public static void main(String[] args) {
        String fullClassName = "p06_annotation.D01_WebServlet";
        try {
            Class<?> clazz = Class.forName(fullClassName);
            MiniTomcatContext context = new MiniTomcatContext();
            context.loadServlets(Arrays.asList(new Class[] {clazz}));
            System.out.println("context.getServlet(\"/web\") = " + context.getServlet("/web"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
