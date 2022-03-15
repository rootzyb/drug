package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.Problem;
import com.zyb.mapper.ProblemMapper;
import com.zyb.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

    @Resource
    private ProblemMapper problemMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> wrapper = new QueryWrapper<>();
        if (param != null) {
            wrapper.like("drug_name", param);
        }
        Page<Problem> page = new Page<>(pageNum, pageSize);
        return problemMapper.selectPage(page, wrapper);
    }

    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);
    }

    @Override
    public int deleteProblemById(Integer id) {
        return problemMapper.deleteById(id);
    }

    @Override
    public List<Problem> queryProblemAll() {
        return problemMapper.selectList(null);
    }
}
