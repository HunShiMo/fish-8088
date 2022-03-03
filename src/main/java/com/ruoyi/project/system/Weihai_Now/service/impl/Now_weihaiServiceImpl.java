package com.ruoyi.project.system.Weihai_Now.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.Weihai_Now.mapper.Now_weihaiMapper;
import com.ruoyi.project.system.Weihai_Now.domain.Now_weihai;
import com.ruoyi.project.system.Weihai_Now.service.INow_weihaiService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 威海游钓型海洋牧场Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-24
 */
@Service
public class Now_weihaiServiceImpl implements INow_weihaiService
{
    @Autowired
    private Now_weihaiMapper now_weihaiMapper;

    /**
     * 查询威海游钓型海洋牧场
     *
     * @param id 威海游钓型海洋牧场主键
     * @return 威海游钓型海洋牧场
     */
    @Override
    public Now_weihai selectNow_weihaiById(Long id)
    {
        return now_weihaiMapper.selectNow_weihaiById(id);
    }

    /**
     * 查询威海游钓型海洋牧场列表
     *
     * @param now_weihai 威海游钓型海洋牧场
     * @return 威海游钓型海洋牧场
     */
    @Override
    public List<Now_weihai> selectNow_weihaiList(Now_weihai now_weihai)
    {
        return now_weihaiMapper.selectNow_weihaiList(now_weihai);
    }

    /**
     * 新增威海游钓型海洋牧场
     *
     * @param now_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int insertNow_weihai(Now_weihai now_weihai)
    {
        return now_weihaiMapper.insertNow_weihai(now_weihai);
    }

    /**
     * 修改威海游钓型海洋牧场
     *
     * @param now_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int updateNow_weihai(Now_weihai now_weihai)
    {
        return now_weihaiMapper.updateNow_weihai(now_weihai);
    }

    /**
     * 批量删除威海游钓型海洋牧场
     *
     * @param ids 需要删除的威海游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteNow_weihaiByIds(String ids)
    {
        return now_weihaiMapper.deleteNow_weihaiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除威海游钓型海洋牧场信息
     *
     * @param id 威海游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteNow_weihaiById(Long id)
    {
        return now_weihaiMapper.deleteNow_weihaiById(id);
    }
}
