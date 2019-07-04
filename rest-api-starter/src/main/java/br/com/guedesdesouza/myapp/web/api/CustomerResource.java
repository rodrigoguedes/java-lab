package br.com.guedesdesouza.myapp.web.api;

import br.com.guedesdesouza.myapp.domain.Customer;
import br.com.guedesdesouza.myapp.domain.QCustomer;
import br.com.guedesdesouza.myapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by rodrigo.souza on 31/08/2016.
 */
@RestController
@RequestMapping("/api/customers")
//@CrossOrigin
public class CustomerResource {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> saver(@RequestBody Customer customer){

        return ResponseEntity.ok(customer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Customer> get(@PathVariable Long id){

        return ResponseEntity.ok(customerRepository.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by-name/{name}")
    public ResponseEntity<Customer> findByName(@PathVariable String name){

        Customer customer = customerRepository.findOne(QCustomer.customer.firstName.likeIgnoreCase(name));

        if (Objects.isNull(customer)){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(customer);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "{/id}")
//    public ResponseEntity<Page<Customer>> findAll(@RequestParam(value = "search", required = false) String search,
//                                                  Pageable pageable){
//
//        return ResponseEntity.ok(customerRepository.findAll(pageable));
//    }

}
