package com.zyb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyb.common.ResultMapUtil;
import com.zyb.entity.Supplier;
import com.zyb.service.ISupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Resource
    private ISupplierService supplierService;

    /**
     * 转向供应商页面
     */
    @RequestMapping
    public String supplier() {
        return "supplier";
    }

    /**
     * 分页查询供应商列表
     */
    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public HashMap<String, Object> supplierQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Supplier> iPage = supplierService.selectSupplierPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商新增页面
     */
    @RequestMapping("/supplierPage")
    public String supplierPage() {
        return "supplierPage";
    }

    /**
     * 添加一个供应商
     */
    @RequestMapping("/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier) {
        try {
            supplier.setCreateTime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商编辑页面
     */
    @RequestMapping("/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Supplier supplier=supplierService.querySupplierById(id);
        model.addAttribute("obj",supplier);
        return "supplierPage";
    }

    /**
     * 修改一个供应商
     */
    @RequestMapping("/supplierEdit")
    @ResponseBody
    public Object updateSupplier(Supplier supplier){
        try {
            int i=supplierService.updateSupplier(supplier);
            return ResultMapUtil.getHashMapUpdate(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个供应商
     */
    @RequestMapping("/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i=supplierService.deleteSupplier(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商
     */
    @RequestMapping(value = "/supplierList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = supplierService.queryAllSupplier();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}
