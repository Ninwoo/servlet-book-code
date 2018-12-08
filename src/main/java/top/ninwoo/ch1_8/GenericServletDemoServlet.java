package top.ninwoo.ch1_8;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: ninwoo
 * @Date: 2018/12/8 14:46
 */
@WebServlet(name = "GenericServletDemoServlet",
        urlPatterns = {"/generic"},
        initParams = {
                @WebInitParam(name = "admin", value = "Harry Taciak"),
                @WebInitParam(name = "email", value = "admin@example.com")
        }
)
public class GenericServletDemoServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.print("<html><head></head><body>" +
                "Admin:" + admin +
                "<br/>Email:" + email +
                "</body></html>");
    }
}
