package com.ems.bo;

import com.ems.exceptions.EMSBusinessException;
import com.ems.exceptions.EMSException;
import com.ems.vo.DeleteVO;

/**
 * @author Srinath
 *
 */
public interface DeleteBO {

	/**
	 * @param valueObject
	 * @param empNumber
	 * @return boolean
	 * @throws EMSException
	 * @throws EMSBusinessException
	 */
	public abstract int deleteEmp(final DeleteVO valueObject)
			throws EMSException, EMSBusinessException;

	/**
	 * @param empNum
	 * @return boolean
	 * @throws EMSBusinessException
	 * @throws EMSException
	 * @throws NullPointerException
	 */
	public boolean checkEmpExistence(int empNum) throws EMSBusinessException,
			EMSException, NullPointerException;
}
