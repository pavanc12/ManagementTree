package com.kiwiplan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The ManagementTree class implements an application that
 * displays Management Tree of the given list of employees in the console.
 * This is a stand-alone application which can be run through the terminal.
 * 
 * @author pavan
 *
 */
public class ManagementTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Employee input list
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1L,"Tom",0L));
		employeeList.add(new Employee(2L,"Mickey",1L));
		employeeList.add(new Employee(3L,"Jerry",1L));
		employeeList.add(new Employee(4L,"John",2L));
		employeeList.add(new Employee(5L,"Sarah",1L));
		
		// Alternative Employee input list
		List<Employee> employeeList1 = new ArrayList<Employee>();
		employeeList1.add(new Employee(1L,"Jerry",0L));
		employeeList1.add(new Employee(2L,"Stacie",1L));
		employeeList1.add(new Employee(3L,"Philip",1L));
		employeeList1.add(new Employee(4L,"Tom",2L));
		employeeList1.add(new Employee(5L,"Mike",4L));
		employeeList1.add(new Employee(6L,"John",5L));
		employeeList1.add(new Employee(7L,"Alice",4L));
		employeeList1.add(new Employee(8L,"Key",2L));
		employeeList1.add(new Employee(9L,"Peter",8L));
		employeeList1.add(new Employee(10L,"David",2L));
		
		ManagementTree test = new ManagementTree();
		test.displayManagementTree(employeeList1);		
	}
	
	/*
	 * This method takes a list of employees and displays employees according to the management tree
	 */
	private void displayManagementTree(List<Employee> employeesList) {
		// Group employees by managerId
		Map<Long, List<Employee>> employeesMapByManagerId = employeesList.stream().collect(Collectors.groupingBy(Employee::getManagerId));
		// Start with Root manager
		Employee rootManager = employeesMapByManagerId.get(0L).get(0);
		Long managerEmpId = rootManager.employeeId;
		String indentation = "->";
		System.out.println(indentation+rootManager.employeeName);	
		// Process all the employees under Root manager
		processEmployees(managerEmpId,employeesMapByManagerId,indentation+"->");				
	}	
	
	/**
	 * This method processes all the employees under specified manager
	 * @param managerEmpId
	 * @param employeesMapByManagerId
	 * @param indentation
	 */
	private void processEmployees(Long managerEmpId, Map<Long, List<Employee>> employeesMapByManagerId, String indentation) {
		List<Employee> employeeList = employeesMapByManagerId.get(managerEmpId);
		for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();				
			if(employeesMapByManagerId.containsKey(employee.employeeId)) {
				System.out.println(indentation+employee.employeeName);
				processEmployees(employee.employeeId,employeesMapByManagerId,indentation+"->");
			} else {
				System.out.println(indentation+employee.employeeName);				
			}
		}
	}
}

/*
 * This is a POJO Class to hold Employee details
 */
class Employee {	
	Long employeeId;	
	String employeeName;
	Long managerId;
		
	/**
	 * Constructor using all the fields
	 * @param employeeId
	 * @param employeeName
	 * @param managerId
	 */
	public Employee(Long employeeId, String employeeName, Long managerId) {		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.managerId = managerId;
	}
	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the managerId
	 */
	public Long getManagerId() {
		return managerId;
	}
	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
}
