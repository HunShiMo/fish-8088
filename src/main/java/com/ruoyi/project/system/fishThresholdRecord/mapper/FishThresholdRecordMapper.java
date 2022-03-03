package com.ruoyi.project.system.fishThresholdRecord.mapper;

import java.util.List;
import com.ruoyi.project.system.fishThresholdRecord.domain.FishThresholdRecord;

/**
 * 预警信息Mapper接口
 * 
 * @author ray
 * @date 2021-12-09
 */
public interface FishThresholdRecordMapper 
{
    /**
     * 查询预警信息
     * 
     * @param id 预警信息主键
     * @return 预警信息
     */
    public FishThresholdRecord selectFishThresholdRecordById(Integer id);

    /**
     * 查询预警信息列表
     * 
     * @param fishThresholdRecord 预警信息
     * @return 预警信息集合
     */
    public List<FishThresholdRecord> selectFishThresholdRecordList(FishThresholdRecord fishThresholdRecord);

    /**
     * 新增预警信息
     * 
     * @param fishThresholdRecord 预警信息
     * @return 结果
     */
    public int insertFishThresholdRecord(FishThresholdRecord fishThresholdRecord);

    /**
     * 修改预警信息
     * 
     * @param fishThresholdRecord 预警信息
     * @return 结果
     */
    public int updateFishThresholdRecord(FishThresholdRecord fishThresholdRecord);

    /**
     * 删除预警信息
     * 
     * @param id 预警信息主键
     * @return 结果
     */
    public int deleteFishThresholdRecordById(Integer id);

    /**
     * 批量删除预警信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFishThresholdRecordByIds(String[] ids);

    FishThresholdRecord getLastRecord(Long userId);
}
