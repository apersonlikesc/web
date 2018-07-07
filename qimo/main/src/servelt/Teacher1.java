package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;
import dao.TeacherDao;

/**
 * Servlet implementation class Teacher
 */
@WebServlet("/Teacher1")
public class Teacher1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int step = 4;
	private String action;
	private TeacherDao idao = new TeacherDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher1() {
        // TODO Auto-generated constructor stub
    }
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
		if(action.equals("all")) {
			int page = Integer.valueOf(request.getParameter("page"));	
			request.setAttribute("loglist",sublist(page));
			request.setAttribute("pagelength",getpagelength(step));
			request.getRequestDispatcher("stdall.jsp").forward(request, response);
	}else if(action.equals("search")) {
		int page = Integer.valueOf(request.getParameter("page"));	
		String name = "";
		if(request.getParameter("name")!=""){
			name=request.getParameter("name");
			request.setAttribute("name", name);
		}
		String sex =request.getParameter("sex");
		request.setAttribute("sex", sex);
		request.setAttribute("loglist",sublist2(page,name,sex));
		request.setAttribute("pagelength",getpagelength2(step,name,sex));
		request.getRequestDispatcher("stdall.jsp").forward(request, response);
}else{
		System.out.println("操作失败");
	}
}
	public int getpagelength(int step) {
		ArrayList<Teacher> list = idao.getteachers();
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Teacher>sublist(int page){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		ArrayList<Teacher> list2 = new ArrayList<Teacher>();
		list = idao.getteachers();
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
	public int getpagelength2(int step,String name,String sex) {
		ArrayList<Teacher> list = idao.getteachersbyname(name, sex);
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Teacher>sublist2(int page,String name,String sex){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		ArrayList<Teacher> list2 = new ArrayList<Teacher>();
		list = idao.getteachersbyname(name, sex);
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
