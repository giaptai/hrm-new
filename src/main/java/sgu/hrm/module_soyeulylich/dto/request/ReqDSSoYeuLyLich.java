package sgu.hrm.module_soyeulylich.dto.request;

import sgu.hrm.enums.PheDuyet;

import java.util.Set;
import java.util.UUID;

public record ReqDSSoYeuLyLich(
        Set<UUID> soYeuLyLichs,
        PheDuyet pheDuyet
) {
}
