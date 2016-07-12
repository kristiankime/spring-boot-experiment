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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @PersistenceContext
    private EntityManager entityManager;

    // TODO this test is failing because the @ManyToOne is not working in imitationProductFound.getOriginalProduct()
    @Test
    @Transactional
    @Rollback
    public void referenced_objects_are_also_immediately_available_with_transaction_and_flush_fails() throws Exception {
        OriginalProduct originalProduct = productService.saveOriginalProduct(new OriginalProduct("The Original"));
        ImitationProduct imitationProduct = productService.saveImitationProduct(new ImitationProduct("A good quality knock off", originalProduct.getId()));

        entityManager.flush();

        ImitationProduct imitationProductFound = productService.findOneImitationProduct(imitationProduct.getId());
        assertEquals(originalProduct, imitationProductFound.getOriginalProduct());
    }

    // TODO this test is succeeding but does not rollback
    @Test
    public void referenced_objects_are_also_immediately_available_with_no_transaction_succeeds() throws Exception {
        OriginalProduct originalProduct = productService.saveOriginalProduct(new OriginalProduct("The Original"));
        ImitationProduct imitationProduct = productService.saveImitationProduct(new ImitationProduct("A good quality knock off", originalProduct.getId()));

        ImitationProduct imitationProductFound = productService.findOneImitationProduct(imitationProduct.getId());
        assertEquals(originalProduct, imitationProductFound.getOriginalProduct());
    }

}