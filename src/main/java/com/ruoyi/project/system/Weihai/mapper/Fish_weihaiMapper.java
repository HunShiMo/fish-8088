package com.ruoyi.project.system.Weihai.mapper;

import java.util.List;
import com.ruoyi.project.system.Weihai.domain.Fish_weihai;

/**
 * 威海游钓型海洋牧场Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
public interface Fish_weihaiMapper 
{
    /**
     * 查询威海游钓型海洋牧场
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 威海游钓型海洋牧场
     */
    public Fish_weihai selectFish_weihaiById(Long id);

    /**
     * 查询威海游钓型海洋牧场列表
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 威海游钓型海洋牧场集合
     */
    public List<Fish_weihai> selectFish_weihaiList(Fish_weihai fish_weihai);

    /**
     * 新增威海游钓型海洋牧场
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    public int insertFish_weihai(Fish_weihai fish_weihai);

    /**
     * 修改威海游钓型海洋牧场
     * 
     * @param fish_weihai 威海游钓型海洋牧场
     * @return 结果
     */
    public int updateFish_weihai(Fish_weihai fish_weihai);

    /**
     * 删除威海游钓型海洋牧场
     * 
     * @param id 威海游钓型海洋牧场主键
     * @return 结果
     */
    public int deleteFish_weihaiById(Long id);

    /**
     * 批量删除威海游钓型海洋牧场
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFish_weihaiByIds(String[] ids);

    Fish_weihai getLastRecord();
}
