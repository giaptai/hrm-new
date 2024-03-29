package sgu.hrm.module_soyeulylich_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
//import sgu.hrm.module_utilities.models.DonVi;
import sgu.hrm.module_cauhinh.dto.response.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_cauhinh.models.CoQuanToChucDonVi;

import java.time.LocalDateTime;

@Entity
@Table(name = "ky_luat")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class KyLuat extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "hinh_thuc", columnDefinition = "varchar(20)")
    String hinhThuc;

    @Column(name = "hanh_vi_vi_pham_chinh", columnDefinition = "varchar(50) default''")
    String hanhViViPhamChinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "co_quan_quyet_dinh_fk"), name = "co_quan_quyet_dinh", columnDefinition = "INTEGER")
    CoQuanToChucDonVi coQuanQuyetDinh;

    @Enumerated
    @Column(name = "xac_nhan")
    XacNhan xacNhan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_kyluat_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public KyLuat(LocalDateTime batDau, LocalDateTime ketThuc, String hinhThuc, String hanhViViPhamChinh, CoQuanToChucDonVi coQuanQuyetDinh, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.hinhThuc = hinhThuc;
        this.hanhViViPhamChinh = hanhViViPhamChinh;
        this.coQuanQuyetDinh = coQuanQuyetDinh;
        this.soYeuLyLich = soYeuLyLich;
    }
}