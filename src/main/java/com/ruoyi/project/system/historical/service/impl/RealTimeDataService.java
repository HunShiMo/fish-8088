package com.ruoyi.project.system.historical.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.historical.domain.FishFarm;
import com.ruoyi.project.system.historical.mapper.RealTimeDataMapper;
import com.ruoyi.project.system.historical.service.IRealTimeDataService;
import com.ruoyi.project.system.historical.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取实时数据服务
 *
 * @author ray
 * @date 2021/11/21 10:27
 */
@Service
public class RealTimeDataService implements IRealTimeDataService {

    @Autowired
    RealTimeDataMapper realTimeDataMapper;

    @Override
    public JSONObject getDataInfo(String date) {
        List<FishFarm> fishFarmList = realTimeDataMapper.getDataInfo(date);
        JSONObject obj = DataUtils.processData(fishFarmList);
        return obj;
    }
}