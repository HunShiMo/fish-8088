package com.ruoyi.project.system.Weihai_Now.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.Weihai_Now.domain.Now_weihai;
import com.ruoyi.project.system.Weihai_Now.service.INow_weihaiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 威海游钓型海洋牧场Controller
 *实时数据
 * @author ruoyi
 * @date 2021-11-24
 */
@Controller
@Component("Now_weihaiController")
@RequestMapping("/system/Weihai_Now")
public class Now_weihaiController extends BaseController
{
    private String prefix = "system/Weihai_Now";

    @Autowired
    private INow_weihaiService now_weihaiService;
    @RequiresPermissions("system:Weihai_Now:view")
    @GetMapping()
    public String Weihai_Now()
    {
        return prefix + "/Weihai_Now";
    }

    /**
     * 查询威海游钓型海洋牧场列表
     */
    @RequiresPermissions("system:Weihai_Now:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Now_weihai now_weihai)
    {
        startPage();
        List<Now_weihai> list = now_weihaiService.selectNow_weihaiList(now_weihai);
        return getDataTable(list);
    }

    /**
     * 导出威海游钓型海洋牧场列表
     */
    @RequiresPermissions("system:Weihai_Now:export")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Now_weihai now_weihai)
    {
        List<Now_weihai> list = now_weihaiService.selectNow_weihaiList(now_weihai);
        ExcelUtil<Now_weihai> util = new ExcelUtil<Now_weihai>(Now_weihai.class);
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
    @RequiresPermissions("system:Weihai_Now:add")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Now_weihai now_weihai)
    {
        return toAjax(now_weihaiService.insertNow_weihai(now_weihai));
    }

    /**
     * 修改威海游钓型海洋牧场
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Now_weihai now_weihai = now_weihaiService.selectNow_weihaiById(id);
        mmap.put("now_weihai", now_weihai);
        return prefix + "/edit";
    }

    /**
     * 修改保存威海游钓型海洋牧场
     */
    @RequiresPermissions("system:Weihai_Now:edit")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Now_weihai now_weihai)
    {
        return toAjax(now_weihaiService.updateNow_weihai(now_weihai));
    }

    /**
     * 删除威海游钓型海洋牧场
     */
    @RequiresPermissions("system:Weihai_Now:remove")
    @Log(title = "威海游钓型海洋牧场", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(now_weihaiService.deleteNow_weihaiByIds(ids));
    }
}
