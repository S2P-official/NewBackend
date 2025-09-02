package com.s2p.FCT.services.Impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.model.CustomerAddress;
import com.s2p.FCT.model.CustomerModel;
import com.s2p.FCT.repositories.CustomersRepository;
import com.s2p.FCT.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomerServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public Customers createCustomer(Customers customers) {
        List<CustomerAddress> addresses = customers.getAddress();
        if (addresses != null) {
            for (CustomerAddress addr : addresses) {
                addr.setCustomers(customers);
            }
        }
        customers.setId(UUID.randomUUID());
        return customersRepository.save(customers);
    }

@Transactional(readOnly = true) // <- important
    @Override
    public CustomerModel logIn(String email, String password) {
        Customers customer = customersRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            // now addresses will be initialized inside the session
            return toCustomerModel(customer);
        }
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public CustomerModel getCustomerById(UUID id) {
        Customers customer = customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return toCustomerModel(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerModel> getAllCustomers() {
        return customersRepository.findAll()
                .stream()
                .map(this::toCustomerModel)
                .collect(Collectors.toList());
    }

private CustomerModel toCustomerModel(Customers customer) {
    CustomerModel model = new CustomerModel();
    model.setId(customer.getId());
    model.setFirstName(customer.getFirstName());
    model.setLastName(customer.getLastName());
    model.setEmail(customer.getEmail());
    model.setRole(customer.getRole());
    model.setPhoneNumber(customer.getPhoneNumber());

    if (customer.getAddress() != null) {
        model.setAddresses(
            customer.getAddress().stream()
                .collect(Collectors.toList()) // keep objects as-is
        );
    }

    return model;
}


    @Override
    public Customers updateCustomer(UUID id, Customers updated) {
        Customers existing = customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setAddress(updated.getAddress());
        return customersRepository.save(existing);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customersRepository.deleteById(id);
    }

 



    @Override
    public Customers updateCustomerAddress(UUID id, Customers customerWithNewAddress) {
        Customers existing = customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<CustomerAddress> newAddresses = customerWithNewAddress.getAddress();
        if (newAddresses != null) {
            for (CustomerAddress addr : newAddresses) {
                addr.setCustomers(existing);
            }
            existing.setAddress(newAddresses);
        }

        return customersRepository.save(existing);
    }
}
