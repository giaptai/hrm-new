package sgu.hrm.models;

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

@Entity
@Table(name = "doi_tuong_chinh_sach")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoiTuongChinhSach extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 100, unique = true)
    String name;
}
