package sgu.hrm.module_utilities.services;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.request.ReqUtilities;

import java.util.List;
import java.util.Optional;

public interface IUtilitiesService<T, R> {
    List<T> xemDS();

    Optional<T> xemTheoId(int id);

    T them(String name);

    T sua(int id, R req);

    default boolean xoa(int id) {
        return true;
    }

    default CapBacLoaiQuanHamQuanDoi themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
        return null;
    }
}
