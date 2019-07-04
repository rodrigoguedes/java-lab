package br.com.guedesdesouza.dne.writer;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.stereotype.Component;

import br.com.guedesdesouza.external.Pais;

@Component
public class PaisWriter extends JpaItemWriter<Pais> {

}
