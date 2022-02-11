package com.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.pojo.Products;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProduceMapper extends BaseMapper<Products> {
}
