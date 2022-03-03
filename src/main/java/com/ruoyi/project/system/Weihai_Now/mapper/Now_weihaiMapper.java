package com.ruoyi.project.system.Weihai_Now.mapper;

import java.util.List;
import com.ruoyi.project.system.Weihai_Now.domain.Now_weihai;

/**
 * 威海游钓型海洋牧场Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-24
 */
public interface Now_weihaiMapper 
{
    /**
     * 查询威海游钓型海洋牧场
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 威海游钓型海洋牧场
     */
    public Now_weihai selectNow_weihaiById(Long id);

    /**
     * 查询威海游钓型海洋牧场列表
     * 
     * @param now_weihai 威海游钓型海洋牧场
     * @return 威海游钓型海洋牧场集合
     */
    public List<Now_weihai> selectNow_weihaiList(Now_weihai now_weihai);

    /**
     * 新增威海游钓型海洋牧场
     * 
     * @param now_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    public int insertNow_weihai(Now_weihai now_weihai);

    /**
     * 修改威海游钓型海洋牧场
     * 
     * @param now_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    public int updateNow_weihai(Now_weihai now_weihai);

    /**
     * 删除威海游钓型海洋牧场
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 结果
     */
    public int deleteNow_weihaiById(Long id);

    /**
     * 批量删除威海游钓型海洋牧场
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNow_weihaiByIds(String[] ids);
}
