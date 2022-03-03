package com.ruoyi.project.system.rongcheng_now.service;

import java.util.List;
import com.ruoyi.project.system.rongcheng_now.domain.RC_now;

/**
 * 荣成游钓型海洋牧场Service接口
 * 
 * @author ruoyi
 * @date 2021-11-28
 */
public interface IRC_nowService 
{
    /**
     * 查询荣成游钓型海洋牧场
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 荣成游钓型海洋牧场
     */
    public RC_now selectRC_nowById(Long id);

    /**
     * 查询荣成游钓型海洋牧场列表
     * 
     * @param rC_now 荣成游钓型海洋牧场
     * @return 荣成游钓型海洋牧场集合
     */
    public List<RC_now> selectRC_nowList(RC_now rC_now);

    /**
     * 新增荣成游钓型海洋牧场
     * 
     * @param rC_now 荣成游钓型海洋牧场
     * @return 结果
     */
    public int insertRC_now(RC_now rC_now);

    /**
     * 修改荣成游钓型海洋牧场
     * 
     * @param rC_now 荣成游钓型海洋牧场
     * @return 结果
     */
    public int updateRC_now(RC_now rC_now);

    /**
     * 批量删除荣成游钓型海洋牧场
     * 
     * @param ids 需要删除的荣成游钓型海洋牧场主键集合
     * @return 结果
     */
    public int deleteRC_nowByIds(String ids);

    /**
     * 删除荣成游钓型海洋牧场信息
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 结果
     */
    public int deleteRC_nowById(Long id);
}
