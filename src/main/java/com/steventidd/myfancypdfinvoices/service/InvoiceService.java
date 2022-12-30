package com.steventidd.myfancypdfinvoices.service;

import com.steventidd.myfancypdfinvoices.model.Invoice;
import com.steventidd.myfancypdfinvoices.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private UserService userService;

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();

    private final String cdnUrl;


    public InvoiceService (UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates....");
        // TODO actual deletion of PDFs
    }

    public List<Invoice> findAll() {
        return invoices;
    }
    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException();
        }


        // TODO real pdf creation and storing it on network server
        Invoice invoice=  new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }




}
