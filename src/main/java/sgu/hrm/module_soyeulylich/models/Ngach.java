package sgu.hrm.module_soyeulylich.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import sgu.hrm.module_heso_luong_ngach.models.NgachCongChuc;
import sgu.hrm.module_heso_luong_ngach.models.NgachVienChuc;
import sgu.hrm.module_utilities.models.ViTriViecLam;
import sgu.hrm.module_utilities.models.response.DateTimeObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ngach")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class Ngach extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_cong_chuc_fk"), name = "ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "varchar(6)")
    NgachCongChuc ngachCongChuc;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ngach_vien_chuc_fk"), name = "ngach_vien_chuc", referencedColumnName = "id", columnDefinition = "varchar(10)")
    NgachVienChuc ngachVienChuc;

    @Column(name = "ngay_bo_nhiem_ngach", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemNgach;

    @Column(name = "ngay_huong_luong_ngach", columnDefinition = "datetime")
    LocalDateTime ngayHuongLuongNgach;

    @Column(name = "phan_tram_huong_luong_ngach", columnDefinition = "float default 1.0")
    float phanTramHuongLuongNgach;

    @Column(name = "phu_cap_tham_nien_vuot_khung_ngach", columnDefinition = "double default 0.0")
    double phuCapThamNienVuotKhungNgach;

    @Column(name = "ngay_huong_PCTNVK_ngach", columnDefinition = "datetime")
    LocalDateTime ngayHuongPCTNVKNgach;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_ngach"), name = "so_yeu_ly_lich_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public Ngach(NgachCongChuc ngachCongChuc, NgachVienChuc ngachVienChuc, LocalDateTime ngayBoNhiemNgach,
                 LocalDateTime ngayHuongLuongNgach, float phanTramHuongLuongNgach, double phuCapThamNienVuotKhungNgach,
                 LocalDateTime ngayHuongPCTNVKNgach, SoYeuLyLich soYeuLyLich) {
        super();
        this.ngachCongChuc = ngachCongChuc;
        this.ngachVienChuc = ngachVienChuc;
        this.ngayBoNhiemNgach = ngayBoNhiemNgach;
        this.ngayHuongLuongNgach = ngayHuongLuongNgach;
        this.phanTramHuongLuongNgach = phanTramHuongLuongNgach;
        this.phuCapThamNienVuotKhungNgach = phuCapThamNienVuotKhungNgach;
        this.ngayHuongPCTNVKNgach = ngayHuongPCTNVKNgach;
        this.soYeuLyLich = soYeuLyLich;
    }
}
