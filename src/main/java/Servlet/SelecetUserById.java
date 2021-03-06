package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import db.impl.UserDaoImpl;
import domain.User;

/**
 * Servlet implementation class SelecetUser
 */
@WebServlet("/selecetUserByid")
public class SelecetUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelecetUserById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		System.out.println(uid);
		
		User userGot = UserDaoImpl.getUserByUid(uid);
		
		if(userGot.getLocation()==null)
			userGot.setLocation("??δ??ס?κ?????");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(JSON.toJSONString(userGot));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
