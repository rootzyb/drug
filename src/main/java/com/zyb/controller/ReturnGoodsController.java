package com.zyb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyb.common.ResultMapUtil;
import com.zyb.entity.ReturnGoods;
import com.zyb.service.ReturnGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/returnGoods")
public class ReturnGoodsController {

    @Resource
    private ReturnGoodsService returnGoodsService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returnGoods() {
        return "returnGoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returnGoodsQueryPage")
    @ResponseBody
    public Object returnGoodsQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<ReturnGoods> iPage = returnGoodsService.selectReturnGoodsPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/returnGoodsPage")
    public String returnGoodsPage() {
        return "/returnGoodsPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping(value = "/returnGoodsAdd")
    @ResponseBody
    public Object returnRoodsAdd(ReturnGoods returnGoods) {
        try {
            int i = returnGoodsService.addReturnGoods(returnGoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returnGoodsQueryById")
    public String returnGoodsQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        ReturnGoods returngoods = returnGoodsService.queryReturnGoodsById(id);
        model.addAttribute("obj", returngoods);
        return "/returnGoodsPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping(value = "/returnGoodsEdit")
    @ResponseBody
    public Object returnGoodsEdit(ReturnGoods returnGoods) {
        try {
            int i = returnGoodsService.editReturnGoods(returnGoods);
            return ResultMapUtil.getHashMapUpdate(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping(value = "/returnGoodsDelById")
    @ResponseBody
    public Object returnGoodsDelById(Integer id) {
        try {
            int i = returnGoodsService.deleteReturnGoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
