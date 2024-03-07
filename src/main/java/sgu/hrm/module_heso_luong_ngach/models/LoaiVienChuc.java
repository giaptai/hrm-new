package sgu.hrm.module_heso_luong_ngach.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.DateTimeObject;

@Entity
@Table(name = "loai_vien_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiVienChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "varchar(10)")
    String id;

    @Column(length = 2, unique = true)
    String name;
}