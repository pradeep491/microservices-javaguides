package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
