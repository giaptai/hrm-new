package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
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
@Table(name = "he_so_luong_cong_chuc")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
//@IdClass(HeSoLuongCongChucId.class)
public class HeSoLuongCongChuc extends DateTimeObject {
//    @EmbeddedId
//    HeSoLuongCongChucId heSoLuongCongChucId;

    @Id
    @Column(name="id", columnDefinition = "integer auto_increment primary key")
    int id;

    //    @Id
    @ManyToOne
////    @MapsId("nhom_loai_cong_chuc")
    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_loai_cong_chuc_fk"),name = "nhom_loai_cong_chuc", columnDefinition = "INTEGER", referencedColumnName = "id")
////    @JsonIgnore
//    @JsonIgnoreProperties({"trangThai", "id"})
    NhomLoaiCongChuc nhomLoaiCongChuc;
    //
//    @Id
    @ManyToOne
////    @MapsId("bac_luong")
    @JoinColumn(foreignKey = @ForeignKey(name = "bac_luong_cong_chuc_fk"), name = "bac_luong", columnDefinition = "INTEGER", referencedColumnName = "id")
////    @JsonIgnore
//    @JsonIgnoreProperties({"trangThai", "id"})
    BacLuong bacLuong;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;
}