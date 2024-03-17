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
import sgu.hrm.module_cauhinh.models.DanhHieuNhaNuoc;
import sgu.hrm.module_cauhinh.models.HocHam;
import sgu.hrm.module_cauhinh.models.TrinhDoChuyenMon;
import sgu.hrm.module_cauhinh.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;

import java.util.UUID;

@Entity
@Table(name = "hoc_van")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class HocVan extends DateTimeObject {
    @Id
    @Column(name = "so_yeu_ly_lich_id")
    UUID id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_giao_duc_pho_thong_fk"), name = "trinh_do_giao_duc_pho_thong", referencedColumnName = "id", columnDefinition = "integer")
    TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_chuyen_mon_fk"), name = "trinh_do_chuyen_mon_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
    TrinhDoChuyenMon trinhDoChuyenMon;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "hoc_ham_fk"), name = "hoc_ham", referencedColumnName = "id", columnDefinition = "integer")
    HocHam hocHam;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "danh_hieu_nha_nuoc_phong_tang_fk"), name = "danh_hieu_nha_nuoc", referencedColumnName = "id", columnDefinition = "integer")
    DanhHieuNhaNuoc danhHieuNhaNuocPhongTang;

    @OneToOne
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_hoc_van"), name = "so_yeu_ly_lich_id", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public HocVan(TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong, TrinhDoChuyenMon trinhDoChuyenMon, HocHam hocHam, DanhHieuNhaNuoc danhHieuNhaNuocPhongTang, SoYeuLyLich soYeuLyLich) {
        super();
        this.trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThong;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
        this.hocHam = hocHam;
        this.danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTang;
        this.soYeuLyLich=soYeuLyLich;
    }

}
