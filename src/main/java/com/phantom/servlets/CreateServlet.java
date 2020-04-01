package com.phantom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phantom.services.TestService;

@WebServlet("/store")
public class CreateServlet extends HttpServlet {

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

		if (req.getParameterValues("questions") != null) {
            testService.Create(req.getParameterValues("questions"));
        }

        resp.sendRedirect("/app/check");

	}

    
}