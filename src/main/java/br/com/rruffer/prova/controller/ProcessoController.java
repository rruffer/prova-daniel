package br.com.rruffer.prova.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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

		Processo response = getDadosProcesso(processo);

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
		
		String idPub = processo.getPub().replace("/", "");

		String url = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=" + idPub + "&redirectedID=true";

		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			// request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd;
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
