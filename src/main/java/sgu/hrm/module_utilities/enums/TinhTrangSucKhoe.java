package sgu.hrm.module_utilities.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import sgu.hrm.DateTimeObject;

public enum TinhTrangSucKhoe {
    YEU("YẾU"),
    TRUNG_BINH("TRUNG BÌNH"),
    KHA("KHÁ"),
    TOT("TỐT"),
    KHOE("KHỎE"),
    ;

    private String name;

    TinhTrangSucKhoe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
