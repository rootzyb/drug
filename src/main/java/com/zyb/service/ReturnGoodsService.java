package com.zyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.ReturnGoods;

public interface ReturnGoodsService extends IService<ReturnGoods> {

    /**
     * 分页查询收到退货数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-收到退货名称
     * @return
     */
    public IPage<ReturnGoods> selectReturnGoodsPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条收到退货信息
     * @param returnGoods
     */
    public int addReturnGoods(ReturnGoods returnGoods);

    /**
     * 修改一条收到退货信息
     * @param returnGoods
     */
    public int editReturnGoods(ReturnGoods returnGoods);

    /**
     * 根据主键id查询一个收到退货对象
     * @param id
     * @return
     */
    public ReturnGoods queryReturnGoodsById(Integer id);

    /**
     * 根据主键id删除一个收到退货对象
     * @param id
     * @return
     */
    public int deleteReturnGoodsById(Integer id);
}
