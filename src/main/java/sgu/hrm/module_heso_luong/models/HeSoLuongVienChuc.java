package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_utilities.models.BacLuong;

@Entity
@Table(name = "he_so_luong_vien_chuc")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@IdClass(HeSoLuongVienChucId.class) // Add this line
public class HeSoLuongVienChuc extends DateTimeObject {
    @Id
    @Column(name="id", columnDefinition = "integer AUTO_INCREMENT primary key")
    int id;

//    @Id
    @ManyToOne
//    @MapsId("nhom_loai_vien_chuc")
    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_loai_vien_chuc_fk"), name = "nhom_loai_vien_chuc", columnDefinition = "INTEGER", referencedColumnName = "id")
//    @JsonIgnore
    NhomLoaiVienChuc nhomLoaiVienChuc;

//    @Id
    @ManyToOne
//    @MapsId("bac_luong")
    @JoinColumn(foreignKey = @ForeignKey(name = "bac_luong_vien_chuc_fk"), name = "bac_luong", columnDefinition = "INTEGER", referencedColumnName = "id")
    BacLuong bacLuong;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;
}
