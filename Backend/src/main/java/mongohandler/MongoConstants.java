package mongohandler;

/**
 * Created by nick on 10/1/16.
 */
public class MongoConstants {
    static final String PROFILE_COLLECTION_NAME = "Profile";
    static final String TEAM_COLLECTION_NAME = "Team";
    static final String LOGGED_MILES_COLLECTION_NAME = "LoggedMiles";
    static final String DATABASE_NAME = "GALENT_FEW_MARATHON";

    static final String DEFAULT_HOSTNAME = "10.143.192.182";
    static final int DEFAULT_PORT = 27017;

    // Account Bean fields
    static final String ACCOUNT_ID_FIELD = "AccountID";
    static final String FIRST_NAME_FIELD = "FirstName";
    static final String LAST_NAME_FIELD = "LastName";
    static final String TOTAL_MILES_FIELD = "TotalMiles";

    // Team Bean fields
    static final String TEAM_ID_FIELD = "TeamID";
    static final String TEAM_MEMBERS_FIELD = "TeamMembers";

    // LoggedMiles Bean Fields
    static final String ACTIVITY_FIELD = "Activity";
    static final String MILES_FIELD = "Miles";
    static final String DATE_FIELD = "Date";


}
