package kg.ksucta.kgiai.datenbank2.ig1_15.murat.utils;

public class SqlUtils {
    public static final String GET_BY_ID_QUERY = "SELECT * FROM %S WHERE id=%d";
    public static final String GET_ALL_QUERY = "SELECT * FROM %S";

    public static String getByIdQuery(Long id, String tableName) {
        return String.format(GET_BY_ID_QUERY, tableName, id);
    }

    public static String getGetByIdPreparedQuery() {
        return String.format(GET_BY_ID_QUERY, "?", "?");
    }

    public static String getAllQuery(String tableName) {
        return String.format(GET_ALL_QUERY, tableName);
    }

    public static String getAllPreparedQuery() {
        return String.format(GET_ALL_QUERY, "?");
    }

    public static String getInsertQuery(String tableName, String values) {
        return "INSERT INTO " + tableName + " VALUES( " + values + " );";
    }
}
