package com.ems.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ems.bo.SearchBO;
import com.ems.bo.SearchBOImpl;
import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;
import com.ems.vo.SearchVO;

/**
 * @author Srinath
 *
 */

public class SearchController {

	private SearchBO searchbo;
	private EmployeeDAO employeeDAO;// HAS A RELATION

	/**
 * 
 */

	public SearchController() {
		searchbo = new SearchBOImpl();
		employeeDAO = new EmployeeDAOImpl();

	}

	/**
	 * @throws Exception
	 * 
	 */

	public void searchDetails() {

		String methodName = "readEmployeeDetails()";
		System.out.println("Method Invoked:" + methodName);
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Number to search");
			int empNumber = scanner.nextInt();
			SearchVO valueObject = new SearchVO();
			valueObject.setEmpNumber(empNumber);
			boolean searchFlag = searchbo.checkEmpExistence(valueObject
					.getEmpNumber());
			if (searchFlag) {
				// System.out.println("Employee Record Registered Successfully");
				// code to display data
				List<EmployeeVO> myEmpList = employeeDAO.getEmpList(valueObject
						.getEmpNumber());
				System.out
						.println("********************************************");
				for (EmployeeVO valueObjects : myEmpList) {
					System.out.print(valueObjects.getEmpNumber() + "\t");
					System.out.print(valueObjects.getEmpName() + "\t");
					System.out.print(valueObjects.getEmpJob() + "\t");
					System.out.print(valueObjects.getEmpBossCode() + "\t");
					System.out.print(valueObjects.getEmpDateOfJoin() + "\t");
					System.out.print(valueObjects.getEmpBasic() + "\t");
					System.out.print(valueObjects.getEmpCommission() + "\t");
					System.out.print(valueObjects.getEmpDeptNumber() + "\t");
					System.out.println();
				}
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
