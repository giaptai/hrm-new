package sgu.hrm.module_taikhoan.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "taikhoan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan extends DateTimeObject implements UserDetails {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "ho_va_ten")
    String hoVaTen;

    @Column(name = "so_CCCD", columnDefinition = "varchar(15) unique")
    String soCCCD;

    @Column(columnDefinition = "varchar(30) unique")
    String username;

    @Column(columnDefinition = "varchar(20)")
    String password;

    @Column(columnDefinition = "varchar(250) not null default ''")
    String email;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "role_tai_khoan_fk"), name = "role", referencedColumnName = "id", columnDefinition = "tinyint")
    RoleTaiKhoan roleTaiKhoan;

    @OneToOne()
    @JoinColumn(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roleTaiKhoan.getTitle()));
    }

    //ko can getPassword getUsername do @Data no lam roi
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isTrangThai();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "id=" + id +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", soCCCD='" + soCCCD + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleTaiKhoan=" + roleTaiKhoan.toString() +
                ", soYeuLyLich=" + soYeuLyLich.toString() +
                '}';
    }
}
