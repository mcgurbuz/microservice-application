package com.haydikodlayalim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class HystrixController {
//Bu controllerla cevap vereceğiz. Frontend istek geldiğinde
//Ticket service ulaşamıyorsak buradan cevap döneceğiz.
    @GetMapping("/account")
    public String accountFallback(){
        return "Account Service is not available";
    }

    @GetMapping("/ticket")
    public String ticketFallback(){
        return "Ticket Service is not available";
    }
}
