package StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentService.IStudentService;
import StudentService.impl.StudentServiceimpl;

/**
 * Servlet implementation class deleteStudentServlet
 */
public class deleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno=Integer.parseInt(request.getParameter("sno"));
		IStudentService stu=new StudentServiceimpl();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		boolean result=stu.deleteStudent(sno);
		PrintWriter out=response.getWriter();
		if(result)
		{
			out.print("删除成功");
			response.sendRedirect("pageStudentServlet");
		}else {
			response.getWriter().print("删除失败");
			//request.setAttribute("deleteError", "error");
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
