package com.learning.demo.controller;


import com.learning.demo.entities.CabBook;
import com.learning.demo.model.CabBookModel;
import com.learning.demo.service.CabBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cab")
public class CabBookController {
    @Autowired
    CabBookService cabBookService;

    @PostMapping("/book")
    public String bookCab(@RequestBody CabBookModel cab) throws InterruptedException{
        cabBookService.bookCab(cab);
        return "saved";
    }
}
