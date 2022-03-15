package com.zyb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyb.common.ResultMapUtil;
import com.zyb.entity.DrugInfo;
import com.zyb.service.DrugInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/drugInfo")
public class DrugInfoController {

    @Resource
    private DrugInfoService drugInfoService;

    /**
     * 转向药品页面
     */
    @RequestMapping
    public String drugInfo() {
        return "drugInfo";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/drugInfoQueryPage")
    @ResponseBody
    public Object drugInfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<DrugInfo> iPage = drugInfoService.selectDrugInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/drugInfoPage")
    public String drugInfoPage() {
        return "/drugInfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/drugInfoAdd")
    @ResponseBody
    public Object drugInfoAdd(DrugInfo druginfo) {
        try {
            int i = drugInfoService.addDrugInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/drugInfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        DrugInfo druginfo = drugInfoService.queryDrugInfoById(id);
        model.addAttribute("obj", druginfo);
        return "drugInfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/drugInfoEdit")
    @ResponseBody
    public Object drugInfoEdit(DrugInfo druginfo) {
        try {
            int i = drugInfoService.editDrugInfo(druginfo);
            return ResultMapUtil.getHashMapUpdate(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/drugInfoDelById")
    @ResponseBody
    public Object drugInfoDelById(Integer id) {
        try {
            int i = drugInfoService.deleteDrugInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/drugInfoList")
    @ResponseBody
    public Object drugInfoList() {
        List<DrugInfo> drugInfoList = drugInfoService.queryDrugInfoAll();
        return ResultMapUtil.getHashMapList(drugInfoList);
    }

    /**
     * 转向药品保质期检查页面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "warranty";
    }
}
