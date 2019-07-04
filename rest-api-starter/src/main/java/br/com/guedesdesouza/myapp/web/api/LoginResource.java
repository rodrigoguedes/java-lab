package br.com.guedesdesouza.myapp.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rodrigo.souza on 31/08/2016.
 */
//@RestController
public class LoginResource {

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(){

        return null;

    }

}
