package sgu.hrm.module_soyeulylich_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import sgu.hrm.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

/** gia dinh bao gom ruot va ben vo hoac chong luon **/
@Entity
@Table(name = "quan_he_gia_dinh")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"}) //error field SoYeuLyLich soYeuLyLich;
public class QuanHeGiaDinh extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "moi_quan_he", columnDefinition = "varchar(50)")
    String moiQuanHe;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50)")
    String hoVaTen;

    @Column(name = "nam_sinh", columnDefinition = "SMALLINT")
    short namSinh;

    @Column(name = "thong_tin_than_nhan", columnDefinition = "text")
    String thongTinThanNhan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_qhgdr_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_qhgdr_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }

    public QuanHeGiaDinh(String moiQuanHe, String hoVaTen, short namSinh, String thongTinThanNhan, SoYeuLyLich soYeuLyLich) {
        super();
        this.moiQuanHe = moiQuanHe;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.thongTinThanNhan = thongTinThanNhan;
        this.soYeuLyLich = soYeuLyLich;
    }
}
