package com.phantom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phantom.services.TestService;

@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("id") != null) {
            Long id = 1L;
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (Exception e) {
                resp.sendRedirect("/app/check");
            }
            testService.Destroy(id);
        }

        resp.sendRedirect("/app/check");
	}

    
}