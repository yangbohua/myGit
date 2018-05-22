package StudentServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentEnity.Student;
import StudentService.IStudentService;
import StudentService.impl.StudentServiceimpl;

/**
 * Servlet implementation class updateStudentServlet
 */
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno=Integer.parseInt(request.getParameter("sno"));
		String sname=request.getParameter("sname");
		int sage=Integer.parseInt(request.getParameter("sage"));
		String saddress=request.getParameter("saddress");
		Student student=new Student(sno,sname,sage,saddress);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		IStudentService stu=new StudentServiceimpl();
		boolean result=stu.updateStudent(sno, student);
		if(result)
		{
			response.getWriter().println("修改成功！");
			response.sendRedirect("pageStudentServlet");
		}else
		{
			
			request.setAttribute("updateError", "error");
			request.getRequestDispatcher("pageStudentServlet").forward(request, response);
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
