package com.ems.dao;

import java.util.List;

import com.ems.exceptions.EMSException;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public interface EmployeeDAO {
	/**
	 * @param valueObject
	 * @return boolean
	 * @throws EMSException
	 */
	public abstract boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException;

	/**
	 * @param empBossCode
	 * @return boolean
	 * @throws EMSException
	 */
	public abstract boolean checkBossCodeExistence(final int empBossCode)
			throws EMSException;

	/**
	 * @param departmentNumber
	 * @return List<EmployeeVO>
	 * @throws EMSException
	 */
	public abstract List<EmployeeVO> getDepartmentEmpList(
			final int departmentNumber) throws EMSException;

	/**
	 * @param empBossCode
	 * @return boolean
	 * @throws EMSException
	 */
	public abstract boolean checkEmpExistence(final int empBossCode)
			throws EMSException;

	/**
	 * @param empNum
	 * @param departmentNumber
	 * @return boolean
	 * @throws EMSException
	 */
	public abstract List<EmployeeVO> getEmpList(final int empNum)
			throws EMSException;

	/**
	 * @param empNum
	 * @param valueObject
	 * @return boolean
	 * @throws EMSException
	 */
	public abstract int deleteEmp(final int empNum) throws EMSException;

}
