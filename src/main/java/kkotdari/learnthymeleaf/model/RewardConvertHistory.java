package kkotdari.learnthymeleaf.model;

public class RewardConvertHistory {
    private long id;
    private String ticker;
    private int convertTargetPoint;
    private int convertRate;
    private int convertedReward;
    private String statCode;
    private String convertDatetime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getConvertTargetPoint() {
        return convertTargetPoint;
    }

    public void setConvertTargetPoint(int convertTargetPoint) {
        this.convertTargetPoint = convertTargetPoint;
    }

    public int getConvertRate() {
        return convertRate;
    }

    public void setConvertRate(int convertRate) {
        this.convertRate = convertRate;
    }

    public int getConvertedReward() {
        return convertedReward;
    }

    public void setConvertedReward(int convertedReward) {
        this.convertedReward = convertedReward;
    }

    public String getStatCode() {
        return statCode;
    }

    public void setStatCode(String statCode) {
        this.statCode = statCode;
    }

    public String getConvertDatetime() {
        return convertDatetime;
    }

    public void setConvertDatetime(String convertDatetime) {
        this.convertDatetime = convertDatetime;
    }
}
