package com.taxi.taxi_company.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseConnectionTester implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseConnectionTester(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("✅ Database connected successfully!");
            System.out.println("🔗 URL: " + connection.getMetaData().getURL());
            System.out.println("👤 Username: " + connection.getMetaData().getUserName());
        } catch (Exception e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
        }
    }
}
