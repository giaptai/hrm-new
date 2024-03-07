package sgu.hrm.module_heso_luong_ngach.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.DateTimeObject;

import java.util.List;


@Entity
@Table(name = "bac_ngach_cong_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BacNgachCongChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "integer auto_increment")
    int id;

    @Column(length = 50, unique = true)
    String name;

    @OneToMany(mappedBy = "bacNgachCongChuc")
    List<NgachCongChuc> ngachCongChucs;
}