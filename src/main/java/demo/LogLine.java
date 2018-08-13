package demo;

import java.util.Date;

public class LogLine {



    private String source;
    private String destination;
    private String unixTimeStamp;
    private Date lineDate;

    public LogLine(String unixTimeStamp, String source, String destination){

        this.source = source;
        this.destination = destination;
        this.unixTimeStamp = unixTimeStamp;
        this.lineDate = new Date(Long.parseLong(this.unixTimeStamp) * 1000);
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUnixTimeStamp() {
        return unixTimeStamp;
    }

    public void setUnixTimeStamp(String unixTimeStamp) {
        this.unixTimeStamp = unixTimeStamp;
    }

    public Date getLineDate() {
        return lineDate;
    }

    public void setLineDate(Date lineDate) {
        this.lineDate = lineDate;
    }
}
