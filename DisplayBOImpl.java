package com.ems.bo;

import java.util.List;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public class DisplayBOImpl implements DisplayBO {
	private EmployeeDAO employeeDAO;

	/**
	 * 
	 */
	public DisplayBOImpl() {
		employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public List<EmployeeVO> getDepartmentEmpList(final int departmentNumber)
			throws EMSException, EMSBusinessException {
		String methodName = "getDepartmentEmpList()";
		System.out.println("Method Invoked:" + methodName + ":"
				+ departmentNumber);
		List<EmployeeVO> myDeptEmpList = null;
		myDeptEmpList = employeeDAO.getDepartmentEmpList(departmentNumber);
		if (myDeptEmpList.isEmpty()) {
			throw new EMSBusinessException(
					"No Employees Found For The Given Department Number");
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ myDeptEmpList);
		return myDeptEmpList;
	}
}
