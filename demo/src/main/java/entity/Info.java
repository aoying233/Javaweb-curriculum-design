package entity;

public class Info {
    private String ip;
    private String time;
    private String op;
 
    public Info() {
    }
 
    public Info(String ip, String time,String op) {
        this.ip = ip;
        this.time = time;
        this.op = op;
    }
 
    public String getIp() {
        return ip;
    }
 
    public void setIp(String ip) {
        this.ip = ip;
    }
 
    public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
    }

    public String getOp() {
        return op;
    }
 
    public void setOp(String op) {
        this.op = op;
    }
}