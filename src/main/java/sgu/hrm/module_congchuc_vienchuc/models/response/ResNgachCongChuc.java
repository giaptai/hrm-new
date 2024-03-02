package sgu.hrm.module_congchuc_vienchuc.models.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResNgachCongChuc(
        String id,
        String name,
        float heSo,
        String bacLuong,
        String nhomLoaiCongChuc,
        boolean trangThai,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
