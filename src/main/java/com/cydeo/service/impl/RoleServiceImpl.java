package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<RoleDTO> listAllRoles() {

        // controller called me and requested all RoleDTOs so it can show in the drop-down in the ui
        // i need to make a call to db and get all the roles from table
        // go to repository and find a service which gives me the roles from db

       List<Role> roleList =  roleRepository.findAll();


        return roleList.stream().map(roleMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {

        Role role =  roleRepository.findById(id).get();

        return roleMapper.convertToDTO(role);


    }
}
