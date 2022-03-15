package com.zyb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.DrugInfo;

import java.util.List;

public interface DrugInfoService extends IService<DrugInfo> {

    /**
     * 分页查询药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品名称
     * @return
     */
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品信息
     * @param druginfo
     */
    public int addDrugInfo(DrugInfo druginfo);

    /**
     * 修改一条药品信息
     * @param druginfo
     */
    public int editDrugInfo(DrugInfo druginfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public DrugInfo queryDrugInfoById(Integer id);

    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    public int deleteDrugInfoById(Integer id);

    /**
     * 查询所有药品
     * @return
     */
    public List<DrugInfo> queryDrugInfoAll();
}
