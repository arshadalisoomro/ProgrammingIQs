package ali.arshad.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ali.arshad.db.dao.SubjectDAO;
import ali.arshad.db.model.Subject;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(name = "admin-controller", description = "Controller used for administration Stuff", urlPatterns = { "/admin-controller" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO subjectDAO = null;
	//private TopicDAO topicDAO = null;
	
	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String subjId = "";
		//String topicId = "";
		subjectDAO = new SubjectDAO();
		//topicDAO = new TopicDAO();
		if (action.equals("manage-content")
				&& request.getParameter("subj_id") == null) {
			getSubjects(request, response);
		} else if (action.equals("manage-content")
				&& request.getParameter("subj_id") != null) {
			subjId = request.getParameter("subj_id");
			request.setAttribute("suject_id", subjId);			
			getSubjects(request, response);
		}/*else if (action.equals("manage-content") 
				&& request.getParameter("topic_id") !=null) {			
			topicId = request.getParameter("topic_id");
			System.out.println("Topic ID is " + topicId);
			request.setAttribute("topic_id", topicId);			
			getServletContext().getRequestDispatcher("/content.jsp").forward(
					request, response);
		}*/else if (action.equals("log-out")) {
			getServletContext().getRequestDispatcher("/content.jsp").forward(
					request, response);
		} else {
			getServletContext().getRequestDispatcher("/content.jsp").forward(
					request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	
	private void getSubjects(HttpServletRequest request,
			HttpServletResponse response) throws ServletException{
		try {
			List<Subject> subjects = subjectDAO.subjectList();
			/*List<Topic> topics = null;
			
			for (int i = 0; i < subjects.size(); i++) {
				topics = topicDAO.topicList(subjects.get(i).getSubjectId());
				System.out.println("List id is " + subjects.get(i).getSubjectId());
				for (int j = 0; j < topics.size(); j++) {					
					System.out.println("Topics are " + topics.get(j).getTopicName());
				}
			}	*/	   
			
			request.setAttribute("subjects", subjects);
			//request.setAttribute("topics", topics);
			getServletContext().getRequestDispatcher("/content.jsp").forward(
					request, response);
		} catch (Exception e) {				
			throw new ServletException("Cannot obtain subjects from DB", e.getCause());
		}
	}
}
