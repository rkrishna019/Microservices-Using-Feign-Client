package com.epam.spring.Employee.FeignClient;

import com.epam.spring.Employee.Response.AddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "address-service", url = "http://localhost:8082/address-app/api")
public interface AddressClient {

    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);

    @GetMapping("/address")
    ResponseEntity<List<AddressResponse>> getAddress();
}
