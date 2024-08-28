package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.assembler.CustomerModelAssembler;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.CustomerDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper.CustomerMapper;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Customer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/customers")
// public class CustomerController {

// private List<Customer> customers = new ArrayList<>();

// // CREATE: POST /customers - Add a new customer
// @PostMapping
// @ResponseStatus(HttpStatus.CREATED)
// public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO
// customerDTO) {
// Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
// customers.add(customer);
// return CustomerMapper.INSTANCE.toDTO(customer);
// }

// // READ: GET /customers - Get all customers
// @GetMapping
// public List<CustomerDTO> getAllCustomers() {
// return customers.stream()
// .map(CustomerMapper.INSTANCE::toDTO)
// .collect(Collectors.toList());
// }

// // READ: GET /customers/{id} - Get a customer by ID
// @GetMapping("/{id}")
// public CustomerDTO getCustomerById(@PathVariable Long id) {
// Optional<Customer> customer = customers.stream().filter(c ->
// c.getId().equals(id)).findFirst();
// if (customer.isPresent()) {
// return CustomerMapper.INSTANCE.toDTO(customer.get());
// } else {
// throw new CustomerNotFoundException("Customer not found with ID: " + id);
// }
// }

// // UPDATE: PUT /customers/{id} - Update a customer by ID
// @PutMapping("/{id}")
// public CustomerDTO updateCustomer(@PathVariable Long id, @Valid @RequestBody
// CustomerDTO customerDTO) {
// Optional<Customer> existingCustomer = customers.stream().filter(c ->
// c.getId().equals(id)).findFirst();
// if (existingCustomer.isPresent()) {
// Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
// customers.remove(existingCustomer.get());
// customers.add(customer);
// return CustomerMapper.INSTANCE.toDTO(customer);
// } else {
// throw new CustomerNotFoundException("Customer not found with ID: " + id);
// }
// }

// // DELETE: DELETE /customers/{id} - Delete a customer by ID
// @DeleteMapping("/{id}")
// @ResponseStatus(HttpStatus.NO_CONTENT)
// public void deleteCustomer(@PathVariable Long id) {
// Optional<Customer> existingCustomer = customers.stream().filter(c ->
// c.getId().equals(id)).findFirst();
// if (existingCustomer.isPresent()) {
// customers.remove(existingCustomer.get());
// } else {
// throw new CustomerNotFoundException("Customer not found with ID: " + id);
// }
// }
// }

// Updating controller to return hypermedia-driven
// responses----------------------------------------
// @RestController
// @RequestMapping("/customers")
// public class CustomerController {

//     private final CustomerModelAssembler assembler;

//     public CustomerController(CustomerModelAssembler assembler) {
//         this.assembler = assembler;
//     }

//     @GetMapping("/{id}")
//     public EntityModel<CustomerDTO> getCustomerById(@PathVariable Long id) {
//         Customer customer = findCustomerById(id);
//         return assembler.toModel(customer);
//     }

//     @GetMapping
//     public List<EntityModel<CustomerDTO>> getAllCustomers() {
//         List<Customer> customers = findAllCustomers();
//         return customers.stream()
//                 .map(assembler::toModel)
//                 .collect(Collectors.toList());
//     }

//     @PostMapping
//     @ResponseStatus(HttpStatus.CREATED)
//     public EntityModel<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
//         Customer customer = saveCustomer(customerDTO);
//         return assembler.toModel(customer);
//     }

// }

// Updating the controller to produce and consume JSON and XML--------------
@RestController
@RequestMapping("/customers")
public class CustomerController {

    // Example: Fetch customer by ID with content negotiation
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return findCustomerById(id); // Replace with actual logic to fetch the customer
    }

    // Example: Get all customers
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<CustomerDTO> getAllCustomers() {
        return findAllCustomers(); // Replace with actual logic to fetch customers
    }

    // Example: Create a new customer
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return saveCustomer(customerDTO); // Replace with actual logic to save the customer
    }

    // Additional methods (update, delete) can be added similarly...
}