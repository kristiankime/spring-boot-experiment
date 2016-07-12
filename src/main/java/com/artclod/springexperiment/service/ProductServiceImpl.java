package com.artclod.springexperiment.service;

import com.artclod.springexperiment.db.entity.ImitationProduct;
import com.artclod.springexperiment.db.entity.OriginalProduct;
import com.artclod.springexperiment.db.repository.ImitationProductRepository;
import com.artclod.springexperiment.db.repository.OriginalProductRepository;
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

    @Autowired
    private OriginalProductRepository originalProductRepository;

    @Override
    public OriginalProduct saveOriginalProduct(OriginalProduct originalProduct) {
        return originalProductRepository.save(originalProduct);
    }

    @Override
    public ImitationProduct saveImitationProduct(ImitationProduct imitationProduct) {
        return imitationProductRepository.save(imitationProduct);
    }

    @Override
    public List<OriginalProduct> findAllOriginalProducts() {
        return originalProductRepository.findAll();
    }

    @Override
    public List<ImitationProduct> findAllImitationProducts() {
        return imitationProductRepository.findAll();
    }

    @Override
    public ImitationProduct findOneImitationProduct(UUID id) {
        return imitationProductRepository.findOne(id);
    }

}
