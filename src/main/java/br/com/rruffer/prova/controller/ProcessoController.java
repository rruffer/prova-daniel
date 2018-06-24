package br.com.rruffer.prova.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		model.addObject(new Processo());
		return model;
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscarProcesso(@ModelAttribute("pub") String pub) {

		Processo response = getDadosProcesso(pub);

		ModelAndView model = new ModelAndView("cadastroProcesso");
		model.addObject("processo", response);
		return model;
	}
	
	@RequestMapping(value = "/irbusca")
	public ModelAndView pageBuscar() {
		ModelAndView model = new ModelAndView("cadastroProcesso");
		model.addObject("processo", new Processo());
		return model;
	}
	
	@RequestMapping(value = "/irpesquisar")
	public ModelAndView pagePesquisa() {
		ModelAndView model = new ModelAndView("pesquisarProcesso");
		model.addObject("processo", new Processo());
		return model;
	}
	
	@RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
	public ModelAndView pesquisaProcesso(@ModelAttribute("pub") String pub) {
		Processo response = processoService.buscarPub(pub);
		ModelAndView model = new ModelAndView("pesquisarProcesso");
		model.addObject("processo", response);
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView next(@ModelAttribute("processo") Processo processo) {
		ModelAndView model = new ModelAndView("cadastroProcesso");
		processoService.salvar(processo);
		return model;
	}

	private Processo getDadosProcesso(String pub) {
		
		Processo dadosProcesso = new Processo();
		
		String url = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=" + pub.replace("/", "") + "&redirectedID=true";

		HttpClient client = HttpClientBuilder.create().build();
		
		try {
			HttpGet request = new HttpGet(url);

			// add request header
			// request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

			if(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
				System.out.println("Response Code : " + response.getStatusLine().getStatusCode());				
			}
			
			BufferedReader rd;
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				if(line.contains("detailPCTtableWO")) {
					//dadosProcesso.setPub(line.replaceAll("\\<.*?\\>", "").trim());
					dadosProcesso.setPub(Jsoup.parse(line).text().replace("/", ""));
					System.out.println(dadosProcesso.getPub());
				}else if(line.contains("detailPCTtableAN")) {
					dadosProcesso.setPedidoInternacional(Jsoup.parse(line).text().replace("/", ""));
					System.out.println(dadosProcesso.getPedidoInternacional());
				}else if(line.contains("detailPCTtablePubDate")) {
//					String[] a = dataPublicacao.split("[.]");
					String[] a = Jsoup.parse(line).text().split(Pattern.quote("."));
					int dia = Integer.parseInt(a[0]);
					int mes = Integer.parseInt(a[1]);
					int ano = Integer.parseInt(a[2]);
					//LocalDate dateee = LocalDate.of(ano, mes, dia);
					Date date = new Date(ano, mes, dia);
					
					dadosProcesso.setDataPublicacao(date);
					System.out.println(dadosProcesso.getDataPublicacao());
				}else if(line.contains("PCTapplicants")) {
					dadosProcesso.setRequerente(Jsoup.parse(line).text());			
					System.out.println(dadosProcesso.getRequerente());
				}else if(line.contains("PCTtitle")) {
					dadosProcesso.setTitulo(Jsoup.parse(line).text());
					System.out.println(dadosProcesso.getTitulo());
				}
				
				result.append(line);
			}
			
		//System.out.println(result);
			
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

            //Fechando todas as conexoes necessarias    

			//client.getConnectionManager().shutdown();

        }


		return dadosProcesso;
	}

}
