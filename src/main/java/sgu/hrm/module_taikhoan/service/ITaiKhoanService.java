package sgu.hrm.module_taikhoan.service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ITaiKhoanService {
    ResDTO<ResTaiKhoan> xemThongTinTaiKhoan();

    ResDTO<?> doiMatKhau(String matkhau);

    public ResDTO<?> xemDanhSachTaiKhoan(); //admin

    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoSoCCCDOrUsername(String soCCCD); //admin user

    ResDTO<ResTaiKhoan> xemTaiKhoanTheoId(int id); //admin user

    ResDTO<?> themTaiKhoan(ReqTaiKhoan taiKhoan);

    ResDTO<?> dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin);

    static boolean checkMatKhau(String matkhau) {
        Pattern pattern = Pattern.compile("^[\\p{Lower}\\p{Upper}\\d\\S]{6,15}$");
        Matcher matcher = pattern.matcher(matkhau);
        return matcher.matches();
    }

    static String createUsername(String hoVaTen, List<TaiKhoan> taiKhoans) {
        String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
        String[] sSplit = hoVaTen.split(" "); // tách chuỗi
        StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
        //lay tu cuoi, chu dau in hoa con lai viet thuong
        if (sSplit.length > 0) {
            for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
                if (i != 0) {
                    newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
                    continue;
                }
                newS.append(sSplit[sSplit.length - 1].charAt(i));
            }
        }
        //lay nhung chu cai dau
        for (int i = 0; i < sSplit.length - 1; i++) {
            newS.append(sSplit[i].charAt(0));
        }
        int checkUsername = taiKhoans.stream().filter(tKhoan -> tKhoan.getUsername().contentEquals(newS)).toList().size();
        if (checkUsername > 0) {
            newS.append(checkUsername);
        }
        return newS.toString();
    }

//    void suaTrangThaiTaiKhoan(int id); //admin
//    public ResDTO<TaiKhoan> suaMathauTaiKhosn(int id, String matKhau);
//    public void xoaTaiKhoan();
}
