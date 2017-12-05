package com.ems.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ems.bo.RegistrationBO;
import com.ems.bo.RegistrationBOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public class RegistrationController {
	private RegistrationBO registrationBO; // Has A Relation

	/**
	 * 
	 */
	public RegistrationController() {
		registrationBO = new RegistrationBOImpl();
	}

	/**
	 * Used To Read The Employee Details From The Client
	 */
	public void readEmployeeDetails() {
		String methodName = "readEmployeeDetails()";
		System.out.println("Method Invoked:" + methodName);
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Number");
			int empNumber = scanner.nextInt();
			System.out.println("Enter Employee Name");
			String empName = scanner.next();
			System.out.println("Enter Employee Job");
			String empJob = scanner.next();
			System.out.println("Enter Employee Boss Code");
			int empBossCode = scanner.nextInt();
			System.out
					.println("Enter Employee Date Of Join [DD-MM-YYYY] Format");
			String empDoj = scanner.next();
			System.out.println("Enter Employee Basic");
			double empBasic = scanner.nextDouble();
			System.out.println("Enter Employee Commission");
			double empCommission = scanner.nextDouble();
			System.out.println("Enter Employee Department Number");
			int empDeptNumber = scanner.nextInt();
			EmployeeVO valueObject = new EmployeeVO();
			valueObject.setEmpNumber(empNumber);
			valueObject.setEmpName(empName);
			valueObject.setEmpBasic(empBasic);
			valueObject.setEmpBossCode(empBossCode);
			valueObject.setEmpCommission(empCommission);
			valueObject.setEmpDeptNumber(empDeptNumber);
			valueObject.setEmpJob(empJob);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dateOfJoin = dateFormat.parse(empDoj);
			valueObject.setEmpDateOfJoin(dateOfJoin);
			boolean registrationFlag = registrationBO
					.registerEmployee(valueObject);
			if (registrationFlag) {
				System.out.println("Employee Record Registered Successfully");
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (EMSBusinessException e) {
			System.err.println("Exception Caught In Controoler:"
					+ e.getMessage());
		} catch (EMSException e) {
			System.err.println("Exception Caught In Controoler:"
					+ e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
