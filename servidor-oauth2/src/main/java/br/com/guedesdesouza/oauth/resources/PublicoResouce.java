package br.com.guedesdesouza.oauth.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "publico")
@RestController 
@RequestMapping(value = "/publico")
public class PublicoResouce {

    @ApiOperation(value = "Exibe que usuario não precisa estar logado")
    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHome() {
        return new ResponseEntity<>("Você não precisa estar logado", HttpStatus.OK);
    }
	
}
