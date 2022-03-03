package com.ruoyi.project.system.historical.utils;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.historical.domain.FishFarm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 处理历史数据
 *
 * @author ray
 * @date 2021/11/23 21:49
 */
public class DataUtils {
    /** 养鱼场有5种属性 */
    private static final int TYPE = 5;

    /** 一天24小时，数据表的列数 */
    private static final int HOURS = 24;

    public static JSONObject processData(List<FishFarm> fishFarmList) {
        JSONObject obj = new JSONObject();
        if (fishFarmList.isEmpty()) {
            obj.put("code", 500);
            return obj;
        } else {
            int[][] dataCount = new int[TYPE][HOURS];
            float[][] dataSum = new float[TYPE][HOURS];

            // 初始化，全部变为0
            for (int i=0; i<TYPE; i++) {
                for (int j=0; j<HOURS; j++) {
                    dataCount[i][j] = 0;
                    dataSum[i][j] = 0f;
                }
            }

            for (FishFarm fishFarm : fishFarmList) {
                int hour = Integer.parseInt(fishFarm.getHour());
                float temp = Float.parseFloat(fishFarm.getTemp());
                float salt = Float.parseFloat(fishFarm.getSalt());
                float yls = Float.parseFloat(fishFarm.getYlsCon());
                float rjy = Float.parseFloat(fishFarm.getRjyCon());
                float deep = Float.parseFloat(fishFarm.getDeep());
                if(!CompareUtils.isEqual(temp, -1)){
                    dataSum[0][hour] += temp;
                    dataCount[0][hour]++;
                }
                if(!CompareUtils.isEqual(salt, -1)){
                    dataSum[1][hour] += salt;
                    dataCount[1][hour]++;
                }
                if(!CompareUtils.isEqual(yls, -1)){
                    dataSum[2][hour] += yls;
                    dataCount[2][hour]++;
                }
                if(!CompareUtils.isEqual(rjy, -1)){
                    dataSum[3][hour] += rjy;
                    dataCount[3][hour]++;
                }
                if(!CompareUtils.isEqual(deep, -1)){
                    dataSum[4][hour] += rjy;
                    dataCount[4][hour]++;
                }
            }

            // 求平均值
            float[][] dataAveraged = new float[TYPE][HOURS];
            float average;
            for (int i=0; i<TYPE; i++) {
                for (int j=0; j<HOURS; j++) {
                    average = dataCount[i][j] == 0 ? 0f : dataSum[i][j] / dataCount[i][j];
                    BigDecimal decimal = new BigDecimal(average);
                    average = decimal.setScale(2, RoundingMode.HALF_UP).floatValue();
                    dataAveraged[i][j] = average;
                }
            }

            obj.put("temp", dataAveraged[0]);
            obj.put("salt", dataAveraged[1]);
            obj.put("yls",  dataAveraged[2]);
            obj.put("rjy",  dataAveraged[3]);
            obj.put("deep", dataAveraged[4]);
            obj.put("temp_min", DataUtils.getDataMin(dataAveraged[0]));
            obj.put("temp_max", DataUtils.getDataMax(dataAveraged[0]));
            obj.put("salt_min", DataUtils.getDataMin(dataAveraged[1]));
            obj.put("salt_max", DataUtils.getDataMax(dataAveraged[1]));
            obj.put("yls_min",  DataUtils.getDataMin(dataAveraged[2]));
            obj.put("yls_max",  DataUtils.getDataMax(dataAveraged[2]));
            obj.put("rjy_min",  DataUtils.getDataMin(dataAveraged[3]));
            obj.put("rjy_max",  DataUtils.getDataMax(dataAveraged[3]));
            obj.put("deep_min", DataUtils.getDataMin(dataAveraged[4]));
            obj.put("deep_max", DataUtils.getDataMax(dataAveraged[4]));
            obj.put("code", 200);
        }

        System.out.println(obj);
        return obj;
    }

    private static float getDataMax(float[] data) {
        float max = Float.MIN_VALUE;
        for (float datum : data) {
            max = Float.max(max, datum);
        }
        return max;
    }

    private static float getDataMin(float[] data) {
        float min = Float.MAX_VALUE;
        for (float datum : data) {
            min = Float.min(min, datum);
        }
        return min;
    }

}
