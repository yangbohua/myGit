package StudentServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentEnity.Pages;
import StudentEnity.Student;
import StudentService.impl.StudentServiceimpl;


public class pageStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Pages pg=new Pages();
		
		StudentServiceimpl stu=new StudentServiceimpl();
		int count=stu.getTotalCount();
		
		List<Student> students=new ArrayList<Student>();
		int pageSize=3;
		int currentPage;
		if(request.getParameter("currentPage")==null)
		{
			currentPage=0;
		}else
		{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		students=stu.getPageStudent(pageSize, currentPage);
		
		pg.setStudents(students);
		pg.setPageSize(pageSize);
		pg.setCurrentPage(currentPage);
		pg.setTotalCount(count);
		
		request.setAttribute("Pg", pg);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
