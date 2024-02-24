package sgu.hrm.module_utilities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "chuc_danh_dang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChucDanhDang extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(columnDefinition = "varchar(250) unique")
    String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "cap_nhom_chuc_danh_dang_fk"), name = "cap_nhom_chuc_danh_dang", referencedColumnName = "id", columnDefinition = "integer")
    CapNhomChucDanhDang capNhomChucDanhDang;

    public ChucDanhDang(String name) {
        super(); // goi thi moi set chu
        this.name = name;
    }
    //danh cho edit

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }
}
