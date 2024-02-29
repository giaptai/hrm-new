package sgu.hrm.module_response;

public enum ResEnum {
    KY_LUAT_THANH_CONG(200),
    KY_LUAT_THAT_BAI(200),
    KHEN_THUONG_THANH_CONG(200),
    KHEN_THUONG_THAT_BAI(200),
    DOI_MAT_KHAU_THANH_CONG(200),
    DANG_NHAP_THANH_CONG(200),
    DANG_NHAP_THAT_BAI(200),
    THANH_CONG(200),
    TAO_THANH_CONG(201),
    CAP_NHAT_THANH_CONG(204),
    XOA_THANH_CONG(202),
    KHONG_HOP_LE(400),
    KHONG_DUOC_UY_QUYEN(401),
    TRUY_CAP_BI_CAM(403),
    HONG_TIM_THAY(404);
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
    //1 dto de ghi gia tri
//    public record resDTO<T>(
//            int statusCode,
//            ResEnum message,
//            T data
//
//    ) {
////
//    }
}
