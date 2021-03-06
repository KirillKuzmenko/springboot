package jm.kuzmenko.springboot.dao;

import jm.kuzmenko.springboot.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findRoleByName(String role) {
        return entityManager.createQuery("from Role where role = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}
