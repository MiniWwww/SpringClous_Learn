package com.yili.productservice.controller;


import com.yili.common.result.Result;
import com.yili.model.entity.Products;
import com.yili.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;

    /**
     * 获取所有产品接口
     * @return 返回包含所有产品的 Result 对象
     */
    @GetMapping("/list")
    public Result<List<Products>> getAllProducts() {
        List<Products> productList = productService.list();
        return Result.ok(productList);
    }

    /**
     * 删除产品接口
     * @param productId 产品ID
     * @return 返回操作结果的 Result 对象
     */
    @DeleteMapping("/delete/{productId}")
    public Result<String> deleteProduct(@PathVariable Integer productId) {
        boolean success = productService.removeById(productId);
        if (success) {
            return Result.ok("产品删除成功");
        } else {
            return Result.fail("产品删除失败");
        }
    }

    /**
     * 修改产品接口
     * @param updatedProduct 更新后的产品信息
     * @return 返回操作结果的 Result 对象
     */
    @PutMapping("/update")
    public Result<String> updateProduct( @RequestBody Products updatedProduct) {
        boolean success = productService.updateById(updatedProduct);
        if (success) {
            return Result.ok("产品修改成功");
        } else {
            return Result.fail("产品修改失败");
        }
    }

    /**
     * 获取单个产品接口
     * @param productId 产品ID
     * @return 返回包含单个产品信息的 Result 对象
     */
    @GetMapping("/{productId}")
    public Result<Products> getProductById(@PathVariable Integer productId) {
        Products product = productService.getById(productId);
        if (product != null) {
            return Result.ok(product);
        } else {
            return Result.fail("未找到该产品");
        }
    }

    /**
     * 插入产品接口
     * @param newProduct 新产品信息
     * @return 返回操作结果的 Result 对象
     */
    @PostMapping("/add")
    public Result<Products> createProduct(@RequestBody Products newProduct) {
        boolean success = productService.save(newProduct);
        if (success) {
            Products byId = productService.getById(newProduct.getId());
            return Result.ok("产品插入成功",byId);
        } else {
            return Result.fail("产品插入失败");
        }
    }
}

