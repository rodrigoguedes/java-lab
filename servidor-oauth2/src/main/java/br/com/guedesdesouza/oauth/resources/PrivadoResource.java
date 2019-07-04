package br.com.guedesdesouza.oauth.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "privado")
@RestController 
@RequestMapping(value = "/privado")
public class PrivadoResource {

    @ApiOperation(value = "Exibe que usuario autenticado")
    //@ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHome() {
        return new ResponseEntity<>("usuário autenticado", HttpStatus.OK);
    }	
	
}
