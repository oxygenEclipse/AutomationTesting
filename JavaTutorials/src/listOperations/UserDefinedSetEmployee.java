package listOperations;

import java.util.HashSet;
import java.util.Scanner;

public class UserDefinedSetEmployee {
	public static void main(String[] args) {
		Scanner empInput = new Scanner(System.in);
		HashSet<Employee> employee = new HashSet<Employee>();
		for (int i = 1; i <=2; i++) {
			String empId = empInput.nextLine();
			String empName = empInput.nextLine();
			int phone = empInput.nextInt();
			String address = empInput.nextLine();
			String dob = empInput.nextLine();
			String doj = empInput.nextLine();
			String email = empInput.nextLine();
			String gender = empInput.nextLine();
			String sal = empInput.nextLine();
			employee.add(new Employee(empId, empName, phone, address, dob, doj, email, gender, sal));
			System.out.println("Enter next Employee Details: ");
		}
		empInput.close();
		System.out.println(employee);
	}
}
class Employee {
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", phone=" + phone + ", address=" + address
				+ ", dob=" + dob + ", doj=" + doj + ", email=" + email + ", gender=" + gender + ", sal=" + sal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
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
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

	String empId;
	String empName;
	int phone;
	String address;
	String dob;
	String doj;
	String email;
	String gender;
	String sal;

	public Employee(String empId, String empName, int phone, String address, String dob, String doj, String email,
			String gender, String sal) {
		this.empId = empId;
		this.empName = empName;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
		this.doj = doj;
		this.email = email;
		this.gender = gender;
		this.sal = sal;
	}
}
