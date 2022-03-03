package com.ruoyi.project.system.rongcheng.controller;

import java.util.List;
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
import com.ruoyi.project.system.rongcheng.domain.Fish_RC;
import com.ruoyi.project.system.rongcheng.service.IFish_RCService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 荣成游钓型海洋牧场Controller
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Controller
@RequestMapping("/system/rongcheng")
public class Fish_RCController extends BaseController
{
    private String prefix = "system/rongcheng";

    @Autowired
    private IFish_RCService fish_RCService;

    @RequiresPermissions("system:rongcheng:view")
    @GetMapping()
    public String rongcheng()
    {
        return prefix + "/rongcheng";
    }

    /**
     * 查询荣成游钓型海洋牧场列表
     */
    @RequiresPermissions("system:rongcheng:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fish_RC fish_RC)
    {
        startPage();
        List<Fish_RC> list = fish_RCService.selectFish_RCList(fish_RC);
        return getDataTable(list);
    }

    /**
     * 导出荣成游钓型海洋牧场列表
     */
    @RequiresPermissions("system:rongcheng:export")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fish_RC fish_RC)
    {
        List<Fish_RC> list = fish_RCService.selectFish_RCList(fish_RC);
        ExcelUtil<Fish_RC> util = new ExcelUtil<Fish_RC>(Fish_RC.class);
        return util.exportExcel(list, "荣成游钓型海洋牧场数据");
    }

    /**
     * 新增荣成游钓型海洋牧场
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存荣成游钓型海洋牧场
     */
    @RequiresPermissions("system:rongcheng:add")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fish_RC fish_RC)
    {
        return toAjax(fish_RCService.insertFish_RC(fish_RC));
    }

    /**
     * 修改荣成游钓型海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Fish_RC fish_RC = fish_RCService.selectFish_RCById(id);
        mmap.put("fish_RC", fish_RC);
        return prefix + "/edit";
    }

    /**
     * 修改保存荣成游钓型海洋牧场
     */
    @RequiresPermissions("system:rongcheng:edit")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fish_RC fish_RC)
    {
        return toAjax(fish_RCService.updateFish_RC(fish_RC));
    }

    /**
     * 删除荣成游钓型海洋牧场
     */
    @RequiresPermissions("system:rongcheng:remove")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fish_RCService.deleteFish_RCByIds(ids));
    }
}
