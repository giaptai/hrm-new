package sgu.hrm.module_taikhoan.models.request;

import lombok.Builder;

@Builder
public record ReqTaiKhoan(
        String hoVaTen,
        String soCCCD,
        String email) {
    @Override
    public String hoVaTen() {
        return hoVaTen;
    }

    @Override
    public String soCCCD() {
        return soCCCD;
    }

    @Override
    public String email() {
        return email;
    }
}

