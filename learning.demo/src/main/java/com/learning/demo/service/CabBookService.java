package com.learning.demo.service;

import com.learning.demo.entities.CabBook;
import com.learning.demo.model.CabBookModel;
import com.learning.demo.repository.CabBookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Slf4j
public class CabBookService {

    @Autowired
    private CabBookRepo cabRepo;

    @Async("threadPoolTaskExecutor")
    public String bookCab(CabBookModel cabModel) throws InterruptedException {
        CabBook cab = new CabBook(null, cabModel.getCabName());
        log.info("Started thread by" + cabModel.getCabName());
        Thread.sleep(10000);
        CompletableFuture<CabBook> cabFuture = CompletableFuture.completedFuture(cabRepo.save(cab));
        return "Saved";
    }
}
