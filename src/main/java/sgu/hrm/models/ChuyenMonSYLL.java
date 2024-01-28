package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "chuyen_mon_syll")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuyenMonSYLL implements Serializable {

    @EmbeddedId
    ChuyenMonSYLLPK chuyenMonSYLLPK;

    @ManyToOne
    @MapsId("soYeuLyLich") //This is the name of attr in ChuyenMonSYLLPK class
//    @JoinColumn(name = "so_yeu_ly_lich_idd")
    SoYeuLyLich soYeuLyLich;

    @ManyToOne
    @MapsId("chuyenMon")
//    @JoinColumn(name = "chuyen_mon_id")
    ChuyenMon chuyenMon;

}