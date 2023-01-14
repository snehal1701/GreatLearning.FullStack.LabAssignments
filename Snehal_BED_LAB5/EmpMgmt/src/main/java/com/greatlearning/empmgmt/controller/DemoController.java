package com.greatlearning.empmgmt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("serverDate", new Date());
		return "helloworld";
	}
	@GetMapping("/players")
	public String showPlayers(Model model) {
		model.addAttribute("serverDate", new Date());
		List<String> players = new ArrayList<>();
		players.add("Sachin Tendulkar");
		players.add("Sourav Ganguly");
		players.add("Rohit Sharma");
		players.add("Virat Kohli");
		players.add("Snehal Pereira");
		model.addAttribute("players",players);
		return "players";
	}
}
