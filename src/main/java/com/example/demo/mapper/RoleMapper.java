package com.example.demo.mapper;

import com.example.demo.model.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    public Long save(Role role);
}
