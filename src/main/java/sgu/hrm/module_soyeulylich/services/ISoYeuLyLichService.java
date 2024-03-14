package sgu.hrm.module_soyeulylich.services;

import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;

import java.util.List;


public interface ISoYeuLyLichService {
    SoYeuLyLich xemThongTinSoYeuLyLich();

    public SoYeuLyLich capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich);

    public List<SoYeuLyLich> xemDanhSachSoYeuLyLich();

    SoYeuLyLich xemSoYeuLyLichTheoSoCCCDHoacID(String q);

    SoYeuLyLich xemSoYeuLyLichTheoId(String id);

    List<SoYeuLyLich> pheDuyetSoYeuLyLich(List<ReqDSSoYeuLyLich> reqDSSoYeuLyLich);
}
