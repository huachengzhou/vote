package com.cn.vite.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.vite.admin.Content;
import com.cn.vite.admin.Image;
import com.cn.vite.admin.Vote;
import com.cn.vite.service.ContentService;
import com.cn.vite.service.DataService;
import com.cn.vite.service.VoteService;

public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataService service = null;

	public Data() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method get:" + method);
		if (method != null) {
			switch (method) {
			case "select1":
				try {
					List<Vote> list = new VoteService().findAllVote();
					request.setAttribute("voteList", list);
					request.getRequestDispatcher("/WEB-INF/view/select.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;
			case "update1":
				try {
					List<Vote> list = new VoteService().findAllVote();
					request.setAttribute("voteList", list);
					request.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "update":
				int id = Integer.valueOf(request.getParameter("id"));
				try {
					Content content = new ContentService().findContentById(id);
					request.setAttribute("content", content);
					request.setAttribute("id",id);
					request.getRequestDispatcher("/WEB-INF/view/update2.jsp").forward(request, response);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case "add1":
				request.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "delete1":
				try {
					List<Vote> list = new VoteService().findAllVote();
					request.setAttribute("voteList", list);
					request.getRequestDispatcher("/WEB-INF/view/delete.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;
			case "backMain":
				request.getRequestDispatcher("/WEB-INF/view/backMain.jsp").forward(request, response);
				break;
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method post:" + method);
		if (method != null) {
			switch (method) {
			case "add":
				this.add(request, response);
				break;
			case "update2":
				this.update(request, response);
			default:
				break;
			}
		}
	}
    /**
     * @see 修改候选人信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> enParam = request.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		service = new DataService();
		while (enParam.hasMoreElements()) {
			String key = enParam.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);
		}
		Vote vote = new Vote(map.get("content"), Integer.valueOf(map.get("ticket")));
		Content content = new Content(Integer.valueOf(map.get("age")), map.get("description"));
		boolean flag = false;
		int id = Integer.parseInt(map.get("id"));
		try {
			flag = service.update(id, vote, content);
			if(flag){
				response.sendRedirect(request.getContextPath() + "/Data?method=update1");
			}else {
				request.setAttribute("message", "修改候选人失败");
				request.getRequestDispatcher("/WEB-INF/view/message2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see 删除候选人
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new DataService();
		int id = Integer.valueOf(request.getParameter("id"));
		boolean flag = false;
		try {
			flag = service.remove(id);
			System.out.println("删除情况:" + flag + "删除候选人的id:" + id);
			if (flag) {
				response.sendRedirect(request.getContextPath() + "/Data?method=delete1");
			} else {
				request.setAttribute("message", "删除候选人失败");
				request.getRequestDispatcher("/WEB-INF/view/message2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see 增加候选人
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> enParam = request.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		service = new DataService();
		while (enParam.hasMoreElements()) {
			String key = enParam.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);
		}
		Vote vote = new Vote(map.get("content"), Integer.valueOf(map.get("ticket")));
		Content content = new Content(Integer.valueOf(map.get("age")), map.get("description"));
		Image image = new Image(map.get("path"));
		try {
			boolean flag = service.add(vote, content, image);
			if (flag) {
				request.getRequestDispatcher("/WEB-INF/view/backMain.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "添加候选人失败");
				request.getRequestDispatcher("/WEB-INF/view/message2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(map);
	}

}
