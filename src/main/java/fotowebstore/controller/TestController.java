package fotowebstore.controller;

import fotowebstore.dao.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    private final AccountDaoImpl accountDao;

    @Autowired
    public TestController(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping("/account")
    public String createAccount() {
        return "WEB-INF/AccountCreation";
    }

    @PostMapping("/account")
    public String createAccount(@RequestParam("accountNr") Long accountNr) {
        accountDao.create(accountNr);
        return "WEB-INF/AccountCreation";
    }
}
