package pl.karpiu.climatecaremanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.karpiu.climatecaremanager.domain.model.Customer;
import pl.karpiu.climatecaremanager.service.CustomerService;

import java.util.UUID;

@Validated
@Controller
@RequestMapping(path = "api/v1/customers")
@RequiredArgsConstructor
public class CustomerViewController {

    private final CustomerService customerService;

    @GetMapping("/all_customers")
    public String getCustomers(Model model){
        model.addAttribute("customers", customerService.getCustomers());
        return "customer_all";
    }

    @GetMapping("/new_customer")
    public String createNewCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer_add";
    }

    @PostMapping("/customers")
    public String saveStudent(@ModelAttribute("customer") Customer customer) {
        String empty = "";



        try {
            customerService.saveCustomer(customer);
        } catch (Exception e) {
        return "customer_add_exist";
    }
        return "redirect:/customers/all_customers";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable UUID id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer_edit";
    }

    @PostMapping("/customer/{id}")
    public String updateCustomer(@PathVariable UUID id, @ModelAttribute("customer") Customer customer, Model model){
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setEmail(customer.getEmail());

        customerService.updateCustomer(existingCustomer);

        return "redirect:/customers/all_customers";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
        return "redirect:/customers/all_customers";
    }
}
