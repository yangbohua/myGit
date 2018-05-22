package StudentService.impl;

import java.util.List;

import StudentDao.IStudentDao;
import StudentDao.impl.StudentDao;
import StudentEnity.Student;
import StudentService.IStudentService;

public class StudentServiceimpl implements IStudentService {
	IStudentDao stu=new StudentDao();
	public int getTotalCount()
	{
		
		return stu.getTotalCount();
	}

	public List<Student> getPageStudent(int pageSize,int currentPage)
	{
		return stu.getPageStudent(pageSize, currentPage);
	
	}
	public boolean addStudent(Student student)
	{
		
		if(!(stu.isExist(student.getSno())))
		{	
			System.out.println("用户创建成功");
			return stu.addStudent(student);
		
		}else
		{
			System.out.println("用户已存在");
			return false;
		}
	}
	
	public Student queryStudent(int sno)
	{
		
		return stu.queryStudent(sno);
	}
	public boolean deleteStudent(int sno)
	{
		
		if(stu.isExist(sno))
		{
			System.out.println("删除成功");
			return stu.deleteStudent(sno);
		}else {
			System.out.println("查无此人，删除失败");
			return false;
		}
		
	}
	public List<Student> queryAllStudent()
	{
		
		List<Student> students=stu.queryAllStudent();
		return students;
		//return StudentDao.queryAllStudent();
	}
	
	public boolean updateStudent(int sno,Student student)
	{
		
		if(stu.isExist(sno))
		{
			System.out.println("修改成功");
			return stu.updateStudent(sno, student);
		}else
		{
			System.out.println("查无此人，修改数据失败");
			return false;
		}
		
	}
}
