package com.product.controller;

import com.common.pojo.Products;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProducrController {


    @Value("${server.port}")
    private String port;

    private String getPort (){
        return this.port;
    }

    @Autowired
    ProductService productService;

    @GetMapping("query")
    public Products productsById(@RequestParam int id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productService.queryById(id);
    }

    @GetMapping("port")
    public String port() {
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.fillInStackTrace();
//        }
        return getPort();
    }
}
