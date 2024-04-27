package net.javaguides.userservice.service;


import net.javaguides.userservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:9091")
public interface APIClient {
    @GetMapping(value = "/api/departments/{id}")
    DepartmentDTO getDepartmentById(@PathVariable("id") Long departmentId);
}
