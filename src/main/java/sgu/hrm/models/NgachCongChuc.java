package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "ngach_cong_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NgachCongChuc extends DateTimeObject{
    @Id
    @Column(columnDefinition = "varchar(6)")
    String id;

    @Column(length = 100, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "bac_ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "TINYINT")
    BacNgachCongChuc bacNgachCongChuc;
}
