package com.zyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.ReturnSupplier;

public interface ReturnSupplierService extends IService<ReturnSupplier> {

    /**
     * 分页查询退货给供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-退货给供应商名称
     * @return
     */
    public IPage<ReturnSupplier> selectReturnSupplierPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条退货给供应商信息
     *
     * @param returnSupplier
     */
    public int addReturnSupplier(ReturnSupplier returnSupplier);

    /**
     * 修改一条退货给供应商信息
     *
     * @param returnSupplier
     */
    public int editReturnSupplier(ReturnSupplier returnSupplier);

    /**
     * 根据主键id查询一个退货给供应商对象
     *
     * @param id
     * @return
     */
    public ReturnSupplier queryReturnSupplierById(Integer id);

    /**
     * 根据主键id删除一个退货给供应商对象
     *
     * @param id
     * @return
     */
    public int deleteReturnSupplierById(Integer id);
}
