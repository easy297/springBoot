package kz.test.easy297.beans;

import kz.test.easy297.dbconnect.DBConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public DBConnector connection(){
        return new DBConnector("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
    }
}
