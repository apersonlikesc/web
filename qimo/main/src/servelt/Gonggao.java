package servelt;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Info;
import dao.GonggaoDao;

/**
 * Servlet implementation class Gonggao
 */
@WebServlet("/Gonggao")
public class Gonggao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int step = 4;
	private String action;
	private GonggaoDao idao = new GonggaoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		action = request.getParameter("action");
		if(action.equals("add")) {
			addGonggao(request, response);
			request.getRequestDispatcher("gonggaopp.jsp").forward(request, response);
		}else	if(action.equals("all")) {
			int page = Integer.valueOf(request.getParameter("page"));	
			request.setAttribute("gonggaolist",sublist(page));
			request.setAttribute("pagelength",getpagelength(step));
			request.getRequestDispatcher("gonggaomm.jsp").forward(request, response);
		}
		else	if(action.equals("search")) {
			int page = Integer.valueOf(request.getParameter("page"));	
			String a = request.getParameter("class");
			request.setAttribute("class", a);
			request.setAttribute("gonggaolist",sublist2(page,a));
			request.setAttribute("pagelength",getpagelength2(step, a));
			request.getRequestDispatcher("gonggaomm.jsp").forward(request, response);
		}
		else if(action.equals("rm")) {
			idao.rmGonggao(request.getParameter("title"),Date.valueOf(request.getParameter("createdate")));
			request.setAttribute("gonggaolist",idao.getGonggaos());
			request.getRequestDispatcher("gonggaomm.jsp").forward(request, response);
		}else {
			System.out.println("操作失败");
		}
		
		}
		
		public boolean addGonggao(HttpServletRequest request, HttpServletResponse response) 
		{
			String title = request.getParameter("title");
			Date createdate = Date.valueOf(request.getParameter("createdate"));
			String class1 = request.getParameter("class");
			String info = request.getParameter("info");
			Info gg = new Info();
			gg.setTitle(title);
			gg.setCreatedate(createdate);
			gg.setInfo_class(class1);
			gg.setInfo(info);
		
		
			if(idao.addGonggao(gg)) {
				System.out.println("添加公告信息成功");
				return true;
			}else {
				return false;
			}
		}
		public int getpagelength(int step) {
			ArrayList<Info> list = idao.getGonggaos();
			int length = list.size();
			return (length%step)==0?(length/step):(length/step+1);
		}
		public int getpagelength2(int step,String a) {
			ArrayList<Info> list = idao.getGonggaosbyclass(a);
			int length = list.size();
			return (length%step)==0?(length/step):(length/step+1);
		}
		public ArrayList<Info>sublist(int page){
			ArrayList<Info> list = new ArrayList<Info>();
			ArrayList<Info> list2 = new ArrayList<Info>();
			list = idao.getGonggaos();
			if((page-1)*step+step < list.size()) {
				for(int i = (page-1)*step;i<(page-1)*step+step;i++) {
					list2.add(list.get(i));
				}
			}else {
				for(int i = (page-1)*step;i<list.size();i++) {
					list2.add(list.get(i));
				}
			}
			return list2;
		}
	

public ArrayList<Info>sublist2(int page,String a){
	ArrayList<Info> list = new ArrayList<Info>();
	ArrayList<Info> list2 = new ArrayList<Info>();
	list = idao.getGonggaosbyclass(a);
	if((page-1)*step+step < list.size()) {
		for(int i = (page-1)*step;i<(page-1)*step+step;i++) {
			list2.add(list.get(i));
		}
	}else {
		for(int i = (page-1)*step;i<list.size();i++) {
			list2.add(list.get(i));
		}
	}
	return list2;
}
}
