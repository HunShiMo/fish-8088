package com.ruoyi.project.system.rongcheng_now.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.rongcheng_now.mapper.RC_nowMapper;
import com.ruoyi.project.system.rongcheng_now.domain.RC_now;
import com.ruoyi.project.system.rongcheng_now.service.IRC_nowService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 荣成游钓型海洋牧场Service业务层处理
 * 实时数据
 * @author ruoyi
 * @date 2021-11-28
 */
@Service
public class RC_nowServiceImpl implements IRC_nowService
{
    @Autowired
    private RC_nowMapper rC_nowMapper;

    /**
     * 查询荣成游钓型海洋牧场
     *
     * @param id 荣成游钓型海洋牧场主键
     * @return 荣成游钓型海洋牧场
     */
    @Override
    public RC_now selectRC_nowById(Long id)
    {
        return rC_nowMapper.selectRC_nowById(id);
    }

    /**
     * 查询荣成游钓型海洋牧场列表
     *
     * @param rC_now 荣成游钓型海洋牧场
     * @return 荣成游钓型海洋牧场
     */
    @Override
    public List<RC_now> selectRC_nowList(RC_now rC_now)
    {
        return rC_nowMapper.selectRC_nowList(rC_now);
    }

    /**
     * 新增荣成游钓型海洋牧场
     *
     * @param rC_now 荣成游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int insertRC_now(RC_now rC_now)
    {
        return rC_nowMapper.insertRC_now(rC_now);
    }

    /**
     * 修改荣成游钓型海洋牧场
     *
     * @param rC_now 荣成游钓型海洋牧场
     * @return 结果
     */
    @Override
    public int updateRC_now(RC_now rC_now)
    {
        return rC_nowMapper.updateRC_now(rC_now);
    }

    /**
     * 批量删除荣成游钓型海洋牧场
     *
     * @param ids 需要删除的荣成游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteRC_nowByIds(String ids)
    {
        return rC_nowMapper.deleteRC_nowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除荣成游钓型海洋牧场信息
     *
     * @param id 荣成游钓型海洋牧场主键
     * @return 结果
     */
    @Override
    public int deleteRC_nowById(Long id)
    {
        return rC_nowMapper.deleteRC_nowById(id);
    }
}
