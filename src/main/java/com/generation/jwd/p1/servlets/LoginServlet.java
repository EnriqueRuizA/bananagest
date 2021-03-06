package com.generation.jwd.p1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.jwd.p1.beans.LoginBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean loginBean = new LoginBean();
		loginBean.setUser(request.getParameter("user"));
		loginBean.setPassword(request.getParameter("password"));
		
		HttpSession session = request.getSession();

		if(loginBean.validator() == true) {
			session.setAttribute("comprobar", "Datos correctos");
			session.setAttribute("User", loginBean.getUser());
			request.getRequestDispatcher("homeuser.jsp").forward(request, response);
		} else {
			session.setAttribute("comprobar", "Datos incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	        
	}
}
