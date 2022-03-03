package com.ruoyi.project.system.Now_xixia.service;

import java.util.List;
import com.ruoyi.project.system.Now_xixia.domain.Xixia_Now;

/**
 * 西霞国家级海洋牧场Service接口
 * 
 * @author ruoyi
 * @date 2021-11-28
 */
public interface IXixia_NowService 
{
    /**
     * 查询西霞国家级海洋牧场
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 西霞国家级海洋牧场
     */
    public Xixia_Now selectXixia_NowById(Long id);

    /**
     * 查询西霞国家级海洋牧场列表
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 西霞国家级海洋牧场集合
     */
    public List<Xixia_Now> selectXixia_NowList(Xixia_Now xixia_Now);

    /**
     * 新增西霞国家级海洋牧场
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 结果
     */
    public int insertXixia_Now(Xixia_Now xixia_Now);

    /**
     * 修改西霞国家级海洋牧场
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 结果
     */
    public int updateXixia_Now(Xixia_Now xixia_Now);

    /**
     * 批量删除西霞国家级海洋牧场
     * 
     * @param ids 需要删除的西霞国家级海洋牧场主键集合
     * @return 结果
     */
    public int deleteXixia_NowByIds(String ids);

    /**
     * 删除西霞国家级海洋牧场信息
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 结果
     */
    public int deleteXixia_NowById(Long id);
}
