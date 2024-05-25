package com.example.salondebelleza_database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class SalonDeBellezaDataBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalonDeBellezaDataBaseApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadDataSet(DataSource dataSource) {
        return args -> {
            try (var connection = dataSource.getConnection()) {
                ScriptUtils.executeSqlScript(connection, new ClassPathResource("data.sql"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }
}
