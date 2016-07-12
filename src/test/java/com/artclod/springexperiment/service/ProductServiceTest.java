package com.artclod.springexperiment.service;

import com.artclod.springexperiment.config.Application;
import com.artclod.springexperiment.db.entity.ImitationProduct;
import com.artclod.springexperiment.db.entity.OriginalProduct;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    @Rollback
    public void saved_object_is_immediately_available() throws Exception {
        OriginalProduct originalProduct = productService.saveOriginalProduct(new OriginalProduct("The Original"));

        assertThat(productService.findAllOriginalProducts(), contains(originalProduct));
    }

    @Test
    @Transactional
    @Rollback
    public void referenced_objects_are_also_immediately_available() throws Exception {
        OriginalProduct originalProduct = productService.saveOriginalProduct(new OriginalProduct("The Original"));
        ImitationProduct imitationProduct = productService.saveImitationProduct(new ImitationProduct("A good quality knock off", originalProduct.getId()));

        ImitationProduct imitationProductFound = productService.findOneImitationProduct(imitationProduct.getId());
        assertEquals(originalProduct, imitationProductFound.getOriginalProduct());
    }

}