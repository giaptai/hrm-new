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
import sgu.hrm.module_cauhinh.models.ViTriViecLam;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "viec_lam")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class ViecLam extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "vi_tri_viec_lam_fk"), name = "vi_tri_viec_lam", referencedColumnName = "id", columnDefinition = "INTEGER")
    ViTriViecLam viTriViecLam;

    @Column(name = "ngay_huong_luong_vi_tri_viec_lam", columnDefinition = "datetime")
    LocalDateTime ngayHuongLuongTheoViTriViecLam;

    //theo vi tri viec lam
    @Column(name = "phan_tram_huong_luong", columnDefinition = "double default 1.0")
    float phamTramHuongLuong;

    @Column(name = "phu_cap_tham_nien_vuot_khung", columnDefinition = "double default 0.0")
    double phuCapThamNienVuotKhung;

    @Column(name = "ngay_huong_PCTNVK", columnDefinition = "datetime")
    LocalDateTime ngayHuongPCTNVK;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_vi_tri_viec_lam"), name = "so_yeu_ly_lich_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public ViecLam(ViTriViecLam viTriViecLam, LocalDateTime ngayHuongLuongTheoViTriViecLam,
                   float phamTramHuongLuong, double phuCapThamNienVuotKhung, LocalDateTime ngayHuongPCTNVK, SoYeuLyLich soYeuLyLich) {
        super();
        this.viTriViecLam = viTriViecLam;
        this.ngayHuongLuongTheoViTriViecLam = ngayHuongLuongTheoViTriViecLam;
        this.phamTramHuongLuong = phamTramHuongLuong;
        this.phuCapThamNienVuotKhung = phuCapThamNienVuotKhung;
        this.ngayHuongPCTNVK = ngayHuongPCTNVK;
        this.soYeuLyLich = soYeuLyLich;
    }
}
