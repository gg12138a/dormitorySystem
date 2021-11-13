package Servlet;



import javax.servlet.*;
import javax.servlet.http.*;

import db.impl.UserDaoImpl;
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

        
        User user = UserDaoImpl.getUserByEmailAndPassword(mail, password);

        if(user==null){
            request.getSession().setAttribute("mail",mail);
            response.sendRedirect("login.jsp");
        }
        else{
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("home_admin.jsp").forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
