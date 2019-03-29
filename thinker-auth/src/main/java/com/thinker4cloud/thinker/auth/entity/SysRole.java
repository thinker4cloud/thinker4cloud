package com.thinker4cloud.thinker.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends AbstractAuditingEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity = SysAuthority.class, fetch = FetchType.EAGER)
    private Set<SysAuthority> authorities = new HashSet<>();
}
