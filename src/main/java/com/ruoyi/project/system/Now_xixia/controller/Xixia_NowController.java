package com.ruoyi.project.system.Now_xixia.controller;

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
import com.ruoyi.project.system.Now_xixia.domain.Xixia_Now;
import com.ruoyi.project.system.Now_xixia.service.IXixia_NowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 西霞国家级海洋牧场Controller
 * 实时数据
 * @author ruoyi
 * @date 2021-11-28
 */
@Controller
@RequestMapping("/system/Now_xixia")
public class Xixia_NowController extends BaseController
{
    private String prefix = "system/Now_xixia";

    @Autowired
    private IXixia_NowService xixia_NowService;

    @RequiresPermissions("system:Now_xixia:view")
    @GetMapping()
    public String Now_xixia()
    {
        return prefix + "/Now_xixia";
    }

    /**
     * 查询西霞国家级海洋牧场列表
     */
    @RequiresPermissions("system:Now_xixia:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Xixia_Now xixia_Now)
    {
        startPage();
        List<Xixia_Now> list = xixia_NowService.selectXixia_NowList(xixia_Now);
        return getDataTable(list);
    }

    /**
     * 导出西霞国家级海洋牧场列表
     */
    @RequiresPermissions("system:Now_xixia:export")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Xixia_Now xixia_Now)
    {
        List<Xixia_Now> list = xixia_NowService.selectXixia_NowList(xixia_Now);
        ExcelUtil<Xixia_Now> util = new ExcelUtil<Xixia_Now>(Xixia_Now.class);
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
    @RequiresPermissions("system:Now_xixia:add")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Xixia_Now xixia_Now)
    {
        return toAjax(xixia_NowService.insertXixia_Now(xixia_Now));
    }

    /**
     * 修改西霞国家级海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Xixia_Now xixia_Now = xixia_NowService.selectXixia_NowById(id);
        mmap.put("xixia_Now", xixia_Now);
        return prefix + "/edit";
    }

    /**
     * 修改保存西霞国家级海洋牧场
     */
    @RequiresPermissions("system:Now_xixia:edit")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Xixia_Now xixia_Now)
    {
        return toAjax(xixia_NowService.updateXixia_Now(xixia_Now));
    }

    /**
     * 删除西霞国家级海洋牧场
     */
    @RequiresPermissions("system:Now_xixia:remove")
    @Log(title = "西霞国家级海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xixia_NowService.deleteXixia_NowByIds(ids));
    }
}
