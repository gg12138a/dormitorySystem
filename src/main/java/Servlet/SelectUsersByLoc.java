package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import db.impl.UserDaoImpl;
import domain.User;

/**
 * Servlet implementation class SelectUsersByLoc
 */
@WebServlet("/SelectUsersByLoc")
public class SelectUsersByLoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUsersByLoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loc=request.getParameter("loc");
		System.out.println(loc);
		
		List<User> users = UserDaoImpl.getUsersByLocation(loc);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(JSON.toJSONString(users));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
