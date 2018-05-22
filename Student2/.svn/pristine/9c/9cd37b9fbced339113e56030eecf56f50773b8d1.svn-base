package StudentEnity;

import java.util.List;

public class Pages {
	private int totalCount;
	private int pageSize;
	private int totalPage;
	private List<Student> students;
	private int currentPage;
	
	public Pages() {
		
	}
	public Pages(int totalCount,int pageSize, int currentPage, List<Student> students) {
		
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.students = students;
		this.currentPage = currentPage;
	}
	public Pages(int totalCount, int totalPage, int pageSize, int currentPage, List<Student> students) {
		
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.students = students;
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		this.totalPage=((this.totalCount % this.pageSize)==0) ? this.totalCount/this.pageSize :this.totalCount/this.pageSize+1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
