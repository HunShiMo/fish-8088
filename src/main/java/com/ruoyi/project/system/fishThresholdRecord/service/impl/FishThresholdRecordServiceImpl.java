package com.ruoyi.project.system.fishThresholdRecord.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.fishThresholdRecord.mapper.FishThresholdRecordMapper;
import com.ruoyi.project.system.fishThresholdRecord.domain.FishThresholdRecord;
import com.ruoyi.project.system.fishThresholdRecord.service.IFishThresholdRecordService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 预警信息Service业务层处理
 * 
 * @author ray
 * @date 2021-12-09
 */
@Service
public class FishThresholdRecordServiceImpl implements IFishThresholdRecordService 
{
    @Autowired
    private FishThresholdRecordMapper fishThresholdRecordMapper;

    /**
     * 查询预警信息
     * 
     * @param id 预警信息主键
     * @return 预警信息
     */
    @Override
    public FishThresholdRecord selectFishThresholdRecordById(Integer id)
    {
        return fishThresholdRecordMapper.selectFishThresholdRecordById(id);
    }

    /**
     * 查询预警信息列表
     * 
     * @param fishThresholdRecord 预警信息
     * @return 预警信息
     */
    @Override
    public List<FishThresholdRecord> selectFishThresholdRecordList(FishThresholdRecord fishThresholdRecord)
    {
        return fishThresholdRecordMapper.selectFishThresholdRecordList(fishThresholdRecord);
    }

    /**
     * 新增预警信息
     * 
     * @param fishThresholdRecord 预警信息
     * @return 结果
     */
    @Override
    public int insertFishThresholdRecord(FishThresholdRecord fishThresholdRecord)
    {
        return fishThresholdRecordMapper.insertFishThresholdRecord(fishThresholdRecord);
    }

    /**
     * 修改预警信息
     * 
     * @param fishThresholdRecord 预警信息
     * @return 结果
     */
    @Override
    public int updateFishThresholdRecord(FishThresholdRecord fishThresholdRecord)
    {
        return fishThresholdRecordMapper.updateFishThresholdRecord(fishThresholdRecord);
    }

    /**
     * 批量删除预警信息
     * 
     * @param ids 需要删除的预警信息主键
     * @return 结果
     */
    @Override
    public int deleteFishThresholdRecordByIds(String ids)
    {
        return fishThresholdRecordMapper.deleteFishThresholdRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除预警信息信息
     * 
     * @param id 预警信息主键
     * @return 结果
     */
    @Override
    public int deleteFishThresholdRecordById(Integer id)
    {
        return fishThresholdRecordMapper.deleteFishThresholdRecordById(id);
    }

    @Override
    public FishThresholdRecord getLastRecord(Long userId) {
        return fishThresholdRecordMapper.getLastRecord(userId);
    }
}
