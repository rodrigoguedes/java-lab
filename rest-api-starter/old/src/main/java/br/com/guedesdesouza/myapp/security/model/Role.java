package br.com.guedesdesouza.myapp.security.model;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
@Entity
@Table(name = "sec_role")
public class Role {

    @Id
    @Column(name = "rol_id")
    private Long id;

    @Version
    @Column(name = "rol_version")
    Integer version;

    @NotEmpty
    @Column(name = "rol_name", length = 60)
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "sec_role_permissions", joinColumns = @JoinColumn(name = "role_fk", referencedColumnName = "rol_id"))
    @Column(name = "rol_permissions")
    private List<Permission> permissions = Lists.newLinkedList();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Role) {
            Role other = (Role) obj;
            return Objects.equal(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("name", this.name).toString();
    }

    public Role addPermission(Permission permission) {
        checkNotNull(permission);
        if (!permissions.contains(permission)) {
            permissions.add(permission);
        }
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
