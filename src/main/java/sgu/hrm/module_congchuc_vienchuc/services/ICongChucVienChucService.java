package sgu.hrm.module_congchuc_vienchuc.services;

import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.response.ResNgachVienChuc;
import sgu.hrm.module_response.ResDTO;

import java.util.List;

public interface ICongChucVienChucService {
    interface IBacNgachCongChucService {
        ResDTO<List<BacNgachCongChuc>> xemBacNgachCongChuc();
    }

    interface IBacNgachVienChucService {
        ResDTO<List<BacNgachVienChuc>> xemBacNgachVienChuc();
    }

    interface INgachCongChucService {
        abstract ResDTO<List<ResNgachCongChuc>> xemNgachCongChuc();
    }

    interface INgachVienChucService {
        abstract ResDTO<List<ResNgachVienChuc>> xemNgachVienChuc();
    }
}
