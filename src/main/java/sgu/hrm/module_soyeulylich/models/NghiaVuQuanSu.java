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
import sgu.hrm.module_cauhinh.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "nghia_vu_quan_su")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NghiaVuQuanSu extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @Column(name = "ngay_nhap_ngu", columnDefinition = "datetime")
    LocalDateTime ngayNhapNgu;

    @Column(name = "ngay_xuat_ngu", columnDefinition = "datetime")
    LocalDateTime ngayXuatNgu;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "cap_bac_loai_quan_ham_quan_doi_fk"), name = "quan_ham_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
    CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi;

    @OneToOne
    @MapsId
    @JoinColumn(name = "so_yeu_ly_lich_id")
    private SoYeuLyLich soYeuLyLich;

    public NghiaVuQuanSu(LocalDateTime ngayNhapNgu, LocalDateTime ngayXuatNgu, CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi, SoYeuLyLich soYeuLyLich) {
        super();
        this.ngayNhapNgu = ngayNhapNgu;
        this.ngayXuatNgu = ngayXuatNgu;
        this.capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoi;
        this.soYeuLyLich = soYeuLyLich;
    }
}
