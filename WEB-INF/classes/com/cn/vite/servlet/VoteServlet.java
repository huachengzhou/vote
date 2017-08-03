package com.cn.vite.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.vite.admin.Admin;
import com.cn.vite.admin.Content;
import com.cn.vite.admin.Info;
import com.cn.vite.admin.User;
import com.cn.vite.admin.Vote;
import com.cn.vite.exception.NoVoteException;
import com.cn.vite.exception.OverTicketException;
import com.cn.vite.service.ContentService;
import com.cn.vite.service.VoteService;

/**
 * ������
 *
 */
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object lock = new Object();
	private VoteService service = null;

	public VoteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method:" + method);
		if (method != null) {
			switch (method) {
			case "findAllVote":
				this.findAllVote(request, response);
				break;
			case "findContentById":
				this.findContentById(request, response);
				break;
			case "logn":
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
				break;
			case "exit":
				this.exit(request, response);
				break;
			case "updateById":
				updateById(request, response);
				break;
			case "findAllInfo":
				this.findAllInfo(request, response);
				break;
			case "backLoginUP":
				request.getRequestDispatcher("/WEB-INF/view/backLogin.jsp").forward(request, response);
				break;
			case "backLogin":
				this.backLogin(request, response);
				break;
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method:"+method);
		if (method != null) {
			switch (method) {
			case "login":
				this.login(request, response);
				break;
            case "backLogin":
            	backLogin(request, response);
            	break;
			default:
				break;
			}
		}
	}

	/**
	 * @see �û���¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service = new VoteService();
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setPassword(password);
		user.setUsername(username);

		// ��ֹ�ظ���½
		ServletContext servletContext = request.getServletContext();
		List<String> usernameList = (List<String>) servletContext.getAttribute("usernameList");
		while (username != null && password != null) {
			/* .............................................................. */
			if (usernameList == null) {// ��һ�ε�½�ȴ���List���Ͻ������洦��List.size==0�����
				usernameList = new ArrayList<String>();
				servletContext.setAttribute("usernameList", usernameList);
			} // ��Ϊnull �ж��û��Ƿ��Ѿ�����
			boolean flag = service.checkOnline(usernameList, username);
			if (!flag) {// �û�������
				if (username.equals("����") && password.equals("123456")) {
					request.getSession().setAttribute("user", user);
					usernameList.add(username);// ��ӵ�ServletContext��
					servletContext.setAttribute("usernameList", usernameList);
					response.sendRedirect(request.getContextPath() + "/welcome.jsp");
				}
			} else {// �û�����
				request.getSession().setAttribute("message", "���û��Ѿ����� ");
				request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			}
			break;
			/* .............................................................. */
		}

	}

	/**
	 * @see �û�ע��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = request.getServletContext();
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		List<String> usernameList = (List<String>) servletContext.getAttribute("usernameList");

		session.removeAttribute("user");
		usernameList.remove(username);
		usernameList.clear();
		System.out.println("ɾ����:" + usernameList);
		servletContext.setAttribute("usernameList", usernameList);

		response.sendRedirect(request.getContextPath() + "/welcome.jsp");
	}

	/**
	 * @see ��ѯ������������Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findAllVote(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service = new VoteService();
		try {
			List<Vote> list = service.findAllVote();
			List<Vote> list2 = service.findAllVoteDesc();
			request.setAttribute("voteList", list);
			request.setAttribute("voteList2", list2);
			request.getRequestDispatcher("/WEB-INF/listAllVote.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message", "��ѯ��ѡ��ʧ�� " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see ��ѯ��ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findContentById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContentService service = new ContentService();
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			Content content = service.findContentById(id);
			request.setAttribute("content", content);
			request.getRequestDispatcher("/WEB-INF/listContent.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message", "��ѯ��ѡ����ϸ��Ϣʧ�� " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see ����ͶƱ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service = new VoteService();
		int id = Integer.valueOf(request.getParameter("id"));
		String ip = request.getRemoteAddr();
		@SuppressWarnings("unused")
		boolean sign = false;
		try {
			sign = service.updateById(id, ip, lock);
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
		} catch (NoVoteException e) {
			request.getSession().setAttribute("message", "ͶƱʱ�����");
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			System.out.println(e.getMessage());
		} catch (OverTicketException e) {
			request.getSession().setAttribute("message", "�������Ƶ�Ʊ��Ŀ");
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message", "����ʧ��");
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	protected void findAllInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service = new VoteService();
		try {
			List<Info> list = service.findAllInfo();
			request.setAttribute("infoList", list);
			request.getRequestDispatcher("/WEB-INF/findAllInfo.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message", "��ѯͶƱ��IP�����ʱ��ʧ��");
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see ����Ա��½
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void backLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Admin admin = null;
			service = new VoteService();
			admin = service.findAdminByUP(username, password);
			if(admin!=null){//���Ҳ��һ�ȡ������˵���ǹ���Ա��½
				request.getSession().setAttribute("admin",admin);
				request.getRequestDispatcher("/WEB-INF/view/backMain.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getSession().setAttribute("message", "����Աָ�����");
			request.getRequestDispatcher("/WEB-INF/view/message.jsp").forward(request, response);
		}
	}

}
