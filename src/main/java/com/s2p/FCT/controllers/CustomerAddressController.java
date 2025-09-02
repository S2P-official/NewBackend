package com.s2p.FCT.controllers;

// import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.s2p.FCT.entity.Customers;
import com.s2p.FCT.model.CustomerAddress;
import com.s2p.FCT.model.requestModel.AddressRequest;
import com.s2p.FCT.services.CustomerAddressService;

@RestController
@RequestMapping("/api/address")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

@PostMapping("/save")
public ResponseEntity<CustomerAddress> saveAddress(@RequestBody AddressRequest request) {
    CustomerAddress address = new CustomerAddress();
    address.setName(request.getName());
    address.setPhone(request.getPhone());
    address.setAlternatePhone(request.getAlternatePhone());
    address.setPincode(request.getPincode());
    address.setLocality(request.getLocality());
    address.setStreet(request.getStreet());
    address.setCity(request.getCity());
    address.setState(request.getState());
    address.setLandmark(request.getLandmark());
    address.setAddressType(request.getAddressType());

    return ResponseEntity.ok(customerAddressService.saveAddress(request.getCustomerId(), address));
}



}
