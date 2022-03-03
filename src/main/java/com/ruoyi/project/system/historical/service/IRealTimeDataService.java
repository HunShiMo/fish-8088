package com.ruoyi.project.system.historical.service;


import com.alibaba.fastjson.JSONObject;

/**
 * 获取实时服务
 *
 * @author ray
 * @date 2021/11/21 10:27
 */
public interface IRealTimeDataService {
    /**
     * 查询某天的数据
     *
     * @param date 日期
     * @return JSONObject
     */
    public JSONObject getDataInfo(String date);
}
