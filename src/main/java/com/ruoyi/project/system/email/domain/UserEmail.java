package com.ruoyi.project.system.email.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 数值预警对象 user_email
 * 
 * @author ruoyi
 * @date 2021-12-05
 */
public class UserEmail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 邮箱 */
    private String mail;

    /** id */
    private Long id;

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mail", getMail())
            .append("id", getId())
            .toString();
    }
}
