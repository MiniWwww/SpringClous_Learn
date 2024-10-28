package com.yili.productservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yili.model.entity.Products;
import com.yili.productservice.mapper.ProductMapper;
import com.yili.productservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Products> implements ProductService {

}
