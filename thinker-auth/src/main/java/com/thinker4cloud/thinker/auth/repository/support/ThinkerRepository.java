package com.thinker4cloud.thinker.auth.repository.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */
@NoRepositoryBean
public interface ThinkerRepository<E, PK extends Serializable> extends JpaRepository<E, PK> {

}
