package com.ems.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ems.bo.DisplayBO;
import com.ems.bo.DisplayBOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public class DisplayController {
	private DisplayBO displayBO; // HAS A RELATION

	// private DisplayBOImpl displayBO;

	/**
	 * 
	 */
	public DisplayController() {
		displayBO = new DisplayBOImpl();
	}

	/**
	 * Used To Get Employee Details For A Perticular Department
	 */
	public void displayEmpList() {
		String methodName = "displayEmpList()";
		System.out.println("Method Invoked:" + methodName);
		Scanner scanner = new Scanner(System.in); // USES-A RELATION
		try {
			System.out.println("Enter Department Number");
			int deptNumber = scanner.nextInt();
			List<EmployeeVO> myDeptEmpList = displayBO
					.getDepartmentEmpList(deptNumber);
			System.out.println("********************************************");
			for (EmployeeVO valueObjects : myDeptEmpList) {
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
