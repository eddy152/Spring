package emp.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DateUtil;
import emp.dao.DeptDAO;
import emp.dao.DeptVO;
import emp.dao.EmpDAO;
import emp.dao.EmpVO;
import emp.dao.JobDAO;
import emp.dao.JobVO;

public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpInsert() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		new JobDAO(); 
		List<JobVO> jobList = JobDAO.getInstance().select();
		List<DeptVO> deptList = DeptDAO.getInstance().select();
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/emp/empInsert.jsp").forward(request, response);
		//request 정보를 전달 
	}
	
	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//파라미터 VO담기
//		String hire_date = request.getParameter("hire_date");
//		EmpVO vo = EmpVO.builder()
//					.commission_pct(request.getParameter("commission_pct"))
//					.department_id(request.getParameter("department_id"))
//					.email(request.getParameter("email"))
//					.employee_id(request.getParameter("employee_id"))
//					.hire_date(DateUtil.toDate(hire_date))
//					.job_id(request.getParameter("job_id"))
//					.build();
//		EmpDAO.getInstance().insert(vo);
//		request.getRequestDispatcher("EmpList").forward(request, response);
		//servlet으로 갈땐 send jsp페이지로 갈때에는 forward
		response.sendRedirect("EmpList");
	}
}
