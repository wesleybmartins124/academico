package br.sp.gov.etec.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.sp.gov.etec.academico.dto.AlunoEntity;
import br.sp.gov.etec.academico.repository.AlunoRepository;


@Controller()
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	
	@GetMapping("cadastrar")
	public ModelAndView cadastroAluno() {	
		
		ModelAndView view = new ModelAndView("CadastroAluno");
		
		view.addObject(new AlunoEntity());			
		
		return view;
	}
	
	@GetMapping("listar")
	public ModelAndView listarAlunos() {	
		
		ModelAndView view = new ModelAndView("ListaAlunos");
		
		List<AlunoEntity> listaAlunos = repository.findAll();		
		
		view.addObject("alunos", listaAlunos);		
		
		return view;
	}
	
	@PostMapping("salvar")
	public String salvarAluno(AlunoEntity aluno) {
		
		repository.save(aluno);
		
		return "redirect:/aluno/listar";
		
	}
	
	@GetMapping("editar/{id}")
	public String editarAluno(@PathVariable Long id, Model model) {		
		AlunoEntity alunoEntity = repository.findById(id).get();		
		model.addAttribute(alunoEntity);		
		return "CadastroAluno";
		
	}
	
	@GetMapping("excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {		
			repository.deleteById(id);			
		return "redirect:/aluno/listar";		
		
	}
}
