package com.ruoyi.project.system.rongcheng_now.controller;

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
import com.ruoyi.project.system.rongcheng_now.domain.RC_now;
import com.ruoyi.project.system.rongcheng_now.service.IRC_nowService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 荣成游钓型海洋牧场Controller
 * 实时数据
 * @author ruoyi
 * @date 2021-11-28
 */
@Controller
@RequestMapping("/system/rongcheng_now")
public class RC_nowController extends BaseController
{
    private String prefix = "system/rongcheng_now";

    @Autowired
    private IRC_nowService rC_nowService;

    @RequiresPermissions("system:rongcheng_now:view")
    @GetMapping()
    public String rongcheng_now()
    {
        return prefix + "/rongcheng_now";
    }

    /**
     * 查询荣成游钓型海洋牧场列表
     */
    @RequiresPermissions("system:rongcheng_now:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RC_now rC_now)
    {
        startPage();
        List<RC_now> list = rC_nowService.selectRC_nowList(rC_now);
        return getDataTable(list);
    }

    /**
     * 导出荣成游钓型海洋牧场列表
     */
    @RequiresPermissions("system:rongcheng_now:export")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RC_now rC_now)
    {
        List<RC_now> list = rC_nowService.selectRC_nowList(rC_now);
        ExcelUtil<RC_now> util = new ExcelUtil<RC_now>(RC_now.class);
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
    @RequiresPermissions("system:rongcheng_now:add")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RC_now rC_now)
    {
        return toAjax(rC_nowService.insertRC_now(rC_now));
    }

    /**
     * 修改荣成游钓型海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RC_now rC_now = rC_nowService.selectRC_nowById(id);
        mmap.put("rC_now", rC_now);
        return prefix + "/edit";
    }

    /**
     * 修改保存荣成游钓型海洋牧场
     */
    @RequiresPermissions("system:rongcheng_now:edit")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RC_now rC_now)
    {
        return toAjax(rC_nowService.updateRC_now(rC_now));
    }

    /**
     * 删除荣成游钓型海洋牧场
     */
    @RequiresPermissions("system:rongcheng_now:remove")
    @Log(title = "荣成游钓型海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rC_nowService.deleteRC_nowByIds(ids));
    }
}
