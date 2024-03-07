package sgu.hrm.module_soyeulylich.models.request;

import sgu.hrm.module_utilities.enums.PheDuyet;

import java.util.Set;
import java.util.UUID;

public record ReqDSSoYeuLyLich(
        Set<UUID> soYeuLyLichs,
        PheDuyet pheDuyet
) {
}
