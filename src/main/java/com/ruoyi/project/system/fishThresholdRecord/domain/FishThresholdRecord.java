package com.ruoyi.project.system.fishThresholdRecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 预警信息对象 fish_threshold_record
 * 
 * @author ray
 * @date 2021-12-09
 */
public class FishThresholdRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 温度最低值 */
    @Excel(name = "温度最低值")
    private Double tmpMin;

    /** 温度最高值 */
    @Excel(name = "温度最高值")
    private Double tmpMax;

    /** 盐度最低值 */
    @Excel(name = "盐度最低值")
    private Double saltMin;

    /** 盐度最高值 */
    @Excel(name = "盐度最高值")
    private Double saltMax;

    /** 深度最低值 */
    @Excel(name = "深度最低值")
    private Double deepMin;

    /** 深度最高值 */
    @Excel(name = "深度最高值")
    private Double deepMax;

    /** 叶绿素最低值 */
    @Excel(name = "叶绿素最低值")
    private Double ylsMin;

    /** 叶绿素最高值 */
    @Excel(name = "叶绿素最高值")
    private Double ylsMax;

    /** 溶解氧最低值 */
    @Excel(name = "溶解氧最低值")
    private Double rjyMin;

    /** 溶解氧最高值 */
    @Excel(name = "溶解氧最高值")
    private Double rjyMax;

    /** 收件人 */
    @Excel(name = "收件人")
    private String emailReceiver;

    /** 谁添加的信息，知晓他的鱼塘 */
    @Excel(name = "谁添加的信息，知晓他的鱼塘")
    private Long userId;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setTmpMin(Double tmpMin)
    {
        this.tmpMin = tmpMin;
    }

    public Double getTmpMin()
    {
        return tmpMin;
    }
    public void setTmpMax(Double tmpMax)
    {
        this.tmpMax = tmpMax;
    }

    public Double getTmpMax()
    {
        return tmpMax;
    }
    public void setSaltMin(Double saltMin)
    {
        this.saltMin = saltMin;
    }

    public Double getSaltMin()
    {
        return saltMin;
    }
    public void setSaltMax(Double saltMax)
    {
        this.saltMax = saltMax;
    }

    public Double getSaltMax()
    {
        return saltMax;
    }
    public void setDeepMin(Double deepMin)
    {
        this.deepMin = deepMin;
    }

    public Double getDeepMin()
    {
        return deepMin;
    }
    public void setDeepMax(Double deepMax)
    {
        this.deepMax = deepMax;
    }

    public Double getDeepMax()
    {
        return deepMax;
    }
    public void setYlsMin(Double ylsMin)
    {
        this.ylsMin = ylsMin;
    }

    public Double getYlsMin()
    {
        return ylsMin;
    }
    public void setYlsMax(Double ylsMax)
    {
        this.ylsMax = ylsMax;
    }

    public Double getYlsMax()
    {
        return ylsMax;
    }
    public void setRjyMin(Double rjyMin)
    {
        this.rjyMin = rjyMin;
    }

    public Double getRjyMin()
    {
        return rjyMin;
    }
    public void setRjyMax(Double rjyMax)
    {
        this.rjyMax = rjyMax;
    }

    public Double getRjyMax()
    {
        return rjyMax;
    }
    public void setEmailReceiver(String emailReceiver)
    {
        this.emailReceiver = emailReceiver;
    }

    public String getEmailReceiver()
    {
        return emailReceiver;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tmpMin", getTmpMin())
            .append("tmpMax", getTmpMax())
            .append("saltMin", getSaltMin())
            .append("saltMax", getSaltMax())
            .append("deepMin", getDeepMin())
            .append("deepMax", getDeepMax())
            .append("ylsMin", getYlsMin())
            .append("ylsMax", getYlsMax())
            .append("rjyMin", getRjyMin())
            .append("rjyMax", getRjyMax())
            .append("emailReceiver", getEmailReceiver())
            .append("userId", getUserId())
            .toString();
    }
}
