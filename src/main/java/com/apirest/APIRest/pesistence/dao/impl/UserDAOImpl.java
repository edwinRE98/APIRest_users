package com.apirest.APIRest.pesistence.dao.impl;

import com.apirest.APIRest.pesistence.dao.IUserDAO;
import com.apirest.APIRest.pesistence.entities.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        //createNativeQuery crea una instancia de Query para ejecutar una declaración SQL nativa.
        var query = this.entityManager.createNativeQuery("SELECT * FROM tb_users",UserEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Integer id) {
        return Optional.ofNullable(this.entityManager.find(UserEntity.class,id));
    }

    @Override
    @Transactional
    public void save(UserEntity userEntity) {
        this.entityManager.persist(userEntity);
        //El método flush suele forzar los cambios para guardar el nuevo recurso de la entidad.
        this.entityManager.flush();
    }

    @Override
    @Transactional
    public void update(UserEntity userEntity) {
        this.entityManager.merge(userEntity);
    }

    @Transactional
    @Override
    public void delete(UserEntity userEntity) {
        this.entityManager.remove(userEntity);
    }

}