package com.application.waterplants.api.repository;

import com.application.waterplants.api.domain.WateringData;
import com.application.waterplants.config.DataSourceConfig;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class GetWateringDataDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = DataSourceConfig.namedmySqlDataSource();

    public List<WateringData> fetchWateringData(){
       final String query = getWateringSQL();

// ------ How you would do a select call but you need to pass something to the query ------
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("supplierNumbers", new TreeSet<>(supplierNums));
//        List <WateringData> = namedParameterJdbcTemplate.query(query, parameters, new WateringDataRowMapper());

        List <WateringData> wateringData = namedParameterJdbcTemplate.query(query, new WateringDataRowMapper());
        return wateringData;

    }


    private String getWateringSQL(){
        String query = "select request_type, `timestamp` from STORE_WATER_DATA.water_logs order by `timestamp` DESC LIMIT 25";
        return query;
    }
}
