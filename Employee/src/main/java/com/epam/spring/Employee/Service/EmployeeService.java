package com.epam.spring.Employee.Service;

import com.epam.spring.Employee.FeignClient.AddressClient;

import com.epam.spring.Employee.Response.AddressResponse;
import com.epam.spring.Employee.Response.EmployeeResponse;
import com.epam.spring.Employee.entity.Employee;
import com.epam.spring.Employee.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
   private EmployeeRepo employeeRepo;
   @Autowired
   private AddressClient addressClient;

    public EmployeeResponse getEmployeeByID(int id){

        //Making an api call to get the address details.
   AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id);
        Employee employee = employeeRepo.findById(id)
                .orElse(new Employee());// Returns a new Employee object if not found
        EmployeeResponse employeeResponse = modelMapper.map(employee,EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;

    }

}
