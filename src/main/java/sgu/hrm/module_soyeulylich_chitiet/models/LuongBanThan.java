package sgu.hrm.module_soyeulylich_chitiet.models;

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

import java.time.LocalDateTime;

@Entity
@Table(name = "luong_ban_than")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class LuongBanThan extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "ma_so", columnDefinition = "varchar(10)")
    String maSo;

    @Column(name = "bac_luong", columnDefinition = "varchar(50)")
    String bacLuong;

    @Column(name = "he_so_luong", columnDefinition = "float")
    float heSoLuong;

    @Column(name = "tien_luong_theo_vi_tri", columnDefinition = "double")
    float tienLuongTheoViTri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_luongbt_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public LuongBanThan(LocalDateTime batDau, LocalDateTime ketThuc, String maSo, String bacLuong, float heSoLuong, float tienLuongTheoViTri, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.maSo = maSo;
        this.bacLuong = bacLuong;
        this.heSoLuong = heSoLuong;
        this.tienLuongTheoViTri = tienLuongTheoViTri;
        this.soYeuLyLich = soYeuLyLich;
    }
}