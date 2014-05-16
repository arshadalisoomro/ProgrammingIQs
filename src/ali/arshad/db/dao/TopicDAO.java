package ali.arshad.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ali.arshad.constants.Constant;
import ali.arshad.db.manager.DatabaseManager;
import ali.arshad.db.model.Topic;

public class TopicDAO {
	public List<Topic> topicList(String subjectId) throws SQLException{
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Topic> topics = new ArrayList<>();

        try {
            connection = DatabaseManager.initConnection();
            statement = connection.prepareStatement(Constant.getTopicQuery(subjectId));
           // System.out.println("ResultSet returned...");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Topic topic = new Topic();
                topic.setTopicId(resultSet.getString(Constant.TOPIC_COL_ID));
                topic.setSubjectId(resultSet.getString(Constant.TOPIC_SUBJECT_COL_NAME));
                topic.setTopicName(resultSet.getString(Constant.TOPIC_COL_NAME));
                topic.setTopicOptOne(resultSet.getString(Constant.TOPIC_COL_OPTION_ONE));
                topic.setTopicOptTwo(resultSet.getString(Constant.TOPIC_COL_OPTION_TWO));
                topic.setTopicOptThree(resultSet.getString(Constant.TOPIC_COL_OPTION_THREE));
                topic.setTopicOptFour(resultSet.getString(Constant.TOPIC_COL_OPTION_FOUR));
                topic.setTopicAns(resultSet.getString(Constant.TOPIC_COL_ANS));
                topic.setTopicPosition(resultSet.getString(Constant.TOPIC_COL_POSITION));
                topic.setTopicVisible(resultSet.getString(Constant.TOPIC_COL_VISIBLE));
              //  System.out.println("List returned...");
                topics.add(topic);
            }
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }

        return topics;
	}

}
