package model;

public class QueryResult {
    private Object[][] data;
    private String[] columnNames;

    public QueryResult(Object[][] data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    public QueryResult() {
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public boolean hasData() {
        return data != null && data.length > 0;
    }
}