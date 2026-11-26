package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Database {

    private static final Properties CONFIG = loadConfiguration();
    private static final String URL = getSetting("DB_URL");
    private static final String USER = getSetting("DB_USER");
    private static final String PASSWORD = getSetting("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static Properties loadConfiguration() {
        Properties properties = new Properties();
        Path workingDirectory = Path.of("").toAbsolutePath();
        Path[] candidates = {
                workingDirectory.resolve(".env"),
                workingDirectory.resolve("macros").resolve(".env")
        };

        for (Path candidate : candidates) {
            if (Files.isRegularFile(candidate)) {
                try (InputStream input = Files.newInputStream(candidate)) {
                    properties.load(input);
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read " + candidate, e);
                }
                break;
            }
        }
        return properties;
    }

    private static String getSetting(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            value = CONFIG.getProperty(name);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing " + name + ". Set it in macros/.env or as an environment variable."
            );
        }
        return value.trim();
    }
}