package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;

import java.time.LocalDateTime;

public record ResQuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String donViCongTac,
        String chucDanh,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
        return tac != null ? new ResQuaTrinhCongTac(
                tac.getId(),
                tac.getBatDau(),
                tac.getKetThuc(),
                tac.getDonViCongTac(),
                tac.getChucDanh(),
                tac.getCreate_at(),
                tac.getUpdate_at()
        ) : null;
    }

}
