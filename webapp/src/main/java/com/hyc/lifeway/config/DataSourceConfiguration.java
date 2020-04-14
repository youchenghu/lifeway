package com.hyc.lifeway.config;

import com.hyc.cs.core.datasource.BaseDataSourceConfiguration;
import com.hyc.cs.core.datasource.DataSourceType;
import com.hyc.cs.core.datasource.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @Author ：胡友成
 * @Date ：2020/4/11 9:05 下午
 * @Description：
 */

@MapperScan({"com.hyc.lifeway.module.**.dao"})
@Configuration
public class DataSourceConfiguration extends BaseDataSourceConfiguration {
    @Primary
    @Bean
    public DataSource getDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.init(applicationContext, Arrays.asList(DataSourceType.PRIMARY));
        return dataSource;
    }
}
