package StudentDao;

import java.util.List;

import StudentEnity.Student;

public interface IStudentDao {
	public boolean updateStudent(int sno,Student student);
	public List<Student> queryAllStudent();
	public boolean deleteStudent(int sno);
	public boolean addStudent(Student student);
	
	public boolean isExist (int sno);
	//根据学号查询学生
	public Student queryStudent(int sno);
	//查询学生总数
	public int getTotalCount();
	public List<Student> getPageStudent(int pageSize,int currentPage);
}