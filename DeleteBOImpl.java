package com.ems.bo;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.DeleteVO;

/**
 * @author Srinath
 *
 */
public class DeleteBOImpl implements DeleteBO {

	private EmployeeDAO employeeDAO;

	/**
	 * 
	 */
	public DeleteBOImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}

	/**
	 * @param valueObject
	 * @param empNumber
	 * @return int
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	/*
	 * @Override public int deleteEmp(final DeleteVO valueObject) throws
	 * EMSException, EMSBusinessException {
	 * 
	 * String methodName = "deleteEmp()"; System.out.println("Method Invoked:" +
	 * methodName + ":" + valueObject.getEmpNumber()); List<EmployeeVO>
	 * myDeptEmpList = null; myDeptEmpList = employeeDAO.deleteEmp(empNumber);
	 * if (myDeptEmpList.isEmpty()) { throw new EMSBusinessException(
	 * "No Employees Found For The Given Department Number"); }
	 * System.out.println("Response From The Method:" + methodName + ":" +
	 * myDeptEmpList);
	 * 
	 * return empNumber;
	 * 
	 * }
	 */

	@Override
	public boolean checkEmpExistence(int empNum) throws EMSBusinessException,
			EMSException, NullPointerException {
		boolean empFlag = false;
		String methodName = "EmpNumberExistence";
		System.out.println("Method Invoked:" + methodName + ":" + empNum);
		empFlag = employeeDAO.checkEmpExistence(empNum);
		if (!empFlag) {
			throw new NullPointerException(
					"Please Enter The Correct Employee number");
		}
		System.out.println("Response From The Method:" + ":" + empFlag);
		return empFlag;
	}

	@Override
	public int deleteEmp(DeleteVO valueObject) throws EMSException,
			EMSBusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
