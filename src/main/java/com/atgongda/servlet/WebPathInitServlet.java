package com.atgongda.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author sushuai
 * @date 2019/02/19/19:49
 */
@WebServlet(urlPatterns = {},loadOnStartup = 2)
public class WebPathInitServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //在整体应用上下文当中存储了一个ctx的值，用它来引用上下文路径
        config.getServletContext().setAttribute("ctx",config.getServletContext().getContextPath());
        super.init(config);
    }
}
