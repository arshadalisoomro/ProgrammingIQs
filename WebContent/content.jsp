<%@page import="java.sql.SQLException"%>
<%@page import="ali.arshad.db.manager.DatabaseManager"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="assets/includes/header.html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Programming IQS Home</title>
<head></head>
<body>
	<div id="header">
		<h1>Programming IQs Home for Staff</h1>
	</div>
	<div id="main">
		<table id="structure">
			<tr>
				<td id="navigation">
					<ul class="subjects">
					<jsp:useBean id="topicDAO" class="ali.arshad.db.dao.TopicDAO" scope="page"></jsp:useBean>
						<c:forEach items="${subjects}" var="subject">
							<li
								<c:catch>
								<c:choose>
									<c:when test="${subject.subjectId == param.subj_id}">
									   <c:out value="class=\"selected\"" escapeXml="false"/>
									</c:when>
								</c:choose>	
							</c:catch>><a
								href='/programming-iqs/admin-controller?action=manage-content&subj_id=
									<c:out value="${subject.subjectId}"/>'>
									<c:out value="${subject.subjectName}" />
							</a></li>
							<ul class="pages">								
								<c:forEach items="${topicDAO.topicList(subject.subjectId)}" var="topic">
									<li
										<c:catch>
											<c:choose>
												<c:when test="${topic.topicId == param.topic_id}">
												    <c:out value="class=\"selected\"" escapeXml="false"/>
												</c:when>
											</c:choose>	
										</c:catch>
										><a
										href='/programming-iqs/admin-controller?action=manage-content&topic_id=
										<c:out value="${topic.topicId}"/>'>
											<c:out value="${topic.topicName}" />
									</a></li>
								</c:forEach>
							</ul>
						</c:forEach>
					</ul>
				</td>
				<td id="page">
					<h1>

						<%
						// This Next Step to Use MVC Here Instead of following...
							ResultSet subjByIdResult = null;
							try {
								String subjectAttr = (String) request.getAttribute("suject_id");
								if (!subjectAttr.equals(null)) {
									subjByIdResult = DatabaseManager
											.getSubjectById(subjectAttr);
									while (subjByIdResult.next()) {
										out.print(subjByIdResult.getString("subj_name"));
									}
								}
							} catch (NullPointerException e) {

							}
							ResultSet topicByIdResult = null;
							try {
								if (request.getParameter("topic_id") != null) {
									topicByIdResult = DatabaseManager.getTopicById(request
											.getParameter("topic_id"));
									while (topicByIdResult.next()) {
										out.print(topicByIdResult.getString("topic_name"));
									}
								}
							} catch (NullPointerException e) {

							}
						%>

					</h1>
					<p>
						<%
							
						%>
					</p>

				</td>
			</tr>
		</table>
	</div>

	<%@ include file="assets/includes/footer.html"%></body>