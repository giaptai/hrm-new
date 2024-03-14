package sgu.hrm.module_soyeulylich.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.module_utilities.models.response.DateTimeObject;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaoHiem extends DateTimeObject {
    @Column(name = "so_bhxh", columnDefinition = "varchar(10) default ''")
    String soBHXH;

    @Column(name = "so_bhyt", columnDefinition = "varchar(15) default ''")
    String soBHYT;
}
