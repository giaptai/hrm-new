package sgu.hrm.module_soyeulylich_chitiet.models;

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
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;

import java.time.LocalDateTime;

@Entity
@Table(name = "khen_thuong")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhenThuong extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "nam", columnDefinition = "datetime")
    LocalDateTime nam;

    @Column(name = "xep_loai_chuyen_mon", columnDefinition = "varchar(20)")
    String xepLoaiChuyenMon;

    @Column(name = "xep_loai_thi_dua", columnDefinition = "varchar(20)")
    String xepLoaiThiDua;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "hinh_thuc_khen_thuong_fk"), name = "hinh_thuc_khen_thuong", referencedColumnName = "id", columnDefinition = "integer")
    HinhThucKhenThuong hinhThucKhenThuong;

    @Column(name = "ly_do", columnDefinition = "text default ''")
    String lyDo;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_khthuong_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_khthuong_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public KhenThuong(LocalDateTime nam, String xepLoaiChuyenMon, String xepLoaiThiDua, HinhThucKhenThuong hinhThucKhenThuong, String lyDo, LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet, SoYeuLyLich soYeuLyLich) {
        super();
        this.nam = nam;
        this.xepLoaiChuyenMon = xepLoaiChuyenMon;
        this.xepLoaiThiDua = xepLoaiThiDua;
        this.hinhThucKhenThuong = hinhThucKhenThuong;
        this.lyDo = lyDo;
        this.loaiSoYeuLyLichChiTiet = loaiSoYeuLyLichChiTiet;
        this.soYeuLyLich = soYeuLyLich;
    }
}