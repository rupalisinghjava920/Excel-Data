package com.fixdcode.exporttoexceldemo.domain;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Customer> customers = customerRepository.findAll();
        ExcelExportUtils exportUtils = new ExcelExportUtils(customers);
        exportUtils.exportDataToExcel(response);
        return customers;
    }
}
