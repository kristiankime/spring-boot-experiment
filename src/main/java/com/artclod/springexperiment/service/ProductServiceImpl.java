package com.artclod.springexperiment.service;

import com.artclod.springexperiment.db.entity.ImitationProduct;
import com.artclod.springexperiment.db.repository.ImitationProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ImitationProductRepository imitationProductRepository;


    @Override
    public ImitationProduct saveImitationProduct(ImitationProduct imitationProduct) {
        return imitationProductRepository.save(imitationProduct);
    }

    @Override
    public List<ImitationProduct> findAllImitationProducts() {
        return imitationProductRepository.findAll();
    }
}
