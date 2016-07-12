package com.artclod.springexperiment.service;

import com.artclod.springexperiment.db.entity.ImitationProduct;
import com.artclod.springexperiment.db.entity.OriginalProduct;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public OriginalProduct saveOriginalProduct(OriginalProduct originalProduct);

    public ImitationProduct saveImitationProduct(ImitationProduct imitationProduct);

    public List<OriginalProduct> findAllOriginalProducts();

    public List<ImitationProduct> findAllImitationProducts();

    public ImitationProduct findOneImitationProduct(UUID id);
}
