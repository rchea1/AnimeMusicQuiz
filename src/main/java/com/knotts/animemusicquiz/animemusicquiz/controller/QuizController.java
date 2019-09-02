package com.knotts.animemusicquiz.animemusicquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knotts.animemusicquiz.animemusicquiz.entity.Theme;
import com.knotts.animemusicquiz.animemusicquiz.service.ThemeService;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	private int connected = 0;
	
	@Autowired
	private ThemeService themeService;

	@GetMapping("/")
	public String quizHome() {
		return "/quiz/index";
	}
	
	@GetMapping("/start")
	public String quizStart(Model model) {
		List<Theme> themes = themeService.findAll();
		model.addAttribute("themes", themes);
		return "/quiz/start";
	}
	
	@MessageMapping("/quiz.register")
	@SendTo("/topic/public")
	public String register(@Payload String title, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", title);
		System.out.println(++connected);
		return title;
	}
	
	@MessageMapping("/quiz.send")
	@SendTo("/topic/public")
	public String sendMessage(@Payload String message) {
		return message;
	}
}
