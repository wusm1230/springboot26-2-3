package com.example.ex06.service;

import com.example.ex06.entity.Member;
import com.example.ex06.entity.Product;
import com.example.ex06.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        // select * from member;
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        // select * from member where id = ?id;
        Optional<Product> optionalProduct =  productRepository.findById(id);
        return optionalProduct.get();
    }

    public Product save(Product product) {
        return  productRepository.save(product);
    }

    public Product update(Long id, Product product) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()){
            Product temp = productOptional.get();
            temp.setId(product.getId());
            temp.setDescription(product.getDescription());
            temp.setPrice(product.getPrice());

            return productRepository.save(temp);
        }
        else{
            throw new Exception("해당하는 id "+id+"가 없어서 수정할 내용이 없습니다.");
        }
    }

    public void delete(Long id) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()){
            productRepository.deleteById(id);
        }
        else{
            throw new Exception("해당하는 id "+id+"가 없어서 삭제할 내용이 없습니다.");
        }
    }
}
