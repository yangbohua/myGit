package StudentService;

import java.util.List;

import StudentEnity.Student;

public interface IStudentService {
	public boolean addStudent(Student student);
	
	public Student queryStudent(int sno);
	public boolean deleteStudent(int sno);
	public List<Student> queryAllStudent();
	public boolean updateStudent(int sno,Student student);
	public int getTotalCount();
	public List<Student> getPageStudent(int pageSize,int currentPage);
}
