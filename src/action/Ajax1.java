package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Zhuce;
import po.Xiadan;
import util.Daohibernate;

public class Ajax1 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String userid=request.getParameter("userid");
		Zhuce zhuce=new Zhuce();
		Daohibernate d=new Daohibernate();
		zhuce=d.findZhuceById(userid);
		
		
		if(zhuce==null)
			out.print("");
		else
			out.print(zhuce.getZxm()+"//"+zhuce.getZlou()+"//"+zhuce.getZsushe());
	       
	
		
	}
}