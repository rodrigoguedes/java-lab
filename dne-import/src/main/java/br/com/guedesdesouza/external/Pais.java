package br.com.guedesdesouza.external;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CEP_PAIS")
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pais")
	private Long id;

}
