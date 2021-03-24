package com.bolsadeideas.springboot.web.app.controllers;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false) String texto, Model model) {
		model.addAttribute("resultado", "el texto es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "el texto es: " + saludo + "' y el numero es' " + numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer num = null;
		try {
			num = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			num = 0;
		}
		
		model.addAttribute("resultado", "el texto es: " + saludo + "' y el numero es' " + num + "'");
		return "params/ver";
	}

}
