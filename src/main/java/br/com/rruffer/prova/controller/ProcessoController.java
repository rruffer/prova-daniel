package br.com.rruffer.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.rruffer.prova.model.Processo;
import br.com.rruffer.prova.service.ProcessoService;

@Controller
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("cadastroProcesso");
		return model;
	}

	@RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
	public ModelAndView pesquisaProcesso(@ModelAttribute("processo") Processo processo) {
		
		ModelAndView model = new ModelAndView("cadastroProcesso");
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView next(@ModelAttribute("processo") Processo processo) {
		ModelAndView model = new ModelAndView("cadastroProcesso");
		processoService.salvar(processo);
		return model;
	}
	
	
	private Processo getDadosProcesso(Processo processo) {
		
		return null;
	}

}
