package com.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.pojo.Products;
import com.product.mapper.ProduceMapper;
import com.product.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl extends ServiceImpl<ProduceMapper, Products> implements ProductService {


    @Override
    public Products queryById(int id) {
        return this.getById(id);
    }
}
