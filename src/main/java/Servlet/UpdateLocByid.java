package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import db.impl.UserDaoImpl;

/**
 * Servlet implementation class UpdateLocByid
 */
@WebServlet("/updateLocByid")
public class UpdateLocByid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLocByid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parsedid=request.getParameter("parsedid");
		String id=parsedid.substring(4);
		String newloc=request.getParameter("newloc");
		
		if(newloc.length()>4){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(JSON.toJSONString(-1));
		}
		else {
			int res=UserDaoImpl.updateLocWithIdAndNewloc(id,newloc);
			if(res==1) {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append(JSON.toJSONString(1));
			}else if(res==-1) {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append(JSON.toJSONString(-1));
			}
			else {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append(JSON.toJSONString(0));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
