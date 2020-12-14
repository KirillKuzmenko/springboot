package jm.kuzmenko.springboot.dao;

import jm.kuzmenko.springboot.models.Role;

public interface RoleDao {
    Role findRoleByName(String name);
}
