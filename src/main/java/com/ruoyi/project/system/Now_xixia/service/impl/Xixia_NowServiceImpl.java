package com.ruoyi.project.system.Now_xixia.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.Now_xixia.mapper.Xixia_NowMapper;
import com.ruoyi.project.system.Now_xixia.domain.Xixia_Now;
import com.ruoyi.project.system.Now_xixia.service.IXixia_NowService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 西霞国家级海洋牧场Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-28
 */
@Service
public class Xixia_NowServiceImpl implements IXixia_NowService 
{
    @Autowired
    private Xixia_NowMapper xixia_NowMapper;

    /**
     * 查询西霞国家级海洋牧场
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 西霞国家级海洋牧场
     */
    @Override
    public Xixia_Now selectXixia_NowById(Long id)
    {
        return xixia_NowMapper.selectXixia_NowById(id);
    }

    /**
     * 查询西霞国家级海洋牧场列表
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 西霞国家级海洋牧场
     */
    @Override
    public List<Xixia_Now> selectXixia_NowList(Xixia_Now xixia_Now)
    {
        return xixia_NowMapper.selectXixia_NowList(xixia_Now);
    }

    /**
     * 新增西霞国家级海洋牧场
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 结果
     */
    @Override
    public int insertXixia_Now(Xixia_Now xixia_Now)
    {
        return xixia_NowMapper.insertXixia_Now(xixia_Now);
    }

    /**
     * 修改西霞国家级海洋牧场
     * 
     * @param xixia_Now 西霞国家级海洋牧场
     * @return 结果
     */
    @Override
    public int updateXixia_Now(Xixia_Now xixia_Now)
    {
        return xixia_NowMapper.updateXixia_Now(xixia_Now);
    }

    /**
     * 批量删除西霞国家级海洋牧场
     * 
     * @param ids 需要删除的西霞国家级海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteXixia_NowByIds(String ids)
    {
        return xixia_NowMapper.deleteXixia_NowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除西霞国家级海洋牧场信息
     * 
     * @param id 西霞国家级海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteXixia_NowById(Long id)
    {
        return xixia_NowMapper.deleteXixia_NowById(id);
    }
}
