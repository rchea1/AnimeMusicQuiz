package com.knotts.animemusicquiz.animemusicquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knotts.animemusicquiz.animemusicquiz.entity.Theme;
import com.knotts.animemusicquiz.animemusicquiz.service.ThemeService;

@Controller
@RequestMapping("/themes")
public class ThemeController {
	
	@Autowired 
	ThemeService themeService;

	@GetMapping("/")
	public String themeHome() {
		return "/theme/index";
	}
	
	@GetMapping("/{id}")
	public String getTheme(@PathVariable int id, Model model) {
		Theme theme = null;
		try {
			theme = themeService.get(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("theme", theme);
		return "/theme/theme-form";
	}
	
	@GetMapping("/list")
	public String showThemeList(Model model) {
		List<Theme> themes = themeService.findAllByOrderByTitleAsc();
		model.addAttribute("themes", themes);
		model.addAttribute("theme", new Theme());
		return "/theme/list";
	}
	
	@PostMapping("/save")
	public String saveTheme(@ModelAttribute("theme") Theme theme) {
		themeService.save(theme);
		return "redirect:/themes/list";
	}
	
	@GetMapping("/new")
	public String newTheme(Model model) {
		Theme theme = new Theme();
		model.addAttribute("theme", theme);
		return "/theme/theme-form";
	}
}
