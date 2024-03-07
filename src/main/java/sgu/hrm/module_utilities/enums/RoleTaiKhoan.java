package sgu.hrm.module_utilities.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import sgu.hrm.DateTimeObject;

@Getter
public enum RoleTaiKhoan {

    ADMIN("QUẢN LÝ"),

    EMPLOYEE("NHÂN VIÊN"),

    ;
    private String name;

    RoleTaiKhoan(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
