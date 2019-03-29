package com.thinker4cloud.thinker.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class SysAuthority extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String value;
}
