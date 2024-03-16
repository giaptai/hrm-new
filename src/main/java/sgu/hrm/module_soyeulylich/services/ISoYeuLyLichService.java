package sgu.hrm.module_soyeulylich.services;

import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;

import java.util.List;
import java.util.UUID;


public interface ISoYeuLyLichService {
    SoYeuLyLich xemThongTinSoYeuLyLich();

    public SoYeuLyLich capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich);

    public List<SoYeuLyLich> xemDanhSachSoYeuLyLich();

    SoYeuLyLich xemSoYeuLyLichTheoSoCCCDHoacID(String q);

    SoYeuLyLich xemSoYeuLyLichTheoId(UUID id);

    List<SoYeuLyLich> pheDuyetSoYeuLyLich(List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich);
}
