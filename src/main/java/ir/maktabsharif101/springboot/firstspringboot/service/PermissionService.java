package ir.maktabsharif101.springboot.firstspringboot.service;

import ir.maktabsharif101.springboot.firstspringboot.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    long count();
}
