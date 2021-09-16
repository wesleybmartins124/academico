package br.sp.gov.etec.academico.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;

import br.sp.gov.etec.academico.dto.Login;

@Controller
public class LoginController {

	@GetMapping("/")
	public String login( Model model) {
		model.addAttribute(new Login());
		return "login";
	}

	@GetMapping("/logar")
	public String logar(@Valid Login login, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(login);
			return "login";
		} else if (login.getUsuario().equals("admin") && login.getSenha().equals("123")) {
			return "redirect:/home";
		}else {
			model.addAttribute(login);
			return "login";			
		}		
	}
}
