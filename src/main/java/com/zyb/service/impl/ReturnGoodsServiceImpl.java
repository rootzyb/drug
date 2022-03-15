package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.ReturnGoods;
import com.zyb.mapper.ReturnGoodsMapper;
import com.zyb.service.ReturnGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper, ReturnGoods> implements ReturnGoodsService {

    @Resource
    private ReturnGoodsMapper returnGoodsMapper;

    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<ReturnGoods> selectReturnGoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoods> wrapper=new QueryWrapper();
        if (param!=null){
            wrapper.like("drug_name",param);
        }
        Page<ReturnGoods> page=new Page<>(pageNum,pageSize);
        return returnGoodsMapper.selectPage(page,wrapper);
    }

    /**
     * 新增一条收到退货信息
     *
     * @param returnGoods
     */
    @Override
    public int addReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.insert(returnGoods);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returnGoods
     */
    @Override
    public int editReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.updateById(returnGoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public ReturnGoods queryReturnGoodsById(Integer id) {
        return returnGoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int deleteReturnGoodsById(Integer id) {
        return returnGoodsMapper.deleteById(id);
    }
}
