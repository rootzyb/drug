package com.zyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.BillInfo;

/**
 * 账单信息的service接口
 */
public interface BillInfoService extends IService<BillInfo> {

    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息信息
     * @param billInfo
     */
    public int addBillInfo(BillInfo billInfo);

    /**
     * 修改一条账单信息信息
     * @param billInfo
     */
    public int editBillInfo(BillInfo billInfo);

    /**
     * 根据主键id查询一个账单信息对象
     * @param id
     * @return
     */
    public BillInfo queryBillInfoById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int deleteBillInfoById(Integer id);
}
