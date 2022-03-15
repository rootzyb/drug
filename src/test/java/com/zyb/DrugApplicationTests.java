package com.zyb;

import com.zyb.entity.Supplier;
import com.zyb.entity.User;
import com.zyb.mapper.SupplierMapper;
import com.zyb.service.ISupplierService;
import com.zyb.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DrugApplicationTests {

    @Resource
    private SupplierMapper service;

    @Test
    void contextLoads() {
        List<Supplier> list=service.selectList(null);
        for (Supplier supplier:list){
            System.out.println(supplier);
        }
    }

}
