//package kafka;
//
//
//import java.util.List;
//
//@Service
//public class EmployeeServiceImpl
//        implements EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(
//            EmployeeRepository employeeRepository) {
//
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public EmployeeResponse createEmployee(
//            EmployeeRequest request) {
//
//        Employee employee = new Employee();
//
//        employee.setName(request.getName());
//        employee.setEmail(request.getEmail());
//        employee.setDepartment(request.getDepartment());
//        employee.setSalary(request.getSalary());
//
//        Employee savedEmployee =
//                employeeRepository.save(employee);
//
//        return mapToResponse(savedEmployee);
//    }
//
//    @Override
//    public EmployeeResponse getEmployeeById(Long id) {
//
//        Employee employee = employeeRepository.findById(id).orElseThrow(()->{
//            new EmployeeNotFoundException("Employee Not found");
//        });
//
//        return mapToResponse(employee);
//
//    }
//
//    @Override
//    public List<EmployeeResponse> getAllEmployees() {
//
//        return employeeRepository.findAll()
//                .stream()
//                .map(this::mapToResponse)
//                .toList();
//    }
//
//    @Override
//    public EmployeeResponse updateEmployee(
//            Long id,
//            EmployeeRequest request) {
//
//        Employee employee =
//                employeeRepository.findById(id)
//                        .orElseThrow(() ->
//                                new EmployeeNotFoundException(
//                                        "Employee not found with id: " + id
//                                ));
//
//        employee.setName(request.getName());
//        employee.setEmail(request.getEmail());
//        employee.setDepartment(request.getDepartment());
//        employee.setSalary(request.getSalary());
//
//        Employee updatedEmployee =
//                employeeRepository.save(employee);
//
//        return mapToResponse(updatedEmployee);
//    }
//
//    @Override
//    public void deleteEmployee(Long id) {
//
//        Employee employee =
//                employeeRepository.findById(id)
//                        .orElseThrow(() ->
//                                new EmployeeNotFoundException(
//                                        "Employee not found with id: " + id
//                                ));
//
//        employeeRepository.delete(employee);
//    }
//
//    private EmployeeResponse mapToResponse(
//            Employee employee) {
//
//        return new EmployeeResponse(
//                employee.getId(),
//                employee.getName(),
//                employee.getEmail(),
//                employee.getDepartment(),
//                employee.getSalary()
//        );
//    }
//}