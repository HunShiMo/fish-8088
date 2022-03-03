package com.ruoyi.project.task;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.system.Weihai.domain.Fish_weihai;
import com.ruoyi.project.system.Weihai.service.IFish_weihaiService;
import com.ruoyi.project.system.rongcheng.domain.Fish_RC;
import com.ruoyi.project.system.rongcheng.service.IFish_RCService;
import com.ruoyi.project.system.fishThresholdRecord.domain.FishThresholdRecord;
import com.ruoyi.project.system.fishThresholdRecord.service.IFishThresholdRecordService;
import com.ruoyi.project.system.utils.SendEmailTool;
import com.ruoyi.project.system.xixia.domain.Fish_xixia;
import com.ruoyi.project.system.xixia.service.IFish_xixiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 预警
 *
 * @author ray
 * @date 2021/12/8 15:51
 */
@Component("threshold")
public class Threshold extends BaseController{


    @Autowired
    IFishThresholdRecordService fishThresholdRecordService;

    @Autowired
    IFish_RCService fish_rcService;

    @Autowired
    IFish_weihaiService fish_weihaiService;

    @Autowired
    IFish_xixiaService fish_xixiaService;

    String message = "";

    private static final Long USER_ID_ADMIN = 1L;
    private static final Long USER_ID_QIXIA = 106L;
    private static final Long USER_ID_SANGGOU = 105L;
    private static final Long USER_ID_XIAOSHIDAO = 107L;

    public void run() {
        FishThresholdRecord fishThresholdRecordAdmin =  fishThresholdRecordService.getLastRecord(USER_ID_ADMIN);
        FishThresholdRecord fishThresholdRecordQiXia =  fishThresholdRecordService.getLastRecord(USER_ID_QIXIA);
        FishThresholdRecord fishThresholdRecordSangGou =  fishThresholdRecordService.getLastRecord(USER_ID_SANGGOU);
        FishThresholdRecord fishThresholdRecordXiaoShiDao =  fishThresholdRecordService.getLastRecord(USER_ID_XIAOSHIDAO);
        Fish_RC fish_rc = fish_rcService.getLastRecord();
        Fish_weihai fish_weihai = fish_weihaiService.getLastRecord();
        Fish_xixia fish_xixia = fish_xixiaService.getLastRecord();

        System.out.println("===============================================信息输出===================================================================");

        System.out.println(fishThresholdRecordAdmin);
        System.out.println();
        System.out.println(fishThresholdRecordQiXia);
        System.out.println();
        System.out.println(fishThresholdRecordSangGou);
        System.out.println();
        System.out.println(fishThresholdRecordXiaoShiDao);
        System.out.println();
        System.out.println(fish_rc);
        System.out.println();
        System.out.println(fish_weihai);
        System.out.println();
        System.out.println(fish_xixia);

        System.out.println("===============================================结束===================================================================");

        boolean compare = compare(fishThresholdRecordAdmin, fish_rc);
        if (compare) {
            SendEmailTool.sendOneEmail(fishThresholdRecordAdmin.getEmailReceiver(), message);
        }
        message = "";
        compare = compare(fishThresholdRecordQiXia, fish_xixia);
        if (compare) {
            SendEmailTool.sendOneEmail(fishThresholdRecordQiXia.getEmailReceiver(), message);
        }
        message = "";
        compare = compare(fishThresholdRecordSangGou, fish_rc);
        if (compare) {
            SendEmailTool.sendOneEmail(fishThresholdRecordSangGou.getEmailReceiver(), message);
        }
        message = "";
        compare = compare(fishThresholdRecordXiaoShiDao, fish_weihai);
        if (compare) {
            SendEmailTool.sendOneEmail(fishThresholdRecordXiaoShiDao.getEmailReceiver(), message);
        }
    }

    public boolean compare(FishThresholdRecord thresholdRecord, Fish_RC fish_rc) {
        boolean flag = false;
        if (Double.parseDouble(fish_rc.getTemp()) > thresholdRecord.getTmpMax()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "大于预警值" + thresholdRecord.getTmpMax() + "，");
        } else if (Double.parseDouble(fish_rc.getTemp()) < thresholdRecord.getTmpMin()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "小于预警值" + thresholdRecord.getTmpMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getSalt()) > thresholdRecord.getSaltMax()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "大于预警值" + thresholdRecord.getSaltMax() + "，");
        } else if (Double.parseDouble(fish_rc.getSalt()) < thresholdRecord.getSaltMin()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "小于预警值" + thresholdRecord.getSaltMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getDeep()) > thresholdRecord.getDeepMax()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "大于预警值" + thresholdRecord.getDeepMax() + "，");
        } else if (Double.parseDouble(fish_rc.getDeep()) < thresholdRecord.getDeepMin()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "小于预警值" + thresholdRecord.getDeepMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getYlsCon()) > thresholdRecord.getYlsMax()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "大于预警值" + thresholdRecord.getYlsMax() + "，");
        } else if (Double.parseDouble(fish_rc.getYlsCon()) < thresholdRecord.getYlsMin()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "小于预警值" + thresholdRecord.getYlsMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getRjyCon()) > thresholdRecord.getRjyMax()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "大于预警值" + thresholdRecord.getRjyMax() + "，");
        } else if (Double.parseDouble(fish_rc.getRjyCon()) < thresholdRecord.getRjyMin()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "小于预警值" + thresholdRecord.getRjyMin() + "，");
        }

        return flag;
    }

    public boolean compare(FishThresholdRecord thresholdRecord, Fish_weihai fish_rc) {
        boolean flag = false;
        if (Double.parseDouble(fish_rc.getTemp()) > thresholdRecord.getTmpMax()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "大于预警值" + thresholdRecord.getTmpMax() + "，");
        } else if (Double.parseDouble(fish_rc.getTemp()) < thresholdRecord.getTmpMin()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "小于预警值" + thresholdRecord.getTmpMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getSalt()) > thresholdRecord.getSaltMax()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "大于预警值" + thresholdRecord.getSaltMax() + "，");
        } else if (Double.parseDouble(fish_rc.getSalt()) < thresholdRecord.getSaltMin()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "小于预警值" + thresholdRecord.getSaltMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getDeep()) > thresholdRecord.getDeepMax()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "大于预警值" + thresholdRecord.getDeepMax() + "，");
        } else if (Double.parseDouble(fish_rc.getDeep()) < thresholdRecord.getDeepMin()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "小于预警值" + thresholdRecord.getDeepMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getYlsCon()) > thresholdRecord.getYlsMax()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "大于预警值" + thresholdRecord.getYlsMax() + "，");
        } else if (Double.parseDouble(fish_rc.getYlsCon()) < thresholdRecord.getYlsMin()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "小于预警值" + thresholdRecord.getYlsMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getRjyCon()) > thresholdRecord.getRjyMax()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "大于预警值" + thresholdRecord.getRjyMax() + "，");
        } else if (Double.parseDouble(fish_rc.getRjyCon()) < thresholdRecord.getRjyMin()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "小于预警值" + thresholdRecord.getRjyMin() + "。");
        }

        return flag;
    }

    public boolean compare(FishThresholdRecord thresholdRecord, Fish_xixia fish_rc) {
        boolean flag = false;
        if (Double.parseDouble(fish_rc.getTemp()) > thresholdRecord.getTmpMax()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "大于预警值" + thresholdRecord.getTmpMax() + "，");
        } else if (Double.parseDouble(fish_rc.getTemp()) < thresholdRecord.getTmpMin()) {
            flag = true;
            message = message.concat("当前水温" + fish_rc.getTemp() + "小于预警值" + thresholdRecord.getTmpMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getSalt()) > thresholdRecord.getSaltMax()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "大于预警值" + thresholdRecord.getSaltMax() + "，");
        } else if (Double.parseDouble(fish_rc.getSalt()) < thresholdRecord.getSaltMin()) {
            flag = true;
            message = message.concat("当前盐度" + fish_rc.getSalt() + "小于预警值" + thresholdRecord.getSaltMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getDeep()) > thresholdRecord.getDeepMax()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "大于预警值" + thresholdRecord.getDeepMax() + "，");
        } else if (Double.parseDouble(fish_rc.getDeep()) < thresholdRecord.getDeepMin()) {
            flag = true;
            message = message.concat("当前深度" + fish_rc.getDeep() + "小于预警值" + thresholdRecord.getDeepMin() + "，");
        }
        if (Double.parseDouble(fish_rc.getYlsCon()) > thresholdRecord.getYlsMax()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "大于预警值" + thresholdRecord.getYlsMax() + "，");
        } else if (Double.parseDouble(fish_rc.getYlsCon()) < thresholdRecord.getYlsMin()) {
            flag = true;
            message = message.concat("当前叶绿素" + fish_rc.getYlsCon() + "小于预警值" + thresholdRecord.getYlsMin() + "。");
        }
        if (Double.parseDouble(fish_rc.getRjyCon()) > thresholdRecord.getRjyMax()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "大于预警值" + thresholdRecord.getRjyMax() + "，");
        } else if (Double.parseDouble(fish_rc.getRjyCon()) < thresholdRecord.getRjyMin()) {
            flag = true;
            message = message.concat("当前溶解氧" + fish_rc.getRjyCon() + "小于预警值" + thresholdRecord.getRjyMin() + "。");
        }

        return flag;
    }

}
