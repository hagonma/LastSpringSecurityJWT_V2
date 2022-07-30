package sv.com.tigo.apizendesk.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails {
    private String Usuario;
    private String Correo;
    private String Clave;
    private Collection<? extends GrantedAuthority> authorities;


    public MainUser(String Usuario, String Correo, String Clave,
            Collection<? extends GrantedAuthority> authorities) {
        this.Usuario = Usuario;
        this.Correo = Correo;
        this.Clave = Clave;
        this.authorities = authorities;
    }

    public static MainUser build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new MainUser(user.getUsuario(), user.getCorreo(), user.getClave(), user.getInstitucion(), authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return Clave;
    }

    @Override
    public String getUsername() {
        return Usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getCorreo() {
        return Correo;
    }
    
}
