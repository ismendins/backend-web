package com.example.unifor.service;

import com.example.unifor.entity.UserAddress;
import com.example.unifor.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<UserAddress> findAllAddress(){
        return addressRepository.findAll();
    }

    public Optional<UserAddress> findAddressById(Long id){
        return addressRepository.findById(id);
    }

    public UserAddress saveAddress(UserAddress userAddress){
        return addressRepository.save(userAddress);
    }

    public UserAddress updateAddress(Long id, UserAddress updateUserAddress){
        return addressRepository.findById(id)
                .map(address -> {
                    address.setStreet(updateUserAddress.getStreet());
                    address.setCity(updateUserAddress.getCity());
                    address.setState(updateUserAddress.getState());
                    address.setZipCode(updateUserAddress.getZipCode());
                    address.setUser(updateUserAddress.getUser());
                    return addressRepository.save(address);
                }).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }

}
