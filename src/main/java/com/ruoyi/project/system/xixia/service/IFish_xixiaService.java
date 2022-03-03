package com.ruoyi.project.system.xixia.service;

import java.util.List;
import com.ruoyi.project.system.xixia.domain.Fish_xixia;

/**
 * 西霞国家级海洋牧场Service接口
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IFish_xixiaService 
{
    /**
     * 查询西霞国家级海洋牧场
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 西霞国家级海洋牧场
     */
    public Fish_xixia selectFish_xixiaById(Long id);

    /**
     * 查询西霞国家级海洋牧场列表
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 西霞国家级海洋牧场集合
     */
    public List<Fish_xixia> selectFish_xixiaList(Fish_xixia fish_xixia);

    /**
     * 新增西霞国家级海洋牧场
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 结果
     */
    public int insertFish_xixia(Fish_xixia fish_xixia);

    /**
     * 修改西霞国家级海洋牧场
     * 
     * @param fish_xixia 西霞国家级海洋牧场
     * @return 结果
     */
    public int updateFish_xixia(Fish_xixia fish_xixia);

    /**
     * 批量删除西霞国家级海洋牧场
     * 
     * @param ids 需要删除的西霞国家级海洋牧场主键集合
     * @return 结果
     */
    public int deleteFish_xixiaByIds(String ids);

    /**
     * 删除西霞国家级海洋牧场信息
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 结果
     */
    public int deleteFish_xixiaById(Long id);

    Fish_xixia getLastRecord();
}
