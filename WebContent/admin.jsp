<%@page import="ali.arshad.db.manager.DatabaseManager"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="assets/includes/header.html"%>
<title>Programming IQs Home</title>
</head>
<body>
	<div id="header">
		<h1>Programming IQs Home for Staff</h1>
	</div>
	<div id="main">
		<table id="structure">
			<tr>
				<td id="navigation">
					<ul class="subjects">
						<%
							ResultSet sujectResult = DatabaseManager.getSubjects();

							while (sujectResult.next()) {
								out.print("<li>" + sujectResult.getString("_id") + " "
										+ sujectResult.getString("subj_name") + "</li>");
								//
								ResultSet topicResult = DatabaseManager.getTopics(sujectResult
										.getString("_id"));
								out.print("<ul class=\"pages\">");
								while (topicResult.next()) {
									out.print("<li>" + topicResult.getString("_id") + " "
											+ topicResult.getString("topic_name") + "</li>");
								}
								out.print("</ul>");
							}
							%>
					</ul>
				</td>
				<td id="page">
					<h1>Staff</h1>
					<p>Welcome to Admin Area</p>
					<ul>
						<li><a
							href="/programming-iqs/admin-controller?action=manage-content">Manage
								Content</a></li>
						<li><a
							href="/programming-iqs/admin-controller?action=log-out">Logout</a></li>
					</ul>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="assets/includes/footer.html"%>