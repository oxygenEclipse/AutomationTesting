package listOperations;

import java.util.HashSet;

public class UserDefinedSetTest {

	public static void main(String[] args) {
		HashSet<TestEmployee> emp = new HashSet<TestEmployee>();
		emp.add(new TestEmployee(123,"ABC"));
		emp.add(new TestEmployee(456, "XYZ"));
		emp.add(new TestEmployee(123,"ABCD"));
		System.out.println(emp);
	}
}
class TestEmployee {
	int empId;
	String empName;
	public TestEmployee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "TestEmployee [empId=" + empId + ", empName=" + empName + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestEmployee other = (TestEmployee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}
	
}
