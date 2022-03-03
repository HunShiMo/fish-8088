package com.ruoyi.project.system.xixia.controller;

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
import com.ruoyi.project.system.xixia.domain.Fish_xixia;
import com.ruoyi.project.system.xixia.service.IFish_xixiaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 西霞国家级海洋牧场Controller
 * 
 * @author ruoyi
 * @date 2021-11-21
 */
@Controller
@RequestMapping("/system/xixia")
public class Fish_xixiaController extends BaseController
{
    private String prefix = "system/xixia";

    @Autowired
    private IFish_xixiaService fish_xixiaService;

    @RequiresPermissions("system:xixia:view")
    @GetMapping()
    public String xixia()
    {
        return prefix + "/xixia";
    }

    /**
     * 查询西霞国家级海洋牧场列表
     */
    @RequiresPermissions("system:xixia:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fish_xixia fish_xixia)
    {
        startPage();
        List<Fish_xixia> list = fish_xixiaService.selectFish_xixiaList(fish_xixia);
        return getDataTable(list);
    }

    /**
     * 导出西霞国家级海洋牧场列表
     */
    @RequiresPermissions("system:xixia:export")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fish_xixia fish_xixia)
    {
        List<Fish_xixia> list = fish_xixiaService.selectFish_xixiaList(fish_xixia);
        ExcelUtil<Fish_xixia> util = new ExcelUtil<Fish_xixia>(Fish_xixia.class);
        return util.exportExcel(list, "西霞国家级海洋牧场数据");
    }

    /**
     * 新增西霞国家级海洋牧场
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存西霞国家级海洋牧场
     */
    @RequiresPermissions("system:xixia:add")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fish_xixia fish_xixia)
    {
        return toAjax(fish_xixiaService.insertFish_xixia(fish_xixia));
    }

    /**
     * 修改西霞国家级海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Fish_xixia fish_xixia = fish_xixiaService.selectFish_xixiaById(id);
        mmap.put("fish_xixia", fish_xixia);
        return prefix + "/edit";
    }

    /**
     * 修改保存西霞国家级海洋牧场
     */
    @RequiresPermissions("system:xixia:edit")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fish_xixia fish_xixia)
    {
        return toAjax(fish_xixiaService.updateFish_xixia(fish_xixia));
    }

    /**
     * 删除西霞国家级海洋牧场
     */
    @RequiresPermissions("system:xixia:remove")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fish_xixiaService.deleteFish_xixiaByIds(ids));
    }
}
