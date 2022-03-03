package com.ruoyi.project.system.historical.mapper;

import com.ruoyi.project.system.historical.domain.FishFarm;

import java.util.List;

/**
 * 获取实时数据接口
 *
 * @author ray
 * @date 2021/11/21 10:29
 */
public interface RealTimeDataMapper {

    /**
     * 查询某天的数据
     *
     * @param date 日期
     * @return List<FishFarm> 某天的数据集合
     */
    public List<FishFarm> getDataInfo(String date);
}
