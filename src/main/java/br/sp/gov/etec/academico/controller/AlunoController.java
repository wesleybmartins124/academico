package br.sp.gov.etec.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.sp.gov.etec.academico.dto.AlunoEntity;
import br.sp.gov.etec.academico.repository.AlunoRepository;


@Controller
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	
	@GetMapping("alunos")
	public ModelAndView listarAlunos() {	
		
		ModelAndView view = new ModelAndView("ListaAlunos");
		
		List<AlunoEntity> listaAlunos = repository.findAll();	
		
		view.addObject(new AlunoEntity());
		
		view.addObject("alunos", listaAlunos);		
		
		return view;
	}
	
	@PostMapping("salvar-aluno")
	public String salvarAluno(AlunoEntity aluno) {
		
		repository.save(aluno);
		
		return "redirect:/alunos";
		
	}
	
	@GetMapping("/aluno/editar/{id}")
	public String editarAluno(@PathVariable Long id, Model model) {		
		AlunoEntity alunoEntity = repository.findById(id).get();		
		model.addAttribute(alunoEntity);		
		return "aluno";	
		
	}
	
	@GetMapping("/aluno/excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {		
			repository.deleteById(id);			
		return "redirect:/alunos";		
		
	}
}
