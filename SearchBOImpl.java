package com.ems.bo;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.SearchVO;

/**
 * @author Srinath
 *
 */

public class SearchBOImpl implements SearchBO {

	private EmployeeDAO employeeDAO;// HAS A RELATION

	/**
 * 
 */

	public SearchBOImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public boolean searchEmp(SearchVO valueObject) throws EMSBusinessException,
			EMSException { // TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmpExistence(int empNum) throws EMSBusinessException,
			EMSException, NullPointerException {
		boolean empFlag = false;
		String methodName = "checkBossCodeExistence";
		System.out.println("Method Invoked:" + methodName + ":" + empNum);
		empFlag = employeeDAO.checkEmpExistence(empNum);
		if (!empFlag) {
			throw new NullPointerException(
					"Please Enter The Correct Employee number");
		}
		System.out.println("Response From The Method:" + ":" + empFlag);
		return empFlag;
	}

}
