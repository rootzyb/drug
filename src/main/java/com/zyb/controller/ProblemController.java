package com.zyb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyb.common.ResultMapUtil;
import com.zyb.entity.Problem;
import com.zyb.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Resource
    private ProblemService problemService;

    /**
     * 转向问题药品页面
     */
    @RequestMapping
    public String problemPage() {
        return "problem";
    }

    /**
     * 分页查询问题药品列表
     */
    @RequestMapping("/problemQueryPage")
    @ResponseBody
    public Object problemQueryPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String param) {
        try {
            IPage<Problem> iPage=problemService.selectProblemPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品新增页面
     */
    @RequestMapping("/problemPage")
    public String addProblem(){
        return "problemPage";
    }

    /**
     * 添加一个问题药品
     */
    @RequestMapping("/problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem){
        try {
            problem.setCreateTime(new Date());
            int i=problemService.addProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品编辑页面
     */
    @RequestMapping(value = "/problemQueryById")
    public String editProblemPage(@RequestParam(name = "id",required = true) Integer id, Model model){
        Problem problem=problemService.queryProblemById(id);
        model.addAttribute("obj",problem);
        return "problemPage";
    }

    /**
     * 修改一个问题药品
     */
    @RequestMapping(value = "/problemEdit")
    @ResponseBody
    public Object editProblem(Problem problem){
        try {
            int i=problemService.editProblem(problem);
            return ResultMapUtil.getHashMapUpdate(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个问题药品
     */
    @RequestMapping(value = "/problemDelById")
    @ResponseBody
    public Object deleteProblem(Integer id){
        try {
            int i=problemService.deleteProblemById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
