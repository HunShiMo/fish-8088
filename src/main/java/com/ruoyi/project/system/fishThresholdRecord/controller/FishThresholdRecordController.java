package com.ruoyi.project.system.fishThresholdRecord.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.fishThresholdRecord.domain.FishThresholdRecord;
import com.ruoyi.project.system.fishThresholdRecord.service.IFishThresholdRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 预警信息Controller
 * 
 * @author ray
 * @date 2021-12-09
 */
@Controller
@RequestMapping("/system/FishThresholdRecord")
public class FishThresholdRecordController extends BaseController
{
    private String prefix = "system/FishThresholdRecord";

    @Autowired
    private IFishThresholdRecordService fishThresholdRecordService;

    @RequiresPermissions("system:FishThresholdRecord:view")
    @GetMapping()
    public String FishThresholdRecord()
    {
        return prefix + "/FishThresholdRecord";
    }

    /**
     * 查询预警信息列表
     */
    @RequiresPermissions("system:FishThresholdRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FishThresholdRecord fishThresholdRecord)
    {
        startPage();
        List<FishThresholdRecord> list = fishThresholdRecordService.selectFishThresholdRecordList(fishThresholdRecord);
        return getDataTable(list);
    }

    /**
     * 导出预警信息列表
     */
    @RequiresPermissions("system:FishThresholdRecord:export")
    @Log(title = "预警信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FishThresholdRecord fishThresholdRecord)
    {
        List<FishThresholdRecord> list = fishThresholdRecordService.selectFishThresholdRecordList(fishThresholdRecord);
        ExcelUtil<FishThresholdRecord> util = new ExcelUtil<FishThresholdRecord>(FishThresholdRecord.class);
        return util.exportExcel(list, "预警信息数据");
    }

    /**
     * 新增预警信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预警信息
     */
//    @RequiresPermissions("system:FishThresholdRecord:add")
    @Log(title = "预警信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FishThresholdRecord fishThresholdRecord)
    {
        User sysUser = ShiroUtils.getSysUser();
        fishThresholdRecord.setUserId(sysUser.getUserId());
        return toAjax(fishThresholdRecordService.insertFishThresholdRecord(fishThresholdRecord));
    }

    /**
     * 修改预警信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        FishThresholdRecord fishThresholdRecord = fishThresholdRecordService.selectFishThresholdRecordById(id);
        mmap.put("fishThresholdRecord", fishThresholdRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存预警信息
     */
    @RequiresPermissions("system:FishThresholdRecord:edit")
    @Log(title = "预警信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FishThresholdRecord fishThresholdRecord)
    {
        return toAjax(fishThresholdRecordService.updateFishThresholdRecord(fishThresholdRecord));
    }

    /**
     * 删除预警信息
     */
    @RequiresPermissions("system:FishThresholdRecord:remove")
    @Log(title = "预警信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fishThresholdRecordService.deleteFishThresholdRecordByIds(ids));
    }
}
