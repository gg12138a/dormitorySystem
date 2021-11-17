package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.alibaba.fastjson.JSON;

import db.DbUtils;
import db.impl.ApplyDaoImpl;
import db.impl.DormitoryDaoImpl;
import db.impl.UserDaoImpl;

/**
 * Servlet implementation class AgreeApplyById
 */
@WebServlet("/agreeApplyById")
public class AgreeApplyById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgreeApplyById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parsedid=request.getParameter("parsedid");
        String aid=parsedid.substring(6);
      
        int peopleCount=DormitoryDaoImpl.getPeopleCountByApplyId(aid);
        
        if(peopleCount<4) {
        	DataSourceTransactionManager tm = DbUtils.getTransactionManager();
        	TransactionStatus tran = tm.getTransaction(null);
        	
        	int updateUserRes = UserDaoImpl.updateUserLocByAid(aid);
            int updateApplyRes = ApplyDaoImpl.agreeApplyById(aid);
            
            if(updateUserRes==1 && updateApplyRes==1) {
            	tm.commit(tran);
            	response.setCharacterEncoding("UTF-8");
        		response.getWriter().append(JSON.toJSONString(1));
            }
            else {
            	tm.rollback(tran);
            	response.setCharacterEncoding("UTF-8");
        		response.getWriter().append(JSON.toJSONString(0));
            }
        }
        else {
        	response.setCharacterEncoding("UTF-8");
    		response.getWriter().append(JSON.toJSONString(0));
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
