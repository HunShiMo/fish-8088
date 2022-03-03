package com.ruoyi.project.system.rongcheng.mapper;

import java.util.List;
import com.ruoyi.project.system.rongcheng.domain.Fish_RC;

/**
 * 荣成游钓型海洋牧场Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
public interface Fish_RCMapper 
{
    /**
     * 查询荣成游钓型海洋牧场
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 荣成游钓型海洋牧场
     */
    public Fish_RC selectFish_RCById(Long id);

    /**
     * 查询荣成游钓型海洋牧场列表
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 荣成游钓型海洋牧场集合
     */
    public List<Fish_RC> selectFish_RCList(Fish_RC fish_RC);

    /**
     * 新增荣成游钓型海洋牧场
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 结果
     */
    public int insertFish_RC(Fish_RC fish_RC);

    /**
     * 修改荣成游钓型海洋牧场
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 结果
     */
    public int updateFish_RC(Fish_RC fish_RC);

    /**
     * 删除荣成游钓型海洋牧场
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 结果
     */
    public int deleteFish_RCById(Long id);

    /**
     * 批量删除荣成游钓型海洋牧场
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFish_RCByIds(String[] ids);

    Fish_RC getLastRecord();
}
