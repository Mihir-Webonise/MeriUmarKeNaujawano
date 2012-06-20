package sqlite.list.project;

public class Employee {

	private long id;
	private int age;
	private String empName;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return "Name: "+empName+" Age: "+age;
	}

}
