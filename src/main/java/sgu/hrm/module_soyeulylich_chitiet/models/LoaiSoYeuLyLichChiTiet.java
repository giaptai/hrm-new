package sgu.hrm.module_soyeulylich_chitiet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import sgu.hrm.module_utilities.models.response.DateTimeObject;


@Entity
@Table(name = "loai_so_yeu_ly_lich_chitiet")
@Getter
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiSoYeuLyLichChiTiet extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 65, unique = true)
    String name;

    public LoaiSoYeuLyLichChiTiet(String name) {
        super();
        this.name = name;
    }
}