package StudentDao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import StudentDao.IStudentDao;
import StudentEnity.Student;
import StudentUtil.DBUtil;

public class StudentDao implements IStudentDao {
	
	DBUtil db=new DBUtil();
	public boolean updateStudent(int sno,Student student)
	{
		String sql="update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] obj={student.getSname(),student.getSage(),student.getSaddress(),sno};
		return db.executeUpdate(sql, obj);
		
		/*Connection connection=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="update student set sname=?,sage=?,saddress=? where sno=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(4, sno);
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getSaddress());
			int result=pstmt.executeUpdate();
			if(result>0)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return false ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return false ;
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}
		finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}
		*/
	}
	public List<Student> queryAllStudent()
	{
		List<Student> students=new ArrayList<Student>();
		String sql="select sno,sname,sage,saddress from student";
		ResultSet rst=db.executeQuery(sql,null);
		try {
			while(rst.next())
			{
				Student stu=new Student(rst.getInt("sno"),rst.getString("sname"),rst.getInt("sage"),rst.getString("saddress"));
				students.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally
		{
			try 
			{
				if(db.rs!=null)db.rs.close();
				if(db.pstmt!=null)db.pstmt.close();
				if(db.connection!=null)db.connection.close();
				if(rst!=null)rst.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return students;
		/*List<Student> students=new ArrayList<Student>();
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="select sno,sname,sage,saddress from student";
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				
				int ss=rs.getInt("sno");
				String sname=rs.getString("sname");
				int sage=rs.getInt("sage");
				String saddress=rs.getString("saddress");
				Student stu=new Student(ss,sname,sage,saddress);
				students.add(stu);
			}
			return students;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			 return null; 
		} catch (SQLException e) {
			e.printStackTrace();
			 return null; 
		}catch (Exception e) {
			e.printStackTrace();
			 return null; 
		}
		finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}*/
	
	}
	public boolean deleteStudent(int sno)
	{
		String sql="delete from student where sno=?";
		Object[] obj={sno};
		return db.executeUpdate(sql, obj);
		/*Connection connection=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="delete from student where sno=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			int result=pstmt.executeUpdate();
			if(result>0)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return false ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return false ;
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}
		finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}*/
	}
	public boolean addStudent(Student student) 
	{
		String sql="insert into student values(?,?,?,?)";
		Object[] obj= {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return db.executeUpdate(sql, obj);
		/*Connection connection=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="insert into student values(?,?,?,?)";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSage());
			pstmt.setString(4, student.getSaddress());
			int result=pstmt.executeUpdate();
			if(result>0)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return false ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return false ;
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}
		finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}*/
	}
	
	public boolean isExist (int sno)
	{
		return (queryStudent(sno)==null)? false:true;
		
	}
	
	public Student queryStudent(int sno)
	{
		Student stu=null;
		String sql="select * from student where sno=?";
		Object[] obj= {sno};
		ResultSet rst=db.executeQuery(sql,obj);
		try {
			while(rst.next())
			{
				
				stu=new Student(rst.getInt("sno"),rst.getString("sname"),rst.getInt("sage"),rst.getString("saddress"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally 
		{
			try
			{
				if(db.rs!=null)db.rs.close(); 
				if(db.pstmt!=null)db.pstmt.close(); 
				if(db.connection!=null)db.connection.close(); 
				if(rst!=null)rst.close(); 
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return stu;
		/*Student student=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql="select * from student where sno=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				
				int ss=rs.getInt("sno");
				String sname=rs.getString("sname");
				int sage=rs.getInt("sage");
				String saddress=rs.getString("saddress");
				student=new Student(ss,sname,sage,saddress);
				
			}
			return student;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			  return null ;
		} catch (SQLException e) {
			e.printStackTrace();
			  return null ;
		}catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
		finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}*/
	}
	
	public int getTotalCount()
	{
		String sql="select count(*) from student";
		int result=db.getTotalCount(sql, null);
		return result;
	}
	
	public List<Student> getPageStudent(int pageSize,int currentPage)
	{
		List<Student> students=new ArrayList<Student>();
		ResultSet rst=null;
			try {
				String sql="select * from student limit ?,?";
				Object[] obj= {currentPage*pageSize,pageSize};
				rst=db.executeQuery(sql, obj);
			
				
				while(rst.next())
				{
					Student student=new Student(rst.getInt("sno"),rst.getString("sname"),rst.getInt("sage"),rst.getString("saddress"));
					students.add(student);
				}
				return students;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally 
			{
				try 
				{
					if(db.rs!=null)db.rs.close();
					if(db.pstmt!=null)db.pstmt.close();
					if(db.connection!=null)db.connection.close();
					if(rst!=null)rst.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			
			
		
	}
}
