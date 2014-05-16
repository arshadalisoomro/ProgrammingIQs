package ali.arshad.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ali.arshad.constants.Constant;

public class DatabaseManager {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static final String DB_NAME = "piqs";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

	public static Connection initConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER_NAME,
					PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getSubjects() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = initConnection().createStatement();
			resultSet = statement.executeQuery(Constant.SUBJECT_QUERY);
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getTopics(String subjectId) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = initConnection().createStatement();
			resultSet = statement.executeQuery(Constant
					.getTopicQuery(subjectId));
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getSubjectById(String subjectId) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = initConnection().createStatement();
			resultSet = statement.executeQuery(Constant
					.getSubjectByIdQuery(subjectId));
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResultSet getTopicById(String topicId) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = initConnection().createStatement();
			resultSet = statement.executeQuery(Constant
					.getTopicByIdQuery(topicId));
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
