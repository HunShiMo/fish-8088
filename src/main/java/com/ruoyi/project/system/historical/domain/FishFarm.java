package com.ruoyi.project.system.historical.domain;

/**
 * 养鱼场信息实体类
 *
 * @author ray
 * @date 2021/11/21 16:56
 */
public class FishFarm {
    /** id */
    private int id;

    /** 日期 */
    private String date;

    /** 小时 */
    private String hour;

    /** 分钟 */
    private String minute;

    /** 温度 */
    private String temp;

    /** 盐度 */
    private String salt;

    /** 深度 */
    private String deep;

    /** 叶绿素 */
    private String ylsCon;

    /** 溶解氧 */
    private String rjyCon;

    /** 时间戳 */
    private int timestamp;

    /** 备注 */
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getYlsCon() {
        return ylsCon;
    }

    public void setYlsCon(String ylsCon) {
        this.ylsCon = ylsCon;
    }

    public String getRjyCon() {
        return rjyCon;
    }

    public void setRjyCon(String rjyCon) {
        this.rjyCon = rjyCon;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FishFarm{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", minute='" + minute + '\'' +
                ", temp='" + temp + '\'' +
                ", salt='" + salt + '\'' +
                ", deep='" + deep + '\'' +
                ", ylsCon='" + ylsCon + '\'' +
                ", rjyCon='" + rjyCon + '\'' +
                ", timestamp=" + timestamp +
                ", note='" + note + '\'' +
                '}';
    }
}
