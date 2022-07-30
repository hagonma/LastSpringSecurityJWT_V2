package sv.com.tigo.apizendesk.security.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "ZENDESK_AUTHO_ID") 
public class User {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotNull
    @NaturalId
    @Column(unique = true)
    private String usuario; 
    @NotNull
    private String correo;
    @NotNull
    private String clave;
    @NotNull
    private String institucion;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="ZENDESK_ROLE_ID", joinColumns = @JoinColumn(name="user_id"),
     inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();
    public User() {
    }
    public User(@NotNull String usuario, @NotNull String correo, @NotNull String clave, @NotNull String institucion) {
        this.usuario = usuario;
        this.correo = correo;
        this.clave = clave;
        this.institucion = institucion;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getInstitucion() {
        return clave;
    }
    public void setInstitucion(String clave) {
        this.clave = clave;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    
}
