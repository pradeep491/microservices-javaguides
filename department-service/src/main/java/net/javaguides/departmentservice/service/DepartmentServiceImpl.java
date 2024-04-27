package net.javaguides.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@Slf4j
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    @Override
    public Department saveDepartment(Department department) {
        return repo.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> department = repo.findById(departmentId);
        if (department.isPresent()) {
            return department.get();
        }
        return null;
    }
}
