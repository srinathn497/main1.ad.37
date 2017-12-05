package com.ems.bo;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.SearchVO;

/**
 * @author Srinath
 *
 */
public interface SearchBO {

	/**
	 * @param valueObject
	 * @return boolean
	 * @throws EMSBusinessException
	 * @throws EMSException
	 */
	public abstract boolean searchEmp(final SearchVO valueObject)
			throws EMSBusinessException, EMSException;

	/**
	 * @param empNum
	 * @return boolean
	 * @throws EMSBusinessException
	 * @throws EMSException
	 * @throws NullPointerException
	 */
	public abstract boolean checkEmpExistence(final int empNum)
			throws EMSBusinessException, EMSException, NullPointerException;
}
