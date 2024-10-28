package com.epam.address.AddressApplication.service;

import com.epam.address.AddressApplication.entity.Address;
import com.epam.address.AddressApplication.repository.AddressRepo;
import com.epam.address.AddressApplication.resource.AddressResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressById(int employeeId){

        Address address = addressRepo.findAddressByEmplyeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
        return addressResponse;

    }

    public List<AddressResponse> getAllAddress() {
        List<Address> addressList = addressRepo.findAll();
        List<AddressResponse> addressResponseList = modelMapper.map(addressList, new TypeToken<List<AddressResponse>>() {}.getType());
        return addressResponseList;
    }
}
