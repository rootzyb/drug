package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.OwInfo;
import com.zyb.mapper.OwInfoMapper;
import com.zyb.service.OwInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class OwInfoServiceImpl extends ServiceImpl<OwInfoMapper, OwInfo> implements OwInfoService {

    @Resource
    private OwInfoMapper owInfoMapper;

    @Override
    public IPage<OwInfo> selectOwInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OwInfo> wrapper = new QueryWrapper<>();
        if (param != null) {
            wrapper.like("drug_name", param);
        }
        Page<OwInfo> page = new Page<>(pageNum, pageSize);
        return owInfoMapper.selectPage(page, wrapper);
    }

    @Override
    public int addOwInfo(OwInfo owinfo) {
        return owInfoMapper.insert(owinfo);
    }

    @Override
    public int editOwInfo(OwInfo owinfo) {
        return owInfoMapper.updateById(owinfo);
    }

    @Override
    public OwInfo queryOwInfoById(Integer id) {
        return owInfoMapper.selectById(id);
    }

    @Override
    public int deleteOwInfoById(Integer id) {
        return owInfoMapper.deleteById(id);
    }
}
