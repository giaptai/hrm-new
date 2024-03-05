package sgu.hrm.module_utilities.services;

import java.util.List;
import java.util.Optional;

public interface IUtilitiesService<T, R> {
    List<T> xemDS();

    Optional<T> xemTheoId(int id);

    T them(R name);

    T sua(int id, R req);

    default boolean xoa(int id) {
        return true;
    }
}
