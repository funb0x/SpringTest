package com.funbox.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Анна on 04.03.2017.
 */

@WebServlet
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.getWriter().write("front servlet works");
       // resp.sendRedirect("/helper");
        req.getRequestDispatcher("/helper").forward(req,resp);
    }
}
