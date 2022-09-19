package com.jbk.test;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbk.entity.Employee;



public class Test1 {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans1.xml");
		Employee employee =(Employee) context.getBean("employee");
		Employee employee1 =(Employee) context.getBean("employee");
		
		employee.setId(101);
		employee1.setId(102);
		
	    System.out.println(employee);
	    System.out.println(employee1);


	}

}
