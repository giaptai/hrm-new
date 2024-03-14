package sgu.hrm.module_soyeulylich.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.module_utilities.enums.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.ChucVu;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.response.DateTimeObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="chuc_vu_hien_tai")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class ChucVuHienTai extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "chuc_vu_fk"), name = "chuc_vu_hientai", referencedColumnName = "id", columnDefinition = "integer")
    ChucVu chucVu;

    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiem;

    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemLai;

    @Column(name = "duoc_quy_hoach_chuc_danh", columnDefinition = "varchar(50) default ''")
    String duocQuyHoacChucDanh;

    @OneToOne
    @MapsId
    @JoinColumn(name = "so_yeu_ly_lich_id")
    SoYeuLyLich soYeuLyLich;
}
