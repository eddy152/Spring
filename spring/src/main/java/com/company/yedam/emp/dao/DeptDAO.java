package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//singletone
	private static DeptDAO instance;
	public static DeptDAO getInstance() {
		if( instance == null ) {
			instance = new DeptDAO();
		}
		return instance;
	}
	
	public ArrayList<DeptVO> select() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			conn = JdbcUtil.connect();
			
			String sql = "SELECT * FROM DEPARTMENTS ORDER BY MANAGER_ID";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setLocation_id(rs.getInt("location_id"));
				vo.setManager_id(rs.getInt("manager_id"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
}
