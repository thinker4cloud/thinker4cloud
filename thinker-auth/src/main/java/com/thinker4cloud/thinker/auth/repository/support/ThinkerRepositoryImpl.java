package com.thinker4cloud.thinker.auth.repository.support;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

public class ThinkerRepositoryImpl<E, PK extends Serializable>
        extends SimpleJpaRepository<E, PK> implements ThinkerRepository<E, PK> {

    private final EntityManager entityManager;

    public ThinkerRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


}
