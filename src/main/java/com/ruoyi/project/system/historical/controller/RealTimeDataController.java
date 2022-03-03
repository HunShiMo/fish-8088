package com.ruoyi.project.system.historical.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.historical.service.IRealTimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 发送某天的数据
 *
 * @author ray
 * @date 2021/11/21 2:28
 */
@Controller
@RequestMapping("/historical-data")
public class RealTimeDataController {

    @Autowired
    IRealTimeDataService realTimeDataService;

    @PostMapping("/get-data")
    @ResponseBody
    public JSONObject getInfo(@RequestParam String date) {
        System.out.println(date);
        JSONObject dataInfo = realTimeDataService.getDataInfo(date);
        return dataInfo;
    }
}
