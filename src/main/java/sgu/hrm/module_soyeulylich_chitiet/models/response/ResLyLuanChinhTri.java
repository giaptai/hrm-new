package sgu.hrm.module_soyeulylich_chitiet.models.response;

import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResLyLuanChinhTri(
        int id,
        UUID maSyll,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
    public static ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
        return tri != null ? new ResLyLuanChinhTri(
                tri.getId(),
                tri.getSoYeuLyLich().getId(),
                tri.getBatDau(),
                tri.getKetThuc(),
                tri.getTenCoSoDaoTao(),
                tri.getHinhThucDaoTao(),
                tri.getVanBangDuocCap(),
                tri.getCreate_at(),
                tri.getUpdate_at()
        ) : null;
    }

}
