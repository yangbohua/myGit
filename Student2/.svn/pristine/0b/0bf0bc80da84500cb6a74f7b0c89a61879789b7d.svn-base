<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="StudentEnity.Student" %>
<%@ page import="StudentEnity.Pages" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getAttribute("addError")!=null)
		{
			out.print("增加失败");
		}
		if(request.getAttribute("updateError")!=null)
		{
			out.print("修改失败");
		}
		if(request.getAttribute("deleteError")!=null)
		{
			out.print("删除失败");
		}
	%>
	<%
		
			//out.print("请选择每页显示多少数据：");
	%>
			<!-- <form action="pageStudentServlet">
				<select name="option">
				<option>3</option>
				<option>4</option>
				<option>5</option>
				</select>
				<input type="submit" value="提交"/>
			</form>
			 -->
			
	<%
	
	Pages pg=(Pages)request.getAttribute("Pg");
	List<Student> students=pg.getStudents();
	%>
			
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
	<%
		
		if(students!=null)
		{
			for(Student stu:students)
			{
	%>
	
		<tr>
			<td><a href="queryStudentServlet?sno=<%=stu.getSno() %>"><%=stu.getSno() %></a></td>
			<td><%=stu.getSname() %></td>
			<td><%=stu.getSage() %></td>
			<td><a href="deleteStudentServlet?sno=<%=stu.getSno() %>">删除</a></td>
		</tr>
	
	
	
	<% 
			}
		}
	%>
	</table>
	<br/>
	当前页数[<%=pg.getCurrentPage()+1  %>/<%=pg.getTotalPage()  %>]
	<%
		if(pg.getCurrentPage()==0)
		{
			%>
				<a href="pageStudentServlet?currentPage=<%=pg.getCurrentPage()+1 %>">下一页</a>
				<a href="pageStudentServlet?currentPage=<%=pg.getTotalPage()-1 %>">尾页</a>
			<%
		}else if(pg.getCurrentPage()== (pg.getTotalPage()-1))
		{
			%>
			<a href="pageStudentServlet?currentPage=0">首页</a>
			<a href="pageStudentServlet?currentPage=<%=pg.getCurrentPage()-1 %>">上一页</a>
			<% 
			
		}else
		{
			%>
			<a href="pageStudentServlet?currentPage=0">首页</a>
			<a href="pageStudentServlet?currentPage=<%=pg.getCurrentPage()-1 %>">上一页</a>
			<a href="pageStudentServlet?currentPage=<%=pg.getCurrentPage()+1 %>">下一页</a>
			<a href="pageStudentServlet?currentPage=<%=pg.getTotalPage()-1 %>">尾页</a>
			<% 
		}%><br/>
		<a href="addStudent.jsp">增加</a>
		<a href="queryAllStudentServlet">查看全部学生</a>
		
	
		
	
</body>
</html>