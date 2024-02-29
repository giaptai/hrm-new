package sgu.hrm.module_soyeulylich_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

import java.time.LocalDateTime;

@Entity
@Table(name = "ban_than_co_lam_viec_cho_che_do_cu")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BanThanCoLamViecChoCheDoCu extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "chuc_danh_don_vi_dia_diem", columnDefinition = "text")
    String chucDanhDonViDiaDiem;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_btclvccdc_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_btclvccdc_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    @JsonIgnore
    SoYeuLyLich soYeuLyLich;

    public BanThanCoLamViecChoCheDoCu(LocalDateTime batDau, LocalDateTime ketThuc, String chucDanhDonViDiaDiem, LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.chucDanhDonViDiaDiem = chucDanhDonViDiaDiem;
        this.loaiSoYeuLyLichChiTiet = loaiSoYeuLyLichChiTiet;
        this.soYeuLyLich = soYeuLyLich;
    }

    public BanThanCoLamViecChoCheDoCu(LocalDateTime batDau, LocalDateTime ketThuc, String chucDanhDonViDiaDiem, SoYeuLyLich soYeuLyLich) {
//        this.setUpdate_at();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.chucDanhDonViDiaDiem = chucDanhDonViDiaDiem;
        this.soYeuLyLich = soYeuLyLich;
    }
}