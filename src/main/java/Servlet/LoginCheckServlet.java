package Servlet;



import javax.servlet.*;
import javax.servlet.http.*;

import db.impl.AdminUserDaoImpl;
import db.impl.UserDaoImpl;
import domain.AdminUser;
import domain.User;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/loginCheck")
public class LoginCheckServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String mail=request.getParameter("mail");
        String password=request.getParameter("password");
        String isAdminUser=request.getParameter("isAdminUser");
        
        if("on".equals(isAdminUser)) {
        	//π‹¿Ì‘±µ«¬º
        	 AdminUser adminUser = AdminUserDaoImpl.getAdminUserByEmailAndPassword(mail, password);
        	 if(adminUser==null){
        		request.setAttribute("mail",mail);
     			request.getRequestDispatcher("login.jsp").forward(request, response);
        	 }else {
        		 request.getSession().setAttribute("adminUser",adminUser);
                 response.sendRedirect("home_admin.jsp");
        	 }
        }else {
            User user = UserDaoImpl.getUserByEmailAndPassword(mail, password);

            if(user==null){
                request.setAttribute("mail",mail);
    			request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                request.getSession().setAttribute("user",user);
                response.sendRedirect("home_admin.jsp");
            }
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
