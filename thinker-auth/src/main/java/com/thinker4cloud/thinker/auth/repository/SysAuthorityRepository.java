package com.thinker4cloud.thinker.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thinker4cloud.thinker.auth.entity.SysAuthority;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

public interface SysAuthorityRepository extends JpaRepository<SysAuthority, Long> {
}
