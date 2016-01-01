package com.shap;

public class Record {

    private int year;
    private double amount;
    private String statistics;
    private String geography;
    private String censusFamilyType;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getCensusFamilyType() {
        return censusFamilyType;
    }

    public void setCensusFamilyType(String censusFamilyType) {
        this.censusFamilyType = censusFamilyType;
    }

    @Override
    public String toString() {
        return "com.shap.Record{" +
                "year=" + year +
                ", amount=" + amount +
                ", statistics='" + statistics + '\'' +
                ", geography='" + geography + '\'' +
                ", censusFamilyType='" + censusFamilyType + '\'' +
                '}';
    }
}
