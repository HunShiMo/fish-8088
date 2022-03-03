package com.ruoyi.project.system.email.controller;

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
import com.ruoyi.project.system.email.domain.UserEmail;
import com.ruoyi.project.system.email.service.IUserEmailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 数值预警Controller
 * 
 * @author ruoyi
 * @date 2021-12-05
 */
@Controller
@RequestMapping("/system/email")
public class UserEmailController extends BaseController
{
    private String prefix = "system/email";

    @Autowired
    private IUserEmailService userEmailService;

    @RequiresPermissions("system:email:view")
    @GetMapping()
    public String email()
    {
        return prefix + "/email";
    }

    /**
     * 查询数值预警列表
     */
    @RequiresPermissions("system:email:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserEmail userEmail)
    {
        startPage();
        List<UserEmail> list = userEmailService.selectUserEmailList(userEmail);
        return getDataTable(list);
    }

    /**
     * 导出数值预警列表
     */
    @RequiresPermissions("system:email:export")
    @Log(title = "数值预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserEmail userEmail)
    {
        List<UserEmail> list = userEmailService.selectUserEmailList(userEmail);
        ExcelUtil<UserEmail> util = new ExcelUtil<UserEmail>(UserEmail.class);
        return util.exportExcel(list, "数值预警数据");
    }

    /**
     * 新增数值预警
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数值预警
     */
    @RequiresPermissions("system:email:add")
    @Log(title = "数值预警", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserEmail userEmail)
    {
        return toAjax(userEmailService.insertUserEmail(userEmail));
    }

    /**
     * 修改数值预警
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserEmail userEmail = userEmailService.selectUserEmailById(id);
        mmap.put("userEmail", userEmail);
        return prefix + "/edit";
    }

    /**
     * 修改保存数值预警
     */
    @RequiresPermissions("system:email:edit")
    @Log(title = "数值预警", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserEmail userEmail)
    {
        return toAjax(userEmailService.updateUserEmail(userEmail));
    }

    /**
     * 删除数值预警
     */
    @RequiresPermissions("system:email:remove")
    @Log(title = "数值预警", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userEmailService.deleteUserEmailByIds(ids));
    }
}
