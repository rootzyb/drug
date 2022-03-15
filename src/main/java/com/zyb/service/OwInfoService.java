package com.zyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.OwInfo;

public interface OwInfoService extends IService<OwInfo> {

    /**
     * 分页查询药品出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品出入库名称
     * @return
     */
    public IPage<OwInfo> selectOwInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品出入库信息
     * @param owinfo
     */
    public int addOwInfo(OwInfo owinfo);

    /**
     * 修改一条药品出入库信息
     * @param owinfo
     */
    public int editOwInfo(OwInfo owinfo);

    /**
     * 根据主键id查询一个药品出入库对象
     * @param id
     * @return
     */
    public OwInfo queryOwInfoById(Integer id);

    /**
     * 根据主键id删除一个药品出入库对象
     * @param id
     * @return
     */
    public int deleteOwInfoById(Integer id);
}
