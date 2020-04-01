package com.phantom.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phantom.models.Question;
import com.phantom.models.Test;
import com.phantom.services.TestService;

@WebServlet(urlPatterns = "/check")
public class IndexServlet extends HttpServlet {

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;

    private TestService testService;

    @Override
    public void init() throws ServletException {
        super.init();
        testService = new TestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("test") == null) {
            //resp.getWriter().write(testService.findAll());
            ArrayList<Test> tests = testService.findAll();
            req.setAttribute("tests", tests);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            Long id = 1L;
            try {
                id = Long.parseLong(req.getParameter("test"));
            } catch (Exception e) {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            ArrayList<Question> questions = testService.getQuestions(id);
            req.setAttribute("id", id);
            req.setAttribute("questions", questions);
            getServletContext().getRequestDispatcher("/show.jsp").forward(req, resp);
        }
    }
}