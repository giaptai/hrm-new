package sgu.hrm.module_utilities.services;

import sgu.hrm.module_utilities.PhanTrang;

import java.util.List;
import java.util.Optional;

public interface IUtilitiesService<T, R> {
    List<T> xemDS(PhanTrang<T> phanTrang);

    Optional<T> xemTheoId(int id);

    T them(R name);

    T sua(int id, R req);

    default boolean xoa(int id) {
        return true;
    }
}
