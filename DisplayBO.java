package com.ems.bo;

import java.util.List;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public interface DisplayBO {
	/**
	 * @param departmentNumber
	 * @return List<EmployeeVO>
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	public abstract List<EmployeeVO> getDepartmentEmpList(
			final int departmentNumber) throws EMSException,
			EMSBusinessException;
}
