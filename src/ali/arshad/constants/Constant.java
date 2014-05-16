package ali.arshad.constants;

public class Constant {

	public static final String SUBJECT_COL_ID = "_id";
	public static final String SUBJECT_COL_NAME = "subj_name";
	public static final String SUBJECT_COL_POSITION = "position";
	public static final String SUBJECT_COL_VISIBLE = "visible";

	public static final String TOPIC_COL_ID = "_id";
	public static final String TOPIC_SUBJECT_COL_NAME = "subj_id";
	public static final String TOPIC_COL_NAME = "topic_name";
	public static final String TOPIC_COL_QUESTION = "question";
	public static final String TOPIC_COL_OPTION_ONE = "opt_1";
	public static final String TOPIC_COL_OPTION_TWO = "opt_2";
	public static final String TOPIC_COL_OPTION_THREE = "opt_3";
	public static final String TOPIC_COL_OPTION_FOUR = "opt_4";
	public static final String TOPIC_COL_ANS = "ans";
	public static final String TOPIC_COL_POSITION = "position";
	public static final String TOPIC_COL_VISIBLE = "visible";

	public static final String SUBJECT_QUERY = "SELECT * FROM subject "
			+ " ORDER BY position ASC LIMIT 0 , 30";

	public static String getTopicQuery(String subjectId) {
		return "SELECT * FROM topic WHERE subj_id = " + subjectId + " ORDER BY position ASC LIMIT 0 , 30";
	}

	public static String getSubjectByIdQuery(String subjectId) {
		return "SELECT * FROM subject WHERE _id = " + subjectId + " LIMIT 1";
	}

	public static String getTopicByIdQuery(String topicId) {
		return "SELECT * FROM topic WHERE _id = " + topicId + " LIMIT 1";
	}
}