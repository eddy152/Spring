package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

/*
 * VO : Value Object == EmpDTO, EmoDo
 * DAO : Data Access Object
 */
@Component
public class EmpDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ArrayList<EmpVO> select() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn = JdbcUtil.connect();
			
			String sql = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			// 1.connect (연결)
			conn = JdbcUtil.connect();
			// 2.statement (구문)
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			// 3.execute (실행)
			pstmt.setString(1, id);
			// 4.resultset (select라면 조회결과처리)
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close (연결해제)
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public EmpVO selectOneByEmail(String id) {
		EmpVO vo = null;
		try {
			// 1.connect (연결)
			conn = JdbcUtil.connect();
			// 2.statement (구문)
			String sql = "SELECT * FROM EMPLOYEES WHERE EMAIL = ?";
			pstmt = conn.prepareStatement(sql);
			// 3.execute (실행)
			pstmt.setString(1, id);
			// 4.resultset (select라면 조회결과처리)
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close (연결해제)
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}

	public void insert(EmpVO vo) {
		try {
			// 1.connect (연결)
			conn = JdbcUtil.connect();
			// 2.statement (구문)
			String sql = "INSERT INTO EMPLOYEES(EMPLOYEE_ID," + " FIRST_NAME," +" LAST_NAME," + " EMAIL," + " PHONE_NUMBER," + " HIRE_DATE," + " JOB_ID," + " DEPARTMENT_ID)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 3.execute (실행)
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getLast_name());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone_number());
			pstmt.setDate(6, vo.getHire_date());
			pstmt.setString(7, vo.getJob_id());
			pstmt.setString(8, vo.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 등록됨");
			// 4.resultset (select라면 조회결과처리)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close (연결해제)
			JdbcUtil.disconnect(conn);
		}
	}

	public void update(EmpVO vo) {
		try {
			// 1.connect (연결)
			JdbcUtil.connect();
			// 2.statement (구문)

			// 3.execute (실행)

			// 4.resultset (select라면 조회결과처리)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.close (연결해제)
			JdbcUtil.disconnect(conn);
		}
	}
}
