package com.ruoyi.project.system.xixia.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.xixia.mapper.Fish_xixiaMapper;
import com.ruoyi.project.system.xixia.domain.Fish_xixia;
import com.ruoyi.project.system.xixia.service.IFish_xixiaService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 西霞国家级海洋牧场Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class Fish_xixiaServiceImpl implements IFish_xixiaService 
{
    @Autowired
    private Fish_xixiaMapper fish_xixiaMapper;

    /**
     * 查询西霞国家级海洋牧场
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 西霞国家级海洋牧场
     */
    @Override
    public Fish_xixia selectFish_xixiaById(Long id)
    {
        return fish_xixiaMapper.selectFish_xixiaById(id);
    }

    /**
     * 查询西霞国家级海洋牧场列表
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 西霞国家级海洋牧场
     */
    @Override
    public List<Fish_xixia> selectFish_xixiaList(Fish_xixia fish_xixia)
    {
        return fish_xixiaMapper.selectFish_xixiaList(fish_xixia);
    }

    /**
     * 新增西霞国家级海洋牧场
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 结果
     */
    @Override
    public int insertFish_xixia(Fish_xixia fish_xixia)
    {
        return fish_xixiaMapper.insertFish_xixia(fish_xixia);
    }

    /**
     * 修改西霞国家级海洋牧场
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 结果
     */
    @Override
    public int updateFish_xixia(Fish_xixia fish_xixia)
    {
        return fish_xixiaMapper.updateFish_xixia(fish_xixia);
    }

    /**
     * 批量删除西霞国家级海洋牧场
     * 
     * @param ids 需要删除的西霞国家级海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_xixiaByIds(String ids)
    {
        return fish_xixiaMapper.deleteFish_xixiaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除西霞国家级海洋牧场信息
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteFish_xixiaById(Long id)
    {
        return fish_xixiaMapper.deleteFish_xixiaById(id);
    }

    @Override
    public Fish_xixia getLastRecord() {
        return fish_xixiaMapper.getLastRecord();
    }
}
