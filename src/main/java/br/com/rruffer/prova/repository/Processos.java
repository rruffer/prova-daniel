/**
 * 
 */
package br.com.rruffer.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rruffer.prova.model.Processo;

/**
 * @author rruffer
 *
 */
public interface Processos extends JpaRepository<Processo, Long>{
	
	Processo findByPubContaining(String pub);

}
