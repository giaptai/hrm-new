package sgu.hrm.module_utilities.models;

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
import sgu.hrm.models.DateTimeObject;

@Entity
@Table(name = "vi_tri_viec_lam")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViTriViecLam extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 100, unique = true)
    String name;

    @Column(columnDefinition = "tinyint", name = "bac_luong")
    int bacLuong;

    @Column(columnDefinition = "double default 0")
    double tienLuong;

    public ViTriViecLam(String name, int bacLuong, double tienLuong) {
        super();
        this.name = name;
        this.bacLuong = bacLuong;
        this.tienLuong = tienLuong;
    }

    //danh cho edit

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }
}
