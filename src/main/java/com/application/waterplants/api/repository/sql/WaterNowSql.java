package com.application.waterplants.api.repository.sql;

public class WaterNowSql {

    public static String getInsertWateringDataSql(String tablePrefix) {
        return String.join(
            " ",
                "INSERT INTO STORE_WATER_DATA.water_logs (request_type, `timestamp`)",
                "VALUES (:requestType, :timestamp)"
        ).replaceAll("\\[tablePrefix\\]", tablePrefix);
    }
}
