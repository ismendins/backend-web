package com.example.unifor.controller;

import com.example.unifor.entity.UserAddress;
import com.example.unifor.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<UserAddress> getAllAddress(){
        return addressService.findAllAddress();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress> getAddressById(@PathVariable Long id){
        return addressService.findAddressById(id)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public UserAddress createAddress(@RequestBody UserAddress userAddress){
        return addressService.saveAddress(userAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAddress> updateAddress(@PathVariable Long id, @RequestBody UserAddress updateUserAddress){
        try {
            return new ResponseEntity<>(addressService.updateAddress(id, updateUserAddress), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
