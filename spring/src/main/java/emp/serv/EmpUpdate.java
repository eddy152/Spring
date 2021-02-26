package emp.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.DeptDAO;
import emp.dao.DeptVO;
import emp.dao.EmpDAO;
import emp.dao.EmpVO;
import emp.dao.JobDAO;
import emp.dao.JobVO;

public class EmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpUpdate() {
		super();
	}
	//수정 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<JobVO> jobList = JobDAO.getInstance().select();
		List<DeptVO> deptList = DeptDAO.getInstance().select();
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		
		//수정할 사원 정보를 단건 조회
		String empid = request.getParameter("employee_id");
		EmpVO vo = EmpDAO.getInstance().selectOne(empid);
		request.setAttribute("empVO", vo);
		request.getRequestDispatcher("/emp/empInsert.jsp").forward(request, response);
	}
	
	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
