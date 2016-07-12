package com.artclod.springexperiment.service;

import com.artclod.springexperiment.db.entity.ImitationProduct;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public ImitationProduct saveImitationProduct(ImitationProduct imitationProduct);

    public List<ImitationProduct> findAllImitationProducts();

}
