package com.tuempresa.rrhh.application.service.auth;
//revisar si esta carpeta de service deberia ir en el dominio
import com.tuempresa.rrhh.core.domain.Area;
import com.tuempresa.rrhh.core.domain.Department;
import com.tuempresa.rrhh.core.domain.Position;
import com.tuempresa.rrhh.core.domain.Workcenter;
import com.tuempresa.rrhh.core.service.AreaService;
import com.tuempresa.rrhh.core.service.DepartmentService;
import com.tuempresa.rrhh.core.service.PositionService;
import com.tuempresa.rrhh.core.service.WorkcenterService;
import com.tuempresa.rrhh.core.service.jwt.JwtService;
import com.tuempresa.rrhh.core.service.service_user.CompanyService;
import com.tuempresa.rrhh.core.service.service_user.PermissionRoleService;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.AreaMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.DepartmentMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.PositionMapper;
import com.tuempresa.rrhh.infrastructure.persintence.adapter.WorkcenterMapper;
import com.tuempresa.rrhh.infrastructure.persintence.entity.*;
import com.tuempresa.rrhh.infrastructure.persintence.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.tuempresa.rrhh.infrastructure.dto.auth.AuthResponse;
import com.tuempresa.rrhh.infrastructure.dto.auth.LoginRequest;
import com.tuempresa.rrhh.infrastructure.dto.auth.RegisterRequest;
import com.tuempresa.rrhh.core.domain.domain_user.Company;
import com.tuempresa.rrhh.core.domain.domain_user.PermissionRole;
import com.tuempresa.rrhh.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final AreaService areaService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final WorkcenterService workcenterService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    //private final UserService userService;
    private final PermissionRoleService permissionRoleService;
    private final CompanyService companyService;
    private final AreaMapper areaMapper;
    private final DepartmentMapper departmentMapper;
    private final PositionMapper positionMapper;
    private final WorkcenterMapper workcenterMapper;



    public AuthResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));
        System.out.println(request.getPassword());
        System.out.println(request.getEmail());
        //System.out.println(request.getId());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        try {

        } catch (BadCredentialsException e) {
            //userService.increaseFailedAttempts(user);
            throw new BadCredentialsException("Bad credentials");
        }

        //userService.resetFailedAttempts(user.getEmail());
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).message("Access Allowed").build();
    }
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        PermissionRole role = permissionRoleService.getPermissionRoleById(request.getRole());
        Company company = companyService.getCompanyById(request.getCompany());

        PermissionRoleE roleEntity = convertToEntity(role);
        CompanyE companyEntity = convertToEntity(company);


        String password = passwordEncoder.encode(request.getPassword());

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(password)
                .status(request.getStatus())
                .role(roleEntity)
                .company(companyEntity)
                .build();

        UserEntity savedUser = userRepository.save(user);
        Area area = areaService.getAreaById(request.getIdArea());
        Department department = departmentService.getDepartmentById(request.getIdDepartment());
        Position position = positionService.getPositionById(request.getIdPosition());
        Workcenter workcenter = workcenterService.getWorkcenterById(request.getIdWorkcenter());

        AreaEntity areaEntity = areaMapper.toEntity(area);
        DepartmentEntity departmentEntity = departmentMapper.toEntity(department);
        PositionEntity positionEntity = positionMapper.toEntity(position);
        WorkcenterEntity workcenterEntity = workcenterMapper.toEntity(workcenter);


        EmployeeE employee = EmployeeE.builder()
                .nit(request.getNit())
                .name(request.getName())
                .firstSurname(request.getFirstSurname())
                .secondSurname(request.getSecondSurname())
                .idUser(savedUser)
                .firstLevel(request.getFirstLevel())
                .secondLevel(request.getSecondLevel())
                .entryDate(request.getEntryDate())
                .turn(request.getTurn())
                .schedule(request.getSchedule())
                .idArea(areaEntity)
                .idDepartment(departmentEntity)
                .idPosition(positionEntity)
                .idWorkcenter(workcenterEntity)
                .restDay(request.getRestDay())
                .build();

        employeeRepository.save(employee);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .message("User registered successfully")
                .build();
    }
    private PermissionRoleE convertToEntity(PermissionRole role) {
        // Implementa la lógica para convertir
        PermissionRoleE entity = new PermissionRoleE();
        entity.setId(role.getId());
        entity.setNameRole(role.getNameRole());
        return entity;
    }
    private CompanyE convertToEntity(Company company) {
        // Implementa la lógica para convertir
        CompanyE entity = new CompanyE();
        entity.setId(company.getId());
        entity.setNameCompany(company.getNameCompany());
        return entity;
    }

}