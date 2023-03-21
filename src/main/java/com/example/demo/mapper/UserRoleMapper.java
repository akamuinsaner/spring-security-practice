package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

    public Long save(Long userId, Long roleId);
}
