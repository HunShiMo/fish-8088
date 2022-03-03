package com.ruoyi.project.system.Weihai.controller;

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
import com.ruoyi.project.system.Weihai.domain.Fish_weihai;
import com.ruoyi.project.system.Weihai.service.IFish_weihaiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 威海游钓型海洋牧场Controller
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Controller
@RequestMapping("/system/Weihai")
public class Fish_weihaiController extends BaseController
{
    private String prefix = "system/Weihai";

    @Autowired
    private IFish_weihaiService fish_weihaiService;

    @RequiresPermissions("system:Weihai:view")
    @GetMapping()
    public String Weihai()
    {
        return prefix + "/Weihai";
    }

    /**
     * 查询威海游钓型海洋牧场列表
     */
    @RequiresPermissions("system:Weihai:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fish_weihai fish_weihai)
    {
        startPage();
        List<Fish_weihai> list = fish_weihaiService.selectFish_weihaiList(fish_weihai);
        return getDataTable(list);
    }

    /**
     * 导出威海游钓型海洋牧场列表
     */
    @RequiresPermissions("system:Weihai:export")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fish_weihai fish_weihai)
    {
        List<Fish_weihai> list = fish_weihaiService.selectFish_weihaiList(fish_weihai);
        ExcelUtil<Fish_weihai> util = new ExcelUtil<Fish_weihai>(Fish_weihai.class);
        return util.exportExcel(list, "威海游钓型海洋牧场数据");
    }

    /**
     * 新增威海游钓型海洋牧场
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存威海游钓型海洋牧场
     */
    @RequiresPermissions("system:Weihai:add")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fish_weihai fish_weihai)
    {
        return toAjax(fish_weihaiService.insertFish_weihai(fish_weihai));
    }

    /**
     * 修改威海游钓型海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Fish_weihai fish_weihai = fish_weihaiService.selectFish_weihaiById(id);
        mmap.put("fish_weihai", fish_weihai);
        return prefix + "/edit";
    }

    /**
     * 修改保存威海游钓型海洋牧场
     */
    @RequiresPermissions("system:Weihai:edit")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fish_weihai fish_weihai)
    {
        return toAjax(fish_weihaiService.updateFish_weihai(fish_weihai));
    }

    /**
     * 删除威海游钓型海洋牧场
     */
    @RequiresPermissions("system:Weihai:remove")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fish_weihaiService.deleteFish_weihaiByIds(ids));
    }
}
