package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.controller.CustomerController;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.CustomerDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Customer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler extends RepresentationModelAssemblerSupport<Customer, EntityModel<CustomerDTO>> {

    public CustomerModelAssembler() {
        super(CustomerController.class, EntityModel.class);
    }

    @Override
    public EntityModel<CustomerDTO> toModel(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        // Map customer entity to customerDTO here...

        return EntityModel.of(customerDTO,
                linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));
    }
}
