package sgu.hrm.module_soyeulylich_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
import sgu.hrm.enums.XacNhan;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.enums.XepLoaiChuyenMon;
import sgu.hrm.enums.XepLoaiThiDua;
import sgu.hrm.module_cauhinh.models.HinhThucKhenThuong;

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
@JsonIgnoreProperties({"soYeuLyLich"})
public class KhenThuong extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "nam", columnDefinition = "datetime")
    LocalDateTime nam;

    @Column(name = "xep_loai_chuyen_mon")
    @Enumerated(EnumType.STRING)
    XepLoaiChuyenMon xepLoaiChuyenMon;

    @Column(name = "xep_loai_thi_dua")
    @Enumerated(EnumType.STRING)
    XepLoaiThiDua xepLoaiThiDua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "hinh_thuc_khen_thuong_fk"), name = "hinh_thuc_khen_thuong", referencedColumnName = "id", columnDefinition = "integer")
    HinhThucKhenThuong hinhThucKhenThuong;

    @Column(name = "ly_do", columnDefinition = "text")
    String lyDo;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_khthuong_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public KhenThuong(LocalDateTime nam, XepLoaiChuyenMon xepLoaiChuyenMon, XepLoaiThiDua xepLoaiThiDua, HinhThucKhenThuong hinhThucKhenThuong, String lyDo, SoYeuLyLich soYeuLyLich) {
        super();
        this.nam = nam;
        this.xepLoaiChuyenMon = xepLoaiChuyenMon;
        this.xepLoaiThiDua = xepLoaiThiDua;
        this.hinhThucKhenThuong = hinhThucKhenThuong;
        this.lyDo = lyDo;
        this.soYeuLyLich = soYeuLyLich;
    }
}