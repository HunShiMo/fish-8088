package com.ruoyi.project.system.xixia.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 西霞国家级海洋牧场对象 fish_qixia_20160101_20200701
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
public class Fish_xixia extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String date;

    /** 小时 */
    @Excel(name = "小时")
    private String hour;

    /** 分钟 */
    @Excel(name = "分钟")
    private String minute;

    /** 温度 */
    @Excel(name = "温度")
    private String temp;

    /** 盐度 */
    @Excel(name = "盐度")
    private String salt;

    /** 深度 */
    @Excel(name = "深度")
    private String deep;

    /** 叶绿素 */
    @Excel(name = "叶绿素")
    private String ylsCon;

    /** 溶解氧 */
    @Excel(name = "溶解氧")
    private String rjyCon;

    /** 时间戳 */
    private Long timestamp;

    /** 备注 */
    private String note;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDate()
    {
        return date;
    }
    public void setHour(String hour)
    {
        this.hour = hour;
    }

    public String getHour()
    {
        return hour;
    }
    public void setMinute(String minute)
    {
        this.minute = minute;
    }

    public String getMinute()
    {
        return minute;
    }
    public void setTemp(String temp)
    {
        this.temp = temp;
    }

    public String getTemp()
    {
        return temp;
    }
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getSalt()
    {
        return salt;
    }
    public void setDeep(String deep)
    {
        this.deep = deep;
    }

    public String getDeep()
    {
        return deep;
    }
    public void setYlsCon(String ylsCon)
    {
        this.ylsCon = ylsCon;
    }

    public String getYlsCon()
    {
        return ylsCon;
    }
    public void setRjyCon(String rjyCon)
    {
        this.rjyCon = rjyCon;
    }

    public String getRjyCon()
    {
        return rjyCon;
    }
    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public Long getTimestamp()
    {
        return timestamp;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("hour", getHour())
            .append("minute", getMinute())
            .append("temp", getTemp())
            .append("salt", getSalt())
            .append("deep", getDeep())
            .append("ylsCon", getYlsCon())
            .append("rjyCon", getRjyCon())
            .append("timestamp", getTimestamp())
            .append("note", getNote())
            .toString();
    }
}
