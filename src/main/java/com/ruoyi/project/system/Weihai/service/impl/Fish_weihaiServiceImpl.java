package com.ruoyi.project.system.Weihai.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.Weihai.mapper.Fish_weihaiMapper;
import com.ruoyi.project.system.Weihai.domain.Fish_weihai;
import com.ruoyi.project.system.Weihai.service.IFish_weihaiService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 威海游钓型海洋牧场Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class Fish_weihaiServiceImpl implements IFish_weihaiService 
{
    @Autowired
    private Fish_weihaiMapper fish_weihaiMapper;

    /**
     * 查询威海游钓型海洋牧场
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 威海游钓型海洋牧场
     */
    @Override
    public Fish_weihai selectFish_weihaiById(Long id)
    {
        return fish_weihaiMapper.selectFish_weihaiById(id);
    }

    /**
     * 查询威海游钓型海洋牧场列表
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 威海游钓型海洋牧场
     */
    @Override
    public List<Fish_weihai> selectFish_weihaiList(Fish_weihai fish_weihai)
    {
        return fish_weihaiMapper.selectFish_weihaiList(fish_weihai);
    }

    /**
     * 新增威海游钓型海洋牧场
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int insertFish_weihai(Fish_weihai fish_weihai)
    {
        return fish_weihaiMapper.insertFish_weihai(fish_weihai);
    }

    /**
     * 修改威海游钓型海洋牧场
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int updateFish_weihai(Fish_weihai fish_weihai)
    {
        return fish_weihaiMapper.updateFish_weihai(fish_weihai);
    }

    /**
     * 批量删除威海游钓型海洋牧场
     * 
     * @param ids 需要删除的威海游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_weihaiByIds(String ids)
    {
        return fish_weihaiMapper.deleteFish_weihaiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除威海游钓型海洋牧场信息
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_weihaiById(Long id)
    {
        return fish_weihaiMapper.deleteFish_weihaiById(id);
    }

    @Override
    public Fish_weihai getLastRecord() {
        return fish_weihaiMapper.getLastRecord();
    }
}
