package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;

import java.util.List;

@Entity
@Table(name = "nhom_loai_vien_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"loaiVienChuc"})
public class NhomLoaiVienChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 6, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "loai_vien_chuc", referencedColumnName = "id", columnDefinition = "VARCHAR(10)")
    LoaiVienChuc loaiVienChuc;

//    @OneToMany(mappedBy = "nhomLoaiVienChuc")
//    List<HeSoLuongVienChuc> heSoLuongVienChucs;
}
