package top.ninwoo.ch1_3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: ninwoo
 * @Date: 2018/12/8 14:01
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/my"})
public class MyServlet implements Servlet {
    // transient关键词表示该属性不参与序列化过程
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig)
            throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse)
            throws ServletException, IOException {
        String servletName = servletConfig.getServletName();
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head>" +
                "<body>Hello from " + servletName +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {

    }
}
