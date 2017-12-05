package com.ems.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public class RegistrationBOImpl implements RegistrationBO {
	private EmployeeDAO employeeDAO;// HAS A RELATION

	/**
	 * 
	 */
	public RegistrationBOImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSBusinessException, EMSException {
		String methodName = "registerEmployee";
		System.out.println("Method Invoked:" + methodName + ":" + valueObject);
		boolean registrationFlag = false;

		// Server Side- Data-Validation Logic
		// Assume All Validations Done
		if (doAllValidations(valueObject)) {
			registrationFlag = employeeDAO.registerEmployee(valueObject);
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ registrationFlag);
		return registrationFlag;
	}

	private boolean doAllValidations(final EmployeeVO valueObject)
			throws EMSException, EMSBusinessException {
		String methodName = "doAllValidations()";
		boolean validationsFlag = false;
		System.out.println("Method Invoked:" + methodName + ":" + valueObject);
		validateEmpName(valueObject.getEmpName());
		validateEmpJob(valueObject.getEmpJob());
		checkBossCodeExistence(valueObject.getEmpBossCode());
		validationsFlag = true;
		System.out.println("Response From The Method:" + methodName + ":"
				+ validationsFlag);
		return validationsFlag;
	}

	private boolean validateEmpName(final String empName)
			throws EMSBusinessException {
		String methodName = "validateEmpName()";
		boolean nameValidationFlag = false;
		System.out.println("Method Invoked:" + methodName + ":" + empName);
		String regEx = "^[a-zA-Z]+$";
		Pattern pattren = Pattern.compile(regEx);
		Matcher matcher = pattren.matcher(empName);
		System.out.println("Result:" + matcher.matches());
		if (!matcher.matches()) {
			throw new EMSBusinessException(
					"EmpName Should Contain Only Characters");
		}
		if (empName.length() > 20) {
			throw new EMSBusinessException(
					"EmpName Should Contain Only 20 Characters Length");
		}
		nameValidationFlag = true;
		System.out.println("Response From The Method:" + methodName + ":"
				+ nameValidationFlag);
		return nameValidationFlag;
	}

	private boolean validateEmpJob(final String empJob)
			throws EMSBusinessException {
		String methodName = "validateEmpJob";
		boolean jobValidationFlag = false;
		System.out.println("Method Invoked:" + methodName + ":" + empJob);
		String regEx = "^[a-zA-Z]+$";
		Pattern pattren = Pattern.compile(regEx);
		Matcher matcher = pattren.matcher(empJob);
		System.out.println("Result:" + matcher.matches());
		if (!matcher.matches()) {
			throw new EMSBusinessException(
					"EmpJob Should Contain Only Characters");
		}
		if (empJob.length() > 15) {
			throw new EMSBusinessException(
					"EmpJob Should Contain Only 15 Characters Length");
		}
		jobValidationFlag = true;
		System.out.println("Response From The Method:" + methodName + ":"
				+ jobValidationFlag);
		return jobValidationFlag;
	}

	private boolean checkBossCodeExistence(int empBossCode)
			throws EMSBusinessException, EMSException {
		boolean bossCodeFlag = false;
		String methodName = "checkBossCodeExistence";
		System.out.println("Method Invoked:" + methodName + ":" + empBossCode);
		bossCodeFlag = employeeDAO.checkBossCodeExistence(empBossCode);
		if (!bossCodeFlag) {
			throw new EMSBusinessException("Please Enter The Correct Boss Code");
		}
		System.out.println("Response From The Method:" + ":" + bossCodeFlag);
		return bossCodeFlag;
	}
}
