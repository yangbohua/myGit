<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			out.print("增加失败,请重新增加");
		}
	%>
	
	<form action="addStudentServlet">
		学号：<input type="text" name="sno"/><br/>
		姓名：<input type="text" name="sname"/><br/>
		年龄：<input type="text" name="sage"/><br/>
		地址：<input type="text" name="saddress"/><br/>
		<input type="submit" value="新增"/>
	</form>
	
</body>
</html>