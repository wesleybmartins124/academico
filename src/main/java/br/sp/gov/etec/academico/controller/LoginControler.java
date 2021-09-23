package br.sp.gov.etec.academico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.sp.gov.etec.academico.dto.Login;
import br.sp.gov.etec.academico.entity.LoginEntity;
import br.sp.gov.etec.academico.repository.LoginRepository;

@Controller
public class LoginControler {
	
	@Autowired
	LoginRepository repository;
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute(new Login());
		return "login";
	}

	@PostMapping("/logar")
	public String logar(@Valid Login login, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute(login);
			return "login";
		}
		
		LoginEntity loginEntity = repository.findByLogin(login.getUsuario());
	
		if(loginEntity != null && (login.getUsuario().equals(loginEntity.getLogin()) && login.getSenha().equals(loginEntity.getSenha()))) {
			return "redirect:/home";
		}
		return "redirect:/";		
	}
}
