package br.com.guedesdesouza.dne.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import br.com.guedesdesouza.dne.domain.PaisDne;
import br.com.guedesdesouza.external.Pais;

@Component
public class PaisProcessor implements ItemProcessor<PaisDne, Pais> {

	@Override
	public Pais process(PaisDne paisDne) throws Exception {
		
		System.out.println(paisDne);
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
