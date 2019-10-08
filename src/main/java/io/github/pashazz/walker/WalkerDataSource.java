package io.github.pashazz.walker;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class WalkerDataSource {

    @Bean
    public DataSource dataSource() {
        var ds = new HikariDataSource();
        ds.setUsername("walker");
        ds.setPassword("walker");
        ds.setJdbcUrl("jdbc:mariadb://localhost:3306/walker");
        Properties props = new Properties();
        ds.setDataSourceProperties(props);
        return ds;
    }
}
