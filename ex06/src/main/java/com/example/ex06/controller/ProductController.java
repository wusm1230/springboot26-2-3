package com.example.ex06.controller;

import com.example.ex06.entity.Member;
import com.example.ex06.entity.Product;
import com.example.ex06.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "상품 전체 조회", description = "등록된 모든 상품 목록을 반환합니다.")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "상품 전체 조회", description = "등록된 모든 상품 목록을 반환합니다.")
    public Product findById(@PathVariable Long id){
        System.out.println("id = "+id);
        return productService.findById(id);
    }

    @PostMapping
    @Operation(summary = "상품 등록", description = "새로운 상품을 등록합니다.")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "상품 수정", description = "id에 해당하는 상품을 수정합니다.")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product) throws Exception {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "상품 삭제", description = "id에 해당하는 상품을 삭제합니다.")
    public void delete(@PathVariable Long id) throws Exception {
        productService.delete(id);
    }
}
