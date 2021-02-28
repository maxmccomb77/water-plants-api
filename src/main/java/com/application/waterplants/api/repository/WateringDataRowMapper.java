package com.application.waterplants.api.repository;

import com.application.waterplants.api.domain.WateringData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WateringDataRowMapper implements RowMapper<WateringData> {

    @Override
    public WateringData mapRow(ResultSet rs, int rowNum) throws SQLException {
        WateringData wateringData = new WateringData();
        wateringData.setWateringType(rs.getString("request_type"));
        wateringData.setWateringTimestamp(rs.getString("timestamp"));
        return wateringData;
    }
}
