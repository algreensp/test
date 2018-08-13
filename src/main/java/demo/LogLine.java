package demo;

import java.util.Date;

public class LogLine {
    String source;
    String destination;
    String unixTimeStamp;
    Date lineDate;

    public LogLine(String unixTimeStamp, String source, String destination){

        this.source = source;
        this.destination = destination;
        this.unixTimeStamp = unixTimeStamp;
        this.lineDate = new Date(Long.parseLong(this.unixTimeStamp) * 1000);
    }
    public String getSource(){
        return source;
    }
    public Date getLineDate(){

       return lineDate;
    }
}
