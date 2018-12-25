package com.coderbd.onlinebanking.controller;


import com.coderbd.onlinebanking.entity.Role;
import com.coderbd.onlinebanking.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class RoleController implements Serializable {
    @Autowired
    private RoleRepo roleRepo;

    public RoleController() {
        getRoleList();
    }

    private List<Role> roleList;

    public String getHello() {
        return "Hello from PrimeFaces and Spring Boot!";
    }

    public List<Role> getRoleList() {
        this.roleList=new ArrayList<>();
        this.roleList=roleRepo.findAll();
        System.out.println("Size: "+roleList.size());
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
