package com.ruoyi.project.system.rongcheng.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.rongcheng.mapper.Fish_RCMapper;
import com.ruoyi.project.system.rongcheng.domain.Fish_RC;
import com.ruoyi.project.system.rongcheng.service.IFish_RCService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 荣成游钓型海洋牧场Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class Fish_RCServiceImpl implements IFish_RCService 
{
    @Autowired
    private Fish_RCMapper fish_RCMapper;

    /**
     * 查询荣成游钓型海洋牧场
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 荣成游钓型海洋牧场
     */
    @Override
    public Fish_RC selectFish_RCById(Long id)
    {
        return fish_RCMapper.selectFish_RCById(id);
    }

    /**
     * 查询荣成游钓型海洋牧场列表
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 荣成游钓型海洋牧场
     */
    @Override
    public List<Fish_RC> selectFish_RCList(Fish_RC fish_RC)
    {
        return fish_RCMapper.selectFish_RCList(fish_RC);
    }

    /**
     * 新增荣成游钓型海洋牧场
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int insertFish_RC(Fish_RC fish_RC)
    {
        return fish_RCMapper.insertFish_RC(fish_RC);
    }

    /**
     * 修改荣成游钓型海洋牧场
     * 
     * @param fish_RC 荣成游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int updateFish_RC(Fish_RC fish_RC)
    {
        return fish_RCMapper.updateFish_RC(fish_RC);
    }

    /**
     * 批量删除荣成游钓型海洋牧场
     * 
     * @param ids 需要删除的荣成游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_RCByIds(String ids)
    {
        return fish_RCMapper.deleteFish_RCByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除荣成游钓型海洋牧场信息
     * 
     * @param id 荣成游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_RCById(Long id)
    {
        return fish_RCMapper.deleteFish_RCById(id);
    }

    @Override
    public Fish_RC getLastRecord() {
        return fish_RCMapper.getLastRecord();
    }
}
