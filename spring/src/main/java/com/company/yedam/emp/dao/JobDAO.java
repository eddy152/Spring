package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class JobDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
		
	public ArrayList<JobVO> select() {
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		try {
			conn = JdbcUtil.connect();
			
			String sql = "SELECT * FROM JOBS ORDER BY JOB_ID";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				JobVO vo = new JobVO();
				
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
				vo.setMax_salary(rs.getInt("max_salary"));
				vo.setMin_salary(rs.getInt("min_salary"));
				
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