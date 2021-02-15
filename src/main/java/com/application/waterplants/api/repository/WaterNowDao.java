package com.application.waterplants.api.repository;

import com.application.waterplants.api.repository.sql.WaterNowSql;
import com.application.waterplants.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository
@EnableConfigurationProperties
public class WaterNowDao {

    @Value("${spring.datasource.mysql.tablePrefix}")
    private String tablePrefix;

    @Resource(name = "namedmySqlDataSource")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = DataSourceConfig.namedmySqlDataSource();

    public void saveWateringData(String requestType, String timestamp) {
        final String query = WaterNowSql.getInsertWateringDataSql(tablePrefix);
        final Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("requestType", requestType);
        paramMap.put("timestamp", timestamp);

        namedParameterJdbcTemplate.update(query, paramMap);
    }
}
