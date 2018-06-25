package br.com.rruffer.prova.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rruffer.prova.model.Processo;
import br.com.rruffer.prova.repository.Processos;

@Service
public class ProcessoService {

	@Autowired
	private Processos processos;

	/**
	 * 
	 * @param titulo
	 */
	public void salvar(Processo processo) {
		Processo processo2 = buscarPub(processo.getPub());
		if(processo2 != null) {
			processo.setId(processo2.getId());
		}
		
		processo.setDataPublicacao(new Date(processo.getDataPublicacao().getTime()));
		processos.save(processo);

	}
	
	

	public Processo buscarPub(String pub) {
		Processo processo = processos.findByPubContaining(pub);
		return processo;
	}

}
