package emp.serv;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import emp.dao.EmpDAO;
import emp.dao.EmpVO;

public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
		//email 파라미터 받기
		String id = request.getParameter("email");
		EmpVO vo = EmpDAO.getInstance().selectOneByEmail(id);
		
		/*//JSON
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(vo == null) {
			//response.getWriter().print("사용 가능");
			map.put("email", true);
			response.getWriter().print(gson.toJson(map));
		} else {
			//response.getWriter().print("[중복] 사용 불가");
			map.put("email", false);
			map.put("emp", vo);
			response.getWriter().print(gson.toJson(map));
		}
		*/
		
		//XML
		response.setContentType("text/xml;charset=UTF-8");
		if(vo == null) {
			response.getWriter().append("<email>").append("true").append("</email>");
		} else {
			response.getWriter().append("<email>").append("false").append("</email>");
		}
	}
}
