package sgu.hrm.module_utilities.models.response;

import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;

import java.time.LocalDateTime;
import java.util.Optional;

public record ResCapBacLoaiHamQuanDoi(
        int id,
        String name,
        String loaiQuanHamQuanDoi,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
    public static ResCapBacLoaiHamQuanDoi mapToResCapBacLoaiHamQuanDoi(CapBacLoaiQuanHamQuanDoi doi) {
        return doi != null ? new ResCapBacLoaiHamQuanDoi(
                doi.getId(),
                doi.getName(),
                Optional.ofNullable(doi.getLoaiQuanHamQuanDoi()).map(LoaiQuanHamQuanDoi::getName).orElse(null),
                doi.getCreate_at(),
                doi.getUpdate_at()
        ) : null;
    }
}
