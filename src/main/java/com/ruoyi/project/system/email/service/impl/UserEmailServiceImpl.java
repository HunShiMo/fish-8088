package com.ruoyi.project.system.email.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.email.mapper.UserEmailMapper;
import com.ruoyi.project.system.email.domain.UserEmail;
import com.ruoyi.project.system.email.service.IUserEmailService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 数值预警Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-05
 */
@Service
public class UserEmailServiceImpl implements IUserEmailService 
{
    @Autowired
    private UserEmailMapper userEmailMapper;

    /**
     * 查询数值预警
     * 
     * @param id 数值预警主键
     * @return 数值预警
     */
    @Override
    public UserEmail selectUserEmailById(Long id)
    {
        return userEmailMapper.selectUserEmailById(id);
    }

    /**
     * 查询数值预警列表
     * 
     * @param userEmail 数值预警
     * @return 数值预警
     */
    @Override
    public List<UserEmail> selectUserEmailList(UserEmail userEmail)
    {
        return userEmailMapper.selectUserEmailList(userEmail);
    }

    /**
     * 新增数值预警
     * 
     * @param userEmail 数值预警
     * @return 结果
     */
    @Override
    public int insertUserEmail(UserEmail userEmail)
    {
        return userEmailMapper.insertUserEmail(userEmail);
    }

    /**
     * 修改数值预警
     * 
     * @param userEmail 数值预警
     * @return 结果
     */
    @Override
    public int updateUserEmail(UserEmail userEmail)
    {
        return userEmailMapper.updateUserEmail(userEmail);
    }

    /**
     * 批量删除数值预警
     * 
     * @param ids 需要删除的数值预警主键
     * @return 结果
     */
    @Override
    public int deleteUserEmailByIds(String ids)
    {
        return userEmailMapper.deleteUserEmailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数值预警信息
     * 
     * @param id 数值预警主键
     * @return 结果
     */
    @Override
    public int deleteUserEmailById(Long id)
    {
        return userEmailMapper.deleteUserEmailById(id);
    }
}
