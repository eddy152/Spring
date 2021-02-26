package com.company.yedam.emp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.dao.JobDAO;

@Controller //@Component 1.컨테이너 빈으로 등록, 컨트롤러화
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired EmpDAO empDAO;
	@Autowired DeptDAO deptDAO;
	@Autowired JobDAO jobDAO;
	@Autowired EmpVO empVO;
	//사원 목록
	@RequestMapping("/empList")
	public String empList(HttpServletRequest request) {
		request.setAttribute("list", empDAO.select());
		return "emp/empList";
	}
	//등록폼
	@GetMapping("/empInsert")
	public String empInsert(HttpServletRequest request) {
		request.setAttribute("jobList", jobDAO.select());
		request.setAttribute("deptList", deptDAO.select());
		return "emp/empInsert";
	}
	//등록 처리
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString());
		empDAO.insert(vo);
		return "redirect:empList";
	}
	//수정폼
	@PostMapping("/empUpdate")
	public String empUpdate(HttpServletRequest request) {
		String empid = request.getParameter("employee_id");
		request.setAttribute("empVO", empDAO.selectOne(empid));
		request.setAttribute("jobList", jobDAO.select());
		request.setAttribute("deptList", deptDAO.select());
		return "emp/empInsert";
	}
	//수정처리
	
	//이메일 체크
	@GetMapping("/emailCheck")
	public String emailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("email");
		empVO = empDAO.selectOneByEmail(id);
		
		if(empVO == null) {
			response.getWriter().append("<email>").append("true").append("</email>");
		} else {
			response.getWriter().append("<email>").append("false").append("</email>");
		}
		return "emp/empInsert";
	}
	//사원 검색
	@RequestMapping("empSearch")
	public String empSearch(HttpServletRequest request) {
		request.setAttribute("empList", empDAO.select());
		return "emp/empSearch";
	}
}
