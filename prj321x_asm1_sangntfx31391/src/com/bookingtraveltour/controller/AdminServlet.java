package com.bookingtraveltour.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookingtraveltour.dto.UserDto;
import com.bookingtraveltour.entity.User;
import com.bookingtraveltour.repository.RoleRepository;
import com.bookingtraveltour.repository.UserRepository;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "AdminServlet", urlPatterns = { "/admin", "/admin/editCustomer", "/admin/addCustomer" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserRepository userRepository = null;
	private RoleRepository roleRepository = null;

	public AdminServlet() {
		userRepository = new UserRepository();
		roleRepository = new RoleRepository();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		int count = userRepository.countUserInList();
		int size = 3;
		int endPage = count / size;
		if (count % size != 0) {
			endPage++;
		}
		int pagedefault = 1;

		String index = request.getParameter("index");

		if (index != null) {
			pagedefault = Integer.parseInt(index);
		}

		switch (action) {
		case "/admin":
			request.setAttribute("viewWithList", userRepository.getAllUser(pagedefault));
			request.setAttribute("endPage", endPage);
			request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
			break;
		case "/admin/editCustomer":
			int id = Integer.parseInt(request.getParameter("customerId"));
			UserDto customerInfor = userRepository.findUserById(id);
			request.setAttribute("customerInfor", customerInfor);
			request.setAttribute("roleList", roleRepository.getAllRole());
			request.getRequestDispatcher("/views/admin/editCustomer.jsp").forward(request, response);
			break;
		case "/admin/addCustomer":
			request.getRequestDispatcher("/views/admin/admin-add-customer-form.jsp").forward(request, response);
			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));

		switch (action) {

		case "/admin/addCustomer":

			userRepository.addUserInfor(new User(1, fullname, password, username, email, phoneNumber, address, true));
			response.sendRedirect(request.getContextPath() + "/admin");
			break;

		case "/admin/editCustomer":
//			userRepository
//					.updateUserInfor(new User(userId, role, fullname, password, username, email, phoneNumber, true));
			userRepository.updateUserInfor(fullname, phoneNumber, address, role, userId);
			response.sendRedirect(request.getContextPath() + "/admin");
			break;

		}

	}
}