package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ems.exceptions.EMSException;
import com.ems.util.DBUtil;
import com.ems.vo.EmployeeVO;

/**
 * @author Challa
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean registerEmployee(final EmployeeVO valueObject)
			throws EMSException {
		boolean registrationFlag = false;
		String methodName = "registerEmployee";
		System.out.println("Method Invoked:" + methodName + ":" + valueObject);
		Connection connection = null;
		PreparedStatement pstStatement = null;
		try {
			connection = DBUtil.getConnection();
			final String EMP_INSERT_QUERY = "INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)";
			pstStatement = connection.prepareStatement(EMP_INSERT_QUERY);
			pstStatement.setInt(1, valueObject.getEmpNumber());
			pstStatement.setString(2, valueObject.getEmpName());
			pstStatement.setString(3, valueObject.getEmpJob());
			pstStatement.setInt(4, valueObject.getEmpBossCode());

			java.sql.Date myDOJ = new java.sql.Date(valueObject
					.getEmpDateOfJoin().getTime());
			pstStatement.setDate(5, myDOJ);
			pstStatement.setDouble(6, valueObject.getEmpBasic());
			pstStatement.setDouble(7, valueObject.getEmpCommission());
			pstStatement.setInt(8, valueObject.getEmpDeptNumber());
			int updateCount = pstStatement.executeUpdate();
			if (updateCount > 0) {
				registrationFlag = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new EMSException(e);
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ registrationFlag);
		return registrationFlag;
	}

	@Override
	public boolean checkBossCodeExistence(final int empBossCode)
			throws EMSException {
		String methodName = "checkBossCodeExistence";
		boolean bossCodeFlag = false;
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		System.out.println("Method Invoked:" + methodName + ":" + empBossCode);
		try {
			connection = DBUtil.getConnection();
			String BOSS_CODE_QUERY = "SELECT * FROM emp WHERE empno=?";
			pstStatement = connection.prepareStatement(BOSS_CODE_QUERY);
			pstStatement.setInt(1, empBossCode);
			resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				bossCodeFlag = true;
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ bossCodeFlag);
		return bossCodeFlag;
	}

	@Override
	public List<EmployeeVO> getDepartmentEmpList(final int departmentNumber)
			throws EMSException {
		String methodName = "getDepartmentEmpList()";
		System.out.println("Method Invoked:" + methodName + ":"
				+ departmentNumber);
		List<EmployeeVO> myDeptEmpList = new ArrayList<EmployeeVO>();
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String SQL_EMP_QUERY = "SELECT *FROM emp WHERE dno=?";
			pstStatement = connection.prepareStatement(SQL_EMP_QUERY);
			pstStatement.setInt(1, departmentNumber);
			resultSet = pstStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeVO valueObject = new EmployeeVO();
				valueObject.setEmpNumber(resultSet.getInt(1));
				valueObject.setEmpName(resultSet.getString(2));
				valueObject.setEmpJob(resultSet.getString(3));
				valueObject.setEmpBossCode(resultSet.getInt(4));
				valueObject.setEmpDateOfJoin(resultSet.getDate(5));
				valueObject.setEmpBasic(resultSet.getDouble(6));
				valueObject.setEmpCommission(resultSet.getDouble(7));
				valueObject.setEmpDeptNumber(resultSet.getInt(8));
				myDeptEmpList.add(valueObject);
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ myDeptEmpList);
		return myDeptEmpList;
	}

	@Override
	public boolean checkEmpExistence(final int empNum) throws EMSException {
		String methodName = "checkEmpExistence";
		boolean empFlag = false;
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		System.out.println("Method Invoked:" + methodName + ":" + empNum);
		try {
			connection = DBUtil.getConnection();
			String BOSS_CODE_QUERY = "SELECT * FROM emp WHERE empno=?";
			pstStatement = connection.prepareStatement(BOSS_CODE_QUERY);
			pstStatement.setInt(1, empNum);
			resultSet = pstStatement.executeQuery();
			if (resultSet.next()) {
				empFlag = true;
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ empFlag);
		return empFlag;

	}

	@Override
	public List<EmployeeVO> getEmpList(final int empNum) throws EMSException {
		String methodName = "getEmpList()";
		System.out.println("Method Invoked:" + methodName + ":" + empNum);
		List<EmployeeVO> myDeptEmpList = new ArrayList<EmployeeVO>();
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String SQL_EMP_QUERY = "SELECT *FROM emp WHERE empno=?";
			pstStatement = connection.prepareStatement(SQL_EMP_QUERY);
			pstStatement.setInt(1, empNum);
			resultSet = pstStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeVO valueObject = new EmployeeVO();
				valueObject.setEmpNumber(resultSet.getInt(1));
				valueObject.setEmpName(resultSet.getString(2));
				valueObject.setEmpJob(resultSet.getString(3));
				valueObject.setEmpBossCode(resultSet.getInt(4));
				valueObject.setEmpDateOfJoin(resultSet.getDate(5));
				valueObject.setEmpBasic(resultSet.getDouble(6));
				valueObject.setEmpCommission(resultSet.getDouble(7));
				valueObject.setEmpDeptNumber(resultSet.getInt(8));
				myDeptEmpList.add(valueObject);
			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName);
		return myDeptEmpList;
	}

	@Override
	public int deleteEmp(final int Emp) throws EMSException {
		String methodName = "deleteemp";
		boolean empFlag = false;
		Connection connection = null;
		PreparedStatement pstStatement = null;
		int i = 0;
		System.out.println("Method Invoked:" + methodName + ":" + Emp);
		try {
			connection = DBUtil.getConnection();
			String BOSS_CODE_QUERY = "DELETE  FROM emp WHERE empno=?";
			pstStatement = connection.prepareStatement(BOSS_CODE_QUERY);
			pstStatement.setInt(1, Emp);
			i = pstStatement.executeUpdate();
			if (i != 0) {

				System.out.println("Deleted Scuccesfully");

			}
		} catch (SQLException e) {
			throw new EMSException(e);
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// throw new EMSException(e);
				e.printStackTrace();
				// Best Practice is Log The Exception With The Help Of Logger
				// [LOG 4J]
			}
		}
		System.out.println("Response From The Method:" + methodName + ":"
				+ empFlag);
		return i;

	}

}
