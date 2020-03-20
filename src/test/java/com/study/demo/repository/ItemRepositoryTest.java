package com.study.demo.repository;

import com.study.demo.DemoApplicationTests;
import com.study.demo.model.entity.Item;
import com.study.demo.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends DemoApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus(ItemStatus.REGISTERED);
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년 형 노트북");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        //item.setUnregisteredAt();
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull((newItem));



    }

    @Test
    public void read(){
        /*
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());
        item.ifPresent(i ->{
            System.out.println(i);
        });

         */
    }
}
