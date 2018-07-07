package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;

/**
 * Servlet implementation class Ss
 */
@WebServlet("/Ss")
public class Ss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int step = 4;
	private String action;
	private StudentDao idao = new StudentDao();
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
		addStudent(request, response);
		request.getRequestDispatcher("stdpp.jsp").forward(request, response);
	}else if(action.equals("all")) {
		int page = Integer.valueOf(request.getParameter("page"));	
		request.setAttribute("studentlist",sublist(page));
		request.setAttribute("pagelength",getpagelength(step));
		request.getRequestDispatcher("stdmm.jsp").forward(request, response);
	}else if(action.equals("search")) {
		int page = Integer.valueOf(request.getParameter("page"));	
		String sex = request.getParameter("sex");
		
		String username= "";
		if(request.getParameter("username")!=""){
			username=request.getParameter("username");
			request.setAttribute("username", username);
		}
		request.setAttribute("sex", sex);
		request.setAttribute("studentlist",sublist2(page,username,sex));
		request.setAttribute("pagelength",getpagelength2(step,username,sex));
		request.getRequestDispatcher("stdmm.jsp").forward(request, response);
	}
	else if(action.equals("change")) {//将要修改掉的元数据传到修改的界面
		String username = request.getParameter("username");
		request.setAttribute("onestudent", idao.getstudentbyusername(username));
		request.getRequestDispatcher("changestudent.jsp").forward(request, response);
	}else if(action.equals("change2")) {//修改数据
		changestudent(request, response);
		request.getRequestDispatcher("stdmm.jsp").forward(request, response);
	}else if(action.equals("rm")) {
		idao.rmStudent((String)request.getParameter("username"));
		request.setAttribute("studentlist",idao.getStudents());
		request.getRequestDispatcher("stdmm.jsp").forward(request, response);
	}else {
		System.out.println("操作失败");	
	}
	
	}
	
	public boolean addStudent(HttpServletRequest request, HttpServletResponse response) 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String title = request.getParameter("title");
		String head = request.getParameter("head");
		String realname = request.getParameter("realname");
		String education = request.getParameter("education");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String stdinfo = request.getParameter("stdinfo");
		String tel = request.getParameter("tel");
		Student std = new Student();
		std.setAge(Integer.parseInt(age));
		std.setEducation(education);
		std.setEmail(email);
		std.setPassword(password);
		std.setRealname(realname);
		std.setSex(sex);
		std.setHead(head);
		std.setTel(tel);
		std.setStdinfo(stdinfo);
		std.setTitle(title);
		std.setUsername(username);
	
		if(idao.addStudent(std)) {
			System.out.println("添加学生信息成功");
			return true;
		}else {
			return false;
		}
	}
	public int getpagelength(int step) {
		ArrayList<Student> list = idao.getStudents();
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Student> sublist(int page){
		ArrayList<Student> list = new ArrayList<Student>();
		ArrayList<Student> list2 = new ArrayList<Student>();
		list = idao.getStudents();
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
	public int getpagelength2(int step,String username,String sex) {
		ArrayList<Student> list = idao.getStudentsbyusername2(username, sex);
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Student> sublist2(int page,String username,String sex){
		ArrayList<Student> list = new ArrayList<Student>();
		ArrayList<Student> list2 = new ArrayList<Student>();
		list = idao.getStudentsbyusername2(username, sex);
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
	public boolean changestudent(HttpServletRequest request, HttpServletResponse response) 
	{
		Student std = new Student();
		std.setUsername(request.getParameter("username"));
		if(request.getParameter("education")!=null) {String education = request.getParameter("education");
		std.setEducation(education);}
		if(request.getParameter("password")!=null) {String password = request.getParameter("password");
		std.setPassword(password);}
		if(request.getParameter("stdinfo")!=null) {String stdinfo = request.getParameter("stdinfo");
		std.setStdinfo(stdinfo);}
		if(request.getParameter("sex")!=null) {String sex = request.getParameter("sex");			
		std.setSex(sex);}
		if(request.getParameter("age")!=null) {int age = Integer.valueOf(request.getParameter("age"));			
		std.setAge(age);}
		if(request.getParameter("title")!=null) {String title = request.getParameter("title");			
		std.setTitle(title);}
		if(request.getParameter("head")!=null) {String head = request.getParameter("head");			
		std.setHead(head);}
		if(request.getParameter("tel")!=null) {String tel= request.getParameter("tel");
		std.setTel(tel);}
		if(request.getParameter("email")!=null) {String email= request.getParameter("email");
		std.setEmail(email);}
		if(request.getParameter("realname")!=null) {String realname= request.getParameter("realname");
		std.setRealname(realname);}
		if(idao.changeStudent(std)) {
			System.out.println("修改学生信息成功");
			return true;
		}else {
			return false;
		}
	}
}
	