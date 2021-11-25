package com.jbk.jdbc;

import java.sql.ResultSet;
import java.util.Scanner;

import com.jbk.jdbc.entity.Employee;
import com.jbk.jdbc.service.EmployeeService;

public class Test {

	EmployeeService service = new EmployeeService();

	public void getAllEmployee() {

		ResultSet resultSet = service.getAllEmployee();

		try {
			while (resultSet.next()) {
				System.out.print(resultSet.getLong("employeeId") + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.println(resultSet.getDouble(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveEmployee(Employee employee) {
		int result = service.saveEmployee(employee);
		System.out.println(result);
		if (result > 0) {
			System.out.println("Inserted");
		} else {
			System.out.println("Not inserted");
		}
	}

	public void deleteEmployee(int id) {

		int result = service.deleteEmployee(id);
		if (result > 0) {
			System.out.println(result + " Recoed" + "Deleted");
		} else {
			System.out.println("NOt Deleted");
		}
	}

	public void updateEmployee(Employee employee) {

		int res = service.updateEmployee(employee);

		if (res > 0) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

	public static void main(String[] args) {

		Test test = new Test();
		Scanner scanner=new Scanner(System.in);
		
		char ch = 0;
		int choice=0;
		do {
			System.out.println("1.Get All Employee");
			System.out.println("2.Save");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			
			choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				test.getAllEmployee();
				break;
			case 2:
				Employee employee=new Employee(109,"pqr",45645);
				test.saveEmployee(employee);
				break;
				
			case 3:
				Employee employee2=new Employee(109,"lkj",45645);

				test.updateEmployee(employee2);
				break;
				
			case 4:
				int id=scanner.nextInt();
				test.deleteEmployee(id);
				break;

			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println(" Do You Want To Continue y/n");
			ch=scanner.next().charAt(0);

		} while (ch=='y');

System.out.println("terminated");
	}

}
