package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.DrugInfo;
import com.zyb.mapper.DrugInfoMapper;
import com.zyb.service.DrugInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {

    @Resource
    private DrugInfoMapper drugInfoMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInfo> wrapper = new QueryWrapper<>();
        if (param!=null){
            wrapper.like("name", param);
        }
        Page<DrugInfo> page = new Page<>(pageNum, pageSize);
        return drugInfoMapper.selectPage(page,wrapper);
    }

    @Override
    public int addDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.insert(druginfo);
    }

    @Override
    public int editDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.updateById(druginfo);
    }

    @Override
    public DrugInfo queryDrugInfoById(Integer id) {
        return drugInfoMapper.selectById(id);
    }

    @Override
    public int deleteDrugInfoById(Integer id) {
        return drugInfoMapper.deleteById(id);
    }

    @Override
    public List<DrugInfo> queryDrugInfoAll() {
        return drugInfoMapper.selectList(null);
    }
}
