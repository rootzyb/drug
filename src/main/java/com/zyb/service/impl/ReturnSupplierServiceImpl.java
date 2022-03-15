package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.ReturnSupplier;
import com.zyb.mapper.ReturnSupplierMapper;
import com.zyb.service.ReturnSupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReturnSupplierServiceImpl extends ServiceImpl<ReturnSupplierMapper, ReturnSupplier> implements ReturnSupplierService {

    @Resource
    private ReturnSupplierMapper returnSupplierMapper;


    /**
     * 分页查询退货给供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-退货给供应商名称
     * @return
     */
    @Override
    public IPage<ReturnSupplier> selectReturnSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnSupplier> wrapper = new QueryWrapper<>();
        if (param != null) {
            wrapper.like("drug_name", param);
        }
        Page<ReturnSupplier> page = new Page<>(pageNum, pageSize);
        return returnSupplierMapper.selectPage(page, wrapper);
    }

    /**
     * 新增一条退货给供应商信息
     *
     * @param returnSupplier
     */
    @Override
    public int addReturnSupplier(ReturnSupplier returnSupplier) {
        return returnSupplierMapper.insert(returnSupplier);
    }

    /**
     * 修改一条退货给供应商信息
     *
     * @param returnSupplier
     */
    @Override
    public int editReturnSupplier(ReturnSupplier returnSupplier) {
        return returnSupplierMapper.updateById(returnSupplier);
    }

    /**
     * 根据主键id查询一个退货给供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public ReturnSupplier queryReturnSupplierById(Integer id) {
        return returnSupplierMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个退货给供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteReturnSupplierById(Integer id) {
        return returnSupplierMapper.deleteById(id);
    }
}
