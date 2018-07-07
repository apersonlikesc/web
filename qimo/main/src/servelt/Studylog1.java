package servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Studylog;
import dao.StudylogDao;

/**
 * Servlet implementation class Studylog
 */
@WebServlet("/Studylog1")
public class Studylog1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int step = 4;
	private String action;
	private StudylogDao idao = new StudylogDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studylog1() {
        super();
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		action = request.getParameter("action");
		if(action.equals("all")) {
			int page = Integer.valueOf(request.getParameter("page"));	
			request.setAttribute("loglist",sublist(page));
			request.setAttribute("pagelength",getpagelength(step));
			request.getRequestDispatcher("stdcc.jsp").forward(request, response);
	}else if(action.equals("search")) {
		int page = Integer.valueOf(request.getParameter("page"));	
		String username = request.getParameter("username");
		request.setAttribute("username", username);
		request.setAttribute("loglist",sublist2(page,username));
		request.setAttribute("pagelength",getpagelength2(step,username));
		request.getRequestDispatcher("stdcc.jsp").forward(request, response);
}else{
		System.out.println("操作失败");
	}
}
	
	public int getpagelength(int step) {
		ArrayList<Studylog> list = idao.getlogs();
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Studylog>sublist(int page){
		ArrayList<Studylog> list = new ArrayList<Studylog>();
		ArrayList<Studylog> list2 = new ArrayList<Studylog>();
		list = idao.getlogs();
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
	public int getpagelength2(int step,String username) {
		ArrayList<Studylog> list = idao.getlogsbyusername(username);
		int length = list.size();
		return (length%step)==0?(length/step):(length/step+1);
	}
	public ArrayList<Studylog>sublist2(int page,String username){
		ArrayList<Studylog> list = new ArrayList<Studylog>();
		ArrayList<Studylog> list2 = new ArrayList<Studylog>();
		list = idao.getlogsbyusername(username);
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
