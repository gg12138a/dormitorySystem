package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import db.impl.ApplyDaoImpl;
import db.impl.UserDaoImpl;
import domain.Apply;

/**
 * Servlet implementation class GenerateApply
 */
@WebServlet("/generateApply")
public class GenerateApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateApply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String id=request.getParameter("id");
        String toLoc=request.getParameter("toLoc");
        
        List<Apply> applies = ApplyDaoImpl.getAppliesById(id);
        if(applies.size()==0 || applies.get(applies.size()-1).isReviewed()==true) {
        	int res=ApplyDaoImpl.insertApply(id,UserDaoImpl.getLocById(id),toLoc);
        	if(res==1) {
        		//插入成功
        		response.setCharacterEncoding("UTF-8");
        		response.getWriter().append(JSON.toJSONString(1));
        	}
        	else {
        		response.setCharacterEncoding("UTF-8");
        		response.getWriter().append(JSON.toJSONString(0));
        	}
        }
        else {
        	//存在未审核的记录
    		response.setCharacterEncoding("UTF-8");
    		response.getWriter().append(JSON.toJSONString(-1));
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
