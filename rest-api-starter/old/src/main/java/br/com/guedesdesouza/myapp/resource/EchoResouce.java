package br.com.guedesdesouza.myapp.resource;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/echo")
public class EchoResouce {


	@RequestMapping(value = "/date-time")
	public LocalDateTime dateTime(){
		return LocalDateTime.now();
	}

}
