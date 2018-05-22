package StudentUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import StudentEnity.Student;
public class DBUtil {
	static final String DRIVER="com.mysql.jdbc.Driver";
	static String URL="jdbc:mysql://localhost:3306/test";
	static String USERNAME="root";
	static String PASSWORD="123456";
	
	public Connection connection=null;
	public PreparedStatement pstmt=null;
	public ResultSet rs=null;
	
	public Connection getConnection()
	{
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public PreparedStatement getPreparedStatement(String sql,Object[] obj)
	{
		try {
			pstmt=getConnection().prepareStatement(sql);
			if(obj!=null)       
			{
				for(int i=0;i<obj.length;i++) 
				{
					pstmt.setObject(i+1, obj[i]);
				}
			}
			return pstmt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void closeAll(ResultSet rs,Statement stmt,Connection connection)
	{
		
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	public int getTotalCount(String sql,Object[] obj)
	{
		int count=-1;
		ResultSet rs=null;
		try {
			pstmt=getPreparedStatement(sql,obj);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally 
		{
			closeAll(rs,pstmt,connection);
		}
		
	}
	public boolean executeUpdate(String sql,Object[] obj)
	{	
		
		try {
			//Class.forName(DRIVER);
			//Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//String sql="update student set sname=?,sage=?,saddress=? where sno=?";
			/*PreparedStatement pstmt=connection.prepareStatement(sql);
			if(obj!=null)       
			{
				for(int i=0;i<obj.length;i++) 
				{
					pstmt.setObject(i+1, obj[i]);
				}
			}*/
			pstmt=getPreparedStatement(sql,obj);
			/*pstmt.setInt(4, sno);
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getSaddress());
			*/
			int result=pstmt.executeUpdate();
			if(result>0)
			{
				return true;
			}else
			{
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			  return false ;
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}
		finally {
			closeAll(rs,pstmt,connection);
		}
	}
	
	
	public ResultSet executeQuery(String sql,Object[] obj)
	{
		
		try {
			//Class.forName(DRIVER);
			//Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			//String sql="select sno,sname,sage,saddress from student";
			/*PreparedStatement pstmt=connection.prepareStatement(sql);
			if(obj!=null)       
			{
				for(int i=0;i<obj.length;i++) 
				{
					pstmt.setObject(i+1, obj[i]);
				}
			}*/
			pstmt=getPreparedStatement(sql,obj);
			rs=pstmt.executeQuery();
			/*while(rs.next())
			{
				
				int ss=rs.getInt("sno");
				String sname=rs.getString("sname");
				int sage=rs.getInt("sage");
				String saddress=rs.getString("saddress");
				Student stu=new Student(ss,sname,sage,saddress);
				students.add(stu);
			}*/
			return rs;
		}catch (SQLException e) {
			e.printStackTrace();
			 return null; 
		}catch (Exception e) {
			e.printStackTrace();
			 return null; 
		}
		finally {
				/*try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} */
		}
		
	}
}
