package com.sqpl.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sqpl.app.model.Quote;

@Controller
public class WelcomeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value = "/welcome")
	public String welcome() {
	    return "welcome.html";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/random-quote")
	public void getRandomQuote(HttpServletResponse res) throws IOException {
			Quote q = restTemplate.getForObject("https://api.quotable.io/random", Quote.class);
			String quote = q.toString();
	        PrintWriter out = res.getWriter();
	        out.println(quote);
	        out.close();	
	}

}
