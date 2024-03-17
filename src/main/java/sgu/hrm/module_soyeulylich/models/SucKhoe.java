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
import sgu.hrm.enums.TinhTrangSucKhoe;
import sgu.hrm.module_cauhinh.models.NhomMau;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;

import java.util.UUID;

@Entity
@Table(name = "suc_khoe")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class SucKhoe extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @Column(name = "tinh_trang_suc_khoe")
    @Enumerated(EnumType.ORDINAL)
    TinhTrangSucKhoe tinhTrangSucKhoe;

    @Column(name = "chieu_cao", columnDefinition = "float default 0.0")
    float chieuCao;

    @Column(name = "can_nang", columnDefinition = "float default 0.0")
    float canNang;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "nhom_mau_fk"), name = "nhom_mau", referencedColumnName = "id", columnDefinition = "INTEGER")
    NhomMau nhomMau;

    @OneToOne
    @MapsId
    @JoinColumn(name = "so_yeu_ly_lich_id")
    SoYeuLyLich soYeuLyLich;

    public SucKhoe(TinhTrangSucKhoe tinhTrangSucKhoe, float chieuCao, float canNang, NhomMau nhomMau, SoYeuLyLich soYeuLyLich) {
        super();
        this.tinhTrangSucKhoe = tinhTrangSucKhoe;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nhomMau = nhomMau;
        this.soYeuLyLich = soYeuLyLich;
    }
}
