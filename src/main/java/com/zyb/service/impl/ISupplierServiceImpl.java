package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.Supplier;
import com.zyb.mapper.SupplierMapper;
import com.zyb.service.ISupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ISupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        if (param!=null){
            wrapper.like("name", param);
        }
        Page<Supplier> page = new Page<>(pageNum, pageSize);
        return supplierMapper.selectPage(page, wrapper);
    }

    /**
     * 新增一条药品信息
     *
     * @param supplier
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 修改一条药品信息
     *
     * @param supplier
     */
    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }

    @Override
    public int deleteSupplier(Integer id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public List<Supplier> queryAllSupplier() {
        return supplierMapper.selectList(null);
    }
}
