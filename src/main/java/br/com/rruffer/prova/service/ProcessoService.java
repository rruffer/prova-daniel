package br.com.rruffer.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		try {
			processos.save(processo);			
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido!");
		}
	}

	public Processo buscarPub(String pub) {
		Processo processo = processos.findByPubContaining(pub);
		return processo;
	}

}
