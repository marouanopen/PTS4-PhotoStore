package fotowebstore.controller;

import fotowebstore.dao.AccountDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/account")
    public String createAccount() {
        return "AccountCreation";
    }

    @PostMapping("/account")
    public String createAccount(@RequestParam("accountNr") Long accountNr) {
        AccountDaoImpl dao = new AccountDaoImpl();
        dao.create(accountNr);
        return "AccountCreation";
    }
}
