package ali.arshad.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ali.arshad.constants.Constant;
import ali.arshad.db.manager.DatabaseManager;
import ali.arshad.db.model.Subject;

public class SubjectDAO {

	public List<Subject> subjectList() throws SQLException{
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Subject> subjects = new ArrayList<>();

        try {
            connection = DatabaseManager.initConnection();
            statement = connection.prepareStatement(Constant.SUBJECT_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(resultSet.getString(Constant.SUBJECT_COL_ID));
                subject.setSubjectName(resultSet.getString(Constant.SUBJECT_COL_NAME));
                subject.setSubjectPosition(resultSet.getString(Constant.SUBJECT_COL_POSITION));
                subject.setSubjectVisible(resultSet.getString(Constant.SUBJECT_COL_VISIBLE));
                subjects.add(subject);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }

        return subjects;
	}

}
