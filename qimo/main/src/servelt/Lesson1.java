package servelt;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Lesson;
import dao.LessonDao;

/**
 * Servlet implementation class Lesson
 */
@WebServlet("/Lesson1")
public class Lesson1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action;
	private int step = 4;
	private LessonDao idao = new LessonDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lesson1() {
     
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
		if(action.equals("add")) {
			addlesson(request, response);
			request.getRequestDispatcher("lespp.jsp").forward(request, response);
		}else if(action.equals("all")){
			int page = Integer.valueOf(request.getParameter("page"));	
			request.setAttribute("loglist",sublist(page));
			request.setAttribute("pagelength",getpagelength(step));
			request.getRequestDispatcher("lesall.jsp").forward(request, response);
		}
		else if(action.equals("search")){
			int page = Integer.valueOf(request.getParameter("page"));	
			String type = request.getParameter("class");
			request.setAttribute("class",type);
			String lessonname= "";
			if(request.getParameter("lessonname")!=""){
				lessonname=request.getParameter("lessonname");
				request.setAttribute("lessonname", lessonname);
			}
			request.setAttribute("loglist",sublist2(page,lessonname,type));
			request.setAttribute("pagelength",getpagelength2(step,lessonname,type));
			request.getRequestDispatcher("lesall.jsp").forward(request, response);
		}
		else if(action.equals("rm")) {
			idao.rmlesson(Integer.valueOf(request.getParameter("lessonnum")));
			request.setAttribute("loglist",idao.getlessons());
			request.getRequestDispatcher("lesall.jsp").forward(request, response);
		}else if(action.equals("change")) {//将要修改掉的元数据传到修改的界面
			int index = Integer.valueOf(request.getParameter("lessonnum"));
			request.setAttribute("onelesson", idao.getlessonsbynum(index));
			request.getRequestDispatcher("changelesson.jsp").forward(request, response);
		}else if(action.equals("change2")) {//修改数据
			changelesson(request, response);
			request.getRequestDispatcher("lesall.jsp").forward(request, response);
		}
		else {
			System.out.println("操作失败");
		}
		
		}
		
		public boolean addlesson(HttpServletRequest request, HttpServletResponse response) 
		{
			String lessonclass = request.getParameter("lessonclass");
			String lessonname = request.getParameter("lessonname");
			String lessoninfo = request.getParameter("lessoninfo");
			String teacher = request.getParameter("teacher");
			String pic = request.getParameter("head");
			Lesson lesson = new Lesson();
			Date lessonbg = Date.valueOf(request.getParameter("lessonbg"));
			Date lessonend = Date.valueOf(request.getParameter("lessonend"));
			lesson.setLessbg(lessonbg);
			lesson.setPic(pic);
			lesson.setLessend(lessonend);
			lesson.setLessinfo(lessoninfo);
			lesson.setLessonclass(lessonclass);
			lesson.setTeacher(teacher);
			lesson.setLessonname(lessonname);
			if(idao.addLesson(lesson)) {
				System.out.println("添加学生信息成功");
				return true;
			}else {
				return false;
			}
		}
		public boolean changelesson(HttpServletRequest request, HttpServletResponse response) 
		{
			Lesson lesson = new Lesson();
			lesson.setLessonnum(Integer.valueOf(request.getParameter("lessonnum")));
			if(request.getParameter("lessonclass")!=null) {String lessonclass = request.getParameter("lessonclass");
			lesson.setLessonclass(lessonclass);}
			if(request.getParameter("lessonname")!=null) {String lessonname = request.getParameter("lessonname");
			lesson.setLessonname(lessonname);}
			if(request.getParameter("lessoninfo")!=null) {String lessoninfo = request.getParameter("lessoninfo");
			lesson.setLessinfo(lessoninfo);}
			if(request.getParameter("teacher")!=null) {String teacher = request.getParameter("teacher");			
			lesson.setTeacher(teacher);}
			if(request.getParameter("head")!=null) {String pic = request.getParameter("head");			
			lesson.setPic(pic);}
			if(request.getParameter("lessonbg")!=null) {Date lessonbg = Date.valueOf(request.getParameter("lessonbg"));
			lesson.setLessbg(lessonbg);}
			if(request.getParameter("lessonend")!=null) {Date lessonend = Date.valueOf(request.getParameter("lessonend"));
			lesson.setLessend(lessonend);}
			if(idao.changeLesson(lesson)) {
				System.out.println("修改课程信息成功");
				return true;
			}else {
				return false;
			}
		}
		public int getpagelength(int step) {
			ArrayList<Lesson> list = idao.getlessons();
			int length = list.size();
			return (length%step)==0?(length/step):(length/step+1);
		}
		public ArrayList<Lesson> sublist(int page){
			ArrayList<Lesson> list = new ArrayList<Lesson>();
			ArrayList<Lesson> list2 = new ArrayList<Lesson>();
			list = idao.getlessons();
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
		public int getpagelength2(int step,String lessonname,String type) {
			ArrayList<Lesson> list = idao.getlessonsbyname(lessonname, type);
			int length = list.size();
			return (length%step)==0?(length/step):(length/step+1);
		}
		public ArrayList<Lesson> sublist2(int page,String lessonname,String type){
			ArrayList<Lesson> list = new ArrayList<Lesson>();
			ArrayList<Lesson> list2 = new ArrayList<Lesson>();
			list = idao.getlessonsbyname(lessonname, type);
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
		