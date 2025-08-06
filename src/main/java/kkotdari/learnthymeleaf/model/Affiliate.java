package kkotdari.learnthymeleaf.model;

public class Affiliate {

    private long id;
    private String name;
    private String ticker;
    private String startDate;
    private String endDate;
    private int totalConvertedPoints;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalConvertedPoints() {
        return totalConvertedPoints;
    }

    public void setTotalConvertedPoints(int totalConvertedPoints) {
        this.totalConvertedPoints = totalConvertedPoints;
    }
}
