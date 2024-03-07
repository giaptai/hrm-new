package sgu.hrm.module_soyeulylich_chitiet.models;

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
@Table(name = "phu_cap_khac")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhuCapKhac extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "loai_phu_cap", columnDefinition = "varchar(10)")
    String loaiPhuCap;

    @Column(name = "phan_tram_huong_phu_cap", columnDefinition = "float")
    float phanTramHuongPhuCap;

    @Column(name = "he_so_phu_cap", columnDefinition = "float")
    float heSoPhuCap;

    @Column(name = "hinh_thuc_huong", columnDefinition = "varchar(50)")
    String hinhThucThuong;

    @Column(name = "gia_tri", columnDefinition = "double")
    double giaTri;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_phuck_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_phuck_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public PhuCapKhac(LocalDateTime batDau, LocalDateTime ketThuc, String loaiPhuCap, float phanTramHuongPhuCap, float heSoPhuCap, String hinhThucThuong, double giaTri, LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.loaiPhuCap = loaiPhuCap;
        this.phanTramHuongPhuCap = phanTramHuongPhuCap;
        this.heSoPhuCap = heSoPhuCap;
        this.hinhThucThuong = hinhThucThuong;
        this.giaTri = giaTri;
        this.loaiSoYeuLyLichChiTiet = loaiSoYeuLyLichChiTiet;
        this.soYeuLyLich = soYeuLyLich;
    }
}