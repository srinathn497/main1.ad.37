package com.ems.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.bo.DeleteBO;
import com.ems.bo.DeleteBOImpl;
import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.DeleteVO;

/**
 * @author Srinath
 *
 */

public class DeleteController {

	private DeleteBO deletebo;
	private EmployeeDAO employeeDAO;// HAS A RELATION

	/**
 * 
 */

	public DeleteController() {
		deletebo = new DeleteBOImpl();
		employeeDAO = new EmployeeDAOImpl();

	}

	/**
	 * @throws Exception
	 * 
	 */

	public void deleteEmp() {

		String methodName = "deleteEmployeeDetails()";
		System.out.println("Method Invoked:" + methodName);
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Number to search");
			int empNumber = scanner.nextInt();
			DeleteVO valueObject = new DeleteVO();
			valueObject.setEmpNumber(empNumber);
			boolean searchFlag = deletebo.checkEmpExistence(valueObject
					.getEmpNumber());
			if (searchFlag) {
				// System.out.println("Employee Record Registered Successfully");
				// code to display data
				int myEmpList = employeeDAO.deleteEmp(valueObject
						.getEmpNumber());
				System.out.println("Deleted");

				System.out
						.println("**********************************************");
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (EMSException e) {
			System.err.println("Exception Caught In Controller:"
					+ e.getMessage());
		} catch (EMSBusinessException e) {
			System.err.println("Exception Caught In Controller:"
					+ e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
