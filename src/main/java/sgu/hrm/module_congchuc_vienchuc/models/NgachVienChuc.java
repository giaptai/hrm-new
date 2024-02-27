package sgu.hrm.module_congchuc_vienchuc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChuc;

@Entity
@Table(name = "ngach_vien_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"bacNgachVienChuc"}) // an thuoc tinh nay di
public class NgachVienChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "varchar(10)")
    String id;

    @Column(length = 100, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "bac_ngach_vien_chuc", referencedColumnName = "id", columnDefinition = "TINYINT")
    BacNgachVienChuc bacNgachVienChuc;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "he_so_luong_vien_chuc_fk"), name = "he_so_luong_vien_chuc", referencedColumnName = "id", columnDefinition = "integer")
    HeSoLuongVienChuc heSoLuongVienChuc;
}