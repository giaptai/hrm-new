package sgu.hrm.module_response;

public enum ResEnum {
    THANH_CONG(200), //Yêu cầu thành công.
    TAO_THANH_CONG(201), //201 Created: Yêu cầu thành công và một tài nguyên mới đã được tạo.
    CAP_NHAT_THANH_CONG(204), //204 No Content:Yêu cầu thành công nhưng không có nội dung nào để trả về.
    XOA_THANH_CONG(202),
    KY_LUAT_THANH_CONG(200),
    KY_LUAT_THAT_BAI(200),
    KHEN_THUONG_THANH_CONG(200),
    KHEN_THUONG_THAT_BAI(200),
    CHUYEN_CONG_TAC_THANH_CONG(200),
    CHUYEN_CONG_TAC_THAT_BAI(200),
    DOI_MAT_KHAU_THANH_CONG(200),
    DANG_NHAP_THANH_CONG(200),
    DANG_XUAT_THANH_CONG(200),
    DANG_NHAP_THAT_BAI(200),
    PHUONG_THUC_KHONG_HOP_LE(405), //405 Method Not Allowed Phương thức HTTP không được hỗ trợ cho nguồn tài nguyên được yêu cầu.
    KHONG_HOP_LE(400),
    KHONG_DUOC_UY_QUYEN(401), //401 Unauthorized: Client không được phép truy cập tài nguyên.
    TRUY_CAP_BI_CAM(403), //403 Forbidden: Client bị cấm truy cập tài nguyên.
    HONG_TIM_THAY(404); //404 Not Found: Tài nguyên không được tìm thấy.
    private int statusCode;

    ResEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
