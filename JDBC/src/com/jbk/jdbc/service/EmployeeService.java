package com.jbk.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jbk.jdbc.config.DbConnection;
import com.jbk.jdbc.entity.Employee;

public class EmployeeService {

	public ResultSet getAllEmployee() {
		ResultSet resultSet = null;
		Connection connection = DbConnection.getConnection();

		try {
			// make connection
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
			resultSet = preparedStatement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultSet;

	}

	public int saveEmployee(Employee employee) {
		int result = 0;
		Connection connection = DbConnection.getConnection();

		try {
			// make connection

			// write query
			String sql = "INSERT INTO employee(employeeId,employeeName,employeeSalary)" + "VALUES(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, employee.getEmployeeId());// pass values
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setDouble(3, employee.getEmployeeSalary());

			// excute Query
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int deleteEmployee(int employeeId) {
		int result = 0;
		Connection connection = DbConnection.getConnection();

		// make connection
		String sql = "DELETE FROM employee WHERE employeeId=?";
		try {
			// write query
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, employeeId);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	public int updateEmployee(Employee employee) {
		System.out.println(employee);

		// make connection
		int result=0;
		Connection connection = DbConnection.getConnection();
		String sql = "update employee SET employeeSalary=? WHERE employeeId=? and employeeName=?";

		// prepare query
		try {
		PreparedStatement preparedStatement=	connection.prepareStatement(sql);
		preparedStatement.setDouble(1, employee.getEmployeeSalary());
		preparedStatement.setLong(2, employee.getEmployeeId());
		preparedStatement.setString(3, employee.getEmployeeName());
		
		//execute query
	 result=	preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
