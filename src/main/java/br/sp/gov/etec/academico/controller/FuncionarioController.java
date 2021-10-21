package br.sp.gov.etec.academico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.gov.etec.academico.dto.Funcionario;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@GetMapping("/")
	public String abrirCadastroFuncionario(Model model){
		model.addAttribute(new Funcionario());
		return "CadastroFuncionario";		
	}
}
