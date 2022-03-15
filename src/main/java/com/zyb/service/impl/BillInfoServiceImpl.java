package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.BillInfo;
import com.zyb.mapper.BillInfoMapper;
import com.zyb.service.BillInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {

    @Resource
    private BillInfoMapper billInfoMapper;


    /**
     * 分页查询账单信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> wrapper = new QueryWrapper<>();
        if (param != null) {
            wrapper.eq("supplier_name", param);
        }
        Page<BillInfo> page = new Page<>(pageNum, pageSize);
        return billInfoMapper.selectPage(page, wrapper);
    }

    /**
     * 新增一条账单信息信息
     *
     * @param billInfo
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * 修改一条账单信息信息
     *
     * @param billInfo
     */
    @Override
    public int editBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * 根据主键id查询一个账单信息对象
     *
     * @param id
     * @return
     */
    @Override
    public BillInfo queryBillInfoById(Integer id) {
        return billInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个账单信息对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteBillInfoById(Integer id) {
        return billInfoMapper.deleteById(id);
    }
}
