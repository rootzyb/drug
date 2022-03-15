package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.SaleInfo;
import com.zyb.mapper.SaleInfoMapper;
import com.zyb.service.SaleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaleInfoServiceImpl extends ServiceImpl<SaleInfoMapper, SaleInfo> implements SaleInfoService {

    @Resource
    private SaleInfoMapper saleInfoMapper;

    /**
     * 分页查询销售记录数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-销售记录名称
     * @return
     */
    @Override
    public IPage<SaleInfo> selectSaleInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<SaleInfo> wrapper=new QueryWrapper<>();
        if (param!=null){
            wrapper.like("drug_name",param);
        }
        Page<SaleInfo> page=new Page<>(pageNum,pageSize);
        return saleInfoMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条销售记录信息
     *
     * @param saleInfo
     */
    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insert(saleInfo);
    }

    /**
     * 修改一条销售记录信息
     *
     * @param saleInfo
     */
    @Override
    public int editSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateById(saleInfo);
    }

    /**
     * 根据主键id查询一个销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public SaleInfo querySaleInfoById(Integer id) {
        return saleInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个销售记录对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteSaleInfoById(Integer id) {
        return saleInfoMapper.deleteById(id);
    }
}
