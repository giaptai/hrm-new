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
import sgu.hrm.module_utilities.models.CoQuanToChucDonVi;

import java.time.LocalDateTime;

@Entity
@Table(name = "ngoai_ngu")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"soYeuLyLich"})
public class NgoaiNgu extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "ten_co_so_dao_tao_ngoaingu_fk"), name = "ten_co_so_dao_tao", columnDefinition = "INTEGER")
    CoQuanToChucDonVi tenCoSoDaoTao;

    @Column(name = "ten_ngoai_ngu", columnDefinition = "varchar(50)")
    String tenNgoaiNgu;

    @Column(name = "chung_chi_duoc_cap", columnDefinition = "varchar(50)")
    String chungChiDuocCap;

    @Column(name = "diem_so", columnDefinition = "float")
    float diemSo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_ngoaingu_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    @Override
    public void setUpdate_at() {
        super.setUpdate_at();
    }

    public NgoaiNgu(LocalDateTime batDau, LocalDateTime ketThuc, CoQuanToChucDonVi tenCoSoDaoTao, String tenNgoaiNgu, String chungChiDuocCap, float diemSo, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.tenCoSoDaoTao = tenCoSoDaoTao;
        this.tenNgoaiNgu = tenNgoaiNgu;
        this.chungChiDuocCap = chungChiDuocCap;
        this.diemSo = diemSo;
        this.soYeuLyLich = soYeuLyLich;
    }
}