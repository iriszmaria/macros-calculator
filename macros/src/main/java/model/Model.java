package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    public QueryResult getTableData(String sql) {
        List<Object[]> rows = new ArrayList<>();
        String[] columnNames = null;

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();
            columnNames = new String[colCount];
            for (int i = 1; i <= colCount; i++) {
                columnNames[i - 1] = meta.getColumnName(i);
            }

            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                rows.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new QueryResult(rows.toArray(new Object[0][]), columnNames);

    }

    public int executeUpdate(String sql) {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("Executing update: " + sql);
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected;

        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }


    public QueryResult select_all() {
        String sql = "SELECT * FROM food";
        return getTableData(sql);
    }

}
