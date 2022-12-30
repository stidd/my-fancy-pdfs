package com.steventidd.myfancypdfinvoices.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    @GetMapping("/fun")
    public String index(){
        return "Fun!";
    }

}
