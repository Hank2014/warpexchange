package com.itranswarp.exchange.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itranswarp.exchange.mail.MailService;
import com.itranswarp.exchange.support.AbstractApiController;

@RestController
@RequestMapping("/mail")
public class MailApiController extends AbstractApiController{

	@Autowired
	private MailService mailService;
	

    @GetMapping("/forgotPassword")
    public void timestamp(@RequestParam("mailAddress") String mailTo) {
    	mailService.sendSimpleMail(mailTo, "[WarpExchange] Password Reset Request", "click me to reset your password");
    }
}
