package com.ems.bo;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public interface RegistrationBO {
	/**
	 * @param valueObject
	 * @return boolean
	 * @throws EMSBusinessException
	 * @throws EMSException
	 */
	public abstract boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSBusinessException, EMSException;
}
