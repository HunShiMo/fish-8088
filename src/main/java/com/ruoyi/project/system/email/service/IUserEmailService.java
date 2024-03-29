package com.ruoyi.project.system.email.service;

import java.util.List;
import com.ruoyi.project.system.email.domain.UserEmail;

/**
 * 数值预警Service接口
 * 
 * @author ruoyi
 * @date 2021-12-05
 */
public interface IUserEmailService 
{
    /**
     * 查询数值预警
     * 
     * @param id 数值预警主键
     * @return 数值预警
     */
    public UserEmail selectUserEmailById(Long id);

    /**
     * 查询数值预警列表
     * 
     * @param userEmail 数值预警
     * @return 数值预警集合
     */
    public List<UserEmail> selectUserEmailList(UserEmail userEmail);

    /**
     * 新增数值预警
     * 
     * @param userEmail 数值预警
     * @return 结果
     */
    public int insertUserEmail(UserEmail userEmail);

    /**
     * 修改数值预警
     * 
     * @param userEmail 数值预警
     * @return 结果
     */
    public int updateUserEmail(UserEmail userEmail);

    /**
     * 批量删除数值预警
     * 
     * @param ids 需要删除的数值预警主键集合
     * @return 结果
     */
    public int deleteUserEmailByIds(String ids);

    /**
     * 删除数值预警信息
     * 
     * @param id 数值预警主键
     * @return 结果
     */
    public int deleteUserEmailById(Long id);

}
