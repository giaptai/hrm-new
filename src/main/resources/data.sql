-- taikhoan
INSERT INTO taikhoan (`username`, `password`, `so_cccd`, `role`)
VALUES ('ThuNTM', '001225145523', '001225145523', 'ADMIN'),
       ('TaiNG', '001478111451', '001478111451', 'EMPLOYEE');
-- nhóm máu
INSERT INTO nhom_mau (name)
values ('A'),
       ('B'),
       ('AB'),
       ('O');
-- doi_tuong_chinh_sach
INSERT INTO doi_tuong_chinh_sach (name)
values ('Không'),
       ('Dân tộc thiểu số'),
       ('Con liệt sĩ');
-- trinh_do_giao_duc_pho_thong
INSERT INTO trinh_do_giao_duc_pho_thong (name)
values ('10/10'),
       ('12/12');
-- trinh_do_chuyen_mon
INSERT INTO trinh_do_chuyen_mon (name)
values ('Sơ cấp'),
       ('Trung cấp'),
       ('Cao đẳng'),
       ('Đại học'),
       ('Thạc sĩ'),
       ('Tiến sĩ');
-- học hàm
INSERT INTO hoc_ham (name)
values ('Không'),
       ('Giáo sư'),
       ('Phó giáo sư');
-- danh_hieu_nha_nuoc_phong_tang
INSERT INTO danh_hieu_nha_nuoc (name)
values ('Không'),
       ('Tỉnh Anh hùng'),
       ('Thành phố Anh hùng'),
       ('Bà mẹ Việt Nam Anh hùng'),
       ('Anh hùng Lực lượng vũ trang nhân dân'),
       ('Anh hùng Lao động'),
       ('Nhà giáo nhân dân'),
       ('Nhà giáo ưu tú');
-- dân tộc
INSERT INTO dan_toc (name)
VALUES ("Ba Na"),
       ("Bà Y"),
       ("Bố Y"),
       ("Brau"),
       ("Bru - Vân Kiều"),
       ("Chăm"),
       ("Chơ Ro"),
       ("Chứt"),
       ("Cơ Ho"),
       ("Cơ Tu"),
       ("Cống"),
       ("Coong"),
       ("Cờ Lao"),
       ("Ê Đê"),
       ("Gia Rai"),
       ("Giáy"),
       ("Hà Nhì"),
       ("Hrê"),
       ("Kháng"),
       ("Khơ Mú"),
       ("Khơ Lơ"),
       ("Kinh"),
       ("Krông"),
       ("Lào"),
       ("La Chí"),
       ("La Ha"),
       ("Lô Lô"),
       ("Mảng"),
       ("M'nông"),
       ("Mơ Nông"),
       ("Mường"),
       ("Nùng"),
       ("Ô Đu"),
       ("Pà Thẻn"),
       ("Phù Lá"),
       ("Pu Péo"),
       ("Rơ Măm"),
       ("Ra Glai"),
       ("Rục"),
       ("Sán Chay"),
       ("Sán Dìu"),
       ("Sán Rìu"),
       ("Si La"),
       ("Sơ Rếch"),
       ("Tày"),
       ("Tày Thái"),
       ("Thổ"),
       ("Thái"),
       ("Xinh Mun"),
       ("Xơ Đăng"),
       ("X' Tiêng"),
       ("Ya Chêng"),
       ("Ý Đình"),
       ("Zao");
-- tôn giáo
INSERT INTO ton_giao (name)
VALUES ('Không'),
       ('Phật giáo'),
       ('Công giáo'),
       ('Tin Lành'),
       ('Cao Đài'),
       ('Phật giáo Hòa Hảo'),
       ('Hồi giáo'),
       ('Tôn giáo Baha`i'),
       ('Tịnh độ Cư sỹ Phật hội'),
       ('Cơ đốc Phục lâm'),
       ('Phật giáo Tứ Ân Hiếu nghĩa'),
       ('Minh Sư đạo'),
       ('Ba-la-môn giáo'),
       ('Mặc môn'),
       ('Phật giáo Hiếu Nghĩa Tà Lơn'),
       ('Bửu Sơn Kỳ Hương');

-- thành phần gia đình
insert into thanh_phan_gia_dinh (name)
VALUES ('Cố nông'),
       ('Bần nông'),
       ('Trung nông'),
       ('Phú nông/ Địa chủ'),
       ('Công chức/ Viên chức'),
       ('Nghèo đói'),
       ('Tiểu thương'),
       ('Tiểu chủ'),
       ('Tư sản'),
       ('Tiểu tư sản');
-- bac_luong
INSERT INTO bac_luong (name)
VALUES ('Bậc 1'),
       ('Bậc 2'),
       ('Bậc 3'),
       ('Bậc 4'),
       ('Bậc 5'),
       ('Bậc 6'),
       ('Bậc 7'),
       ('Bậc 8'),
       ('Bậc 9'),
       ('Bậc 10'),
       ('Bậc 11'),
       ('Bậc 12');
-- loai_vien_chuc
INSERT INTO loai_vien_chuc (id, name)
values (0, 'A3'),
       (1, 'A2'),
       (2, 'A1'),
       (3, 'A0'),
       (4, 'B');
-- loai_cong_chuc
INSERT INTO loai_cong_chuc (id, name)
values (0, 'A3'),
       (1, 'A2'),
       (2, 'A1'),
       (3, 'A0'),
       (4, 'B'),
       (5, 'C');
-- nhom_loai_vien_chuc
INSERT into nhom_loai_vien_chuc (name, loai_vien_chuc)
values ('A3.1', 0),
       ('A3.2', 0),
       ('A2.1', 1),
       ('A2.2', 1),
       ('A1', 2),
       ('A0', 3),
       ('B', 4);
-- nhom_loai_cong_chuc
INSERT into nhom_loai_cong_chuc (name, loai_cong_chuc)
values ('A3.1', 0),
       ('A3.2', 0),
       ('A2.1', 1),
       ('A2.2', 1),
       ('A1', 2),
       ('A0', 3),
       ('B', 4),
       ('C1', 5);
-- he_so_luong_vien_chuc
INSERT into he_so_luong_vien_chuc (nhom_loai_vien_chuc, bac_luong, he_so)
values (1, 1, 6.2),
       (1, 2, 6.56),
       (1, 3, 6.92),
       (1, 4, 7.28),
       (1, 5, 7.64),
       (1, 6, 8.00),
       (2, 1, 5.75),
       (2, 2, 6.11),
       (2, 3, 6.47),
       (2, 4, 6.83),
       (2, 5, 7.19),
       (2, 6, 7.55),
       (3, 1, 4.4),
       (3, 2, 4.74),
       (3, 3, 5.08),
       (3, 4, 5.42),
       (3, 5, 5.76),
       (3, 6, 6.10),
       (3, 7, 6.44),
       (3, 8, 6.78),
       (4, 1, 4.0),
       (4, 2, 4.34),
       (4, 3, 4.68),
       (4, 4, 5.02),
       (4, 5, 5.36),
       (4, 6, 5.7),
       (4, 7, 6.04),
       (4, 8, 6.38),
       (5, 1, 2.34),
       (5, 2, 2.67),
       (5, 3, 3.00),
       (5, 4, 3.33),
       (5, 5, 3.66),
       (5, 6, 3.99),
       (5, 7, 4.32),
       (5, 8, 4.65),
       (5, 9, 4.98),
       (6, 1, 2.10),
       (6, 2, 2.41),
       (6, 3, 2.72),
       (6, 4, 3.03),
       (6, 5, 3.34),
       (6, 6, 3.65),
       (6, 7, 3.96),
       (6, 8, 4.27),
       (6, 9, 4.58),
       (6, 10, 4.89),
       (7, 1, 1.86),
       (7, 2, 2.06),
       (7, 3, 2.26),
       (7, 4, 2.46),
       (7, 5, 2.66),
       (7, 6, 2.86),
       (7, 7, 3.06),
       (7, 8, 3.26),
       (7, 9, 3.46),
       (7, 10, 3.66),
       (7, 11, 3.86),
       (7, 12, 4.06);
-- he_so_luong_cong_chuc
INSERT into he_so_luong_cong_chuc (nhom_loai_cong_chuc, bac_luong, he_so)
values (1, 1, 6.2),
       (1, 2, 6.56),
       (1, 3, 6.92),
       (1, 4, 7.28),
       (1, 5, 7.64),
       (1, 6, 8.00),
       (2, 1, 5.75),
       (2, 2, 6.11),
       (2, 3, 6.47),
       (2, 4, 6.83),
       (2, 5, 7.19),
       (2, 6, 7.55),
       (3, 1, 4.4),
       (3, 2, 4.74),
       (3, 3, 5.08),
       (3, 4, 5.42),
       (3, 5, 5.76),
       (3, 6, 6.10),
       (3, 7, 6.44),
       (3, 8, 6.78),
       (4, 1, 4.0),
       (4, 2, 4.34),
       (4, 3, 4.68),
       (4, 4, 5.02),
       (4, 5, 5.36),
       (4, 6, 5.7),
       (4, 7, 6.04),
       (4, 8, 6.38),
       (5, 1, 2.34),
       (5, 2, 2.67),
       (5, 3, 3.00),
       (5, 4, 3.33),
       (5, 5, 3.66),
       (5, 6, 3.99),
       (5, 7, 4.32),
       (5, 8, 4.65),
       (5, 9, 4.98),
       (6, 1, 2.10),
       (6, 2, 2.41),
       (6, 3, 2.72),
       (6, 4, 3.03),
       (6, 5, 3.34),
       (6, 6, 3.65),
       (6, 7, 3.96),
       (6, 8, 4.27),
       (6, 9, 4.58),
       (6, 10, 4.89),
       (7, 1, 1.86),
       (7, 2, 2.06),
       (7, 3, 2.26),
       (7, 4, 2.46),
       (7, 5, 2.66),
       (7, 6, 2.86),
       (7, 7, 3.06),
       (7, 8, 3.26),
       (7, 9, 3.46),
       (7, 10, 3.66),
       (7, 11, 3.86),
       (7, 12, 4.06),
       (8, 1, 1.65),
       (8, 2, 1.83),
       (8, 3, 2.01),
       (8, 4, 2.19),
       (8, 5, 2.37),
       (8, 6, 2.55),
       (8, 7, 2.73),
       (8, 8, 2.91),
       (8, 9, 3.09),
       (8, 10, 3.27),
       (8, 11, 3.45),
       (8, 12, 3.63);
-- hinh_thuc_khen_thuong
INSERT INTO hinh_thuc_khen_thuong(name)
VALUES ('Huân chương'),
       ('Huy chương'),
       ('Danh hiệu vinh dự nhà nước'),
       ('Giải thưởng Hồ Chí Minh'),
       ('Giải thưởng Nhà nước'),
       ('Kỷ niệm chương'),
       ('Bằng khen'),
       ('Giấy khen');
-- nhom_chuc_danh_dang
INSERT INTO nhom_chuc_danh_dang (name)
values ('Các chức danh lãnh đạo chủ chốt và lãnh đạo cấp cao của Đảng và Nhà nước'),
       ('Chức danh cán bộ thuộc diện Bộ Chính trị, Ban Bí thư quản lý'),
       ('Khung chức danh, chức vụ thuộc diện cấp ủy, tổ chức đảng, lãnh đạo cơ quan, đơn vị quản lý');

INSERT INTO cap_nhom_chuc_danh_dang (name, nhom_chuc_danh_dang)
VALUES ('Lãnh đạo chủ chốt của Đảng và Nhà nước', 1),
       ('Lãnh đạo cấp cao của Đảng, Nhà nước và Mặt trận Tổ quốc Việt Nam', 1),
       ('Các chức danh thuộc diện Bộ Chính trị quản lý', 2),
       ('Các chức danh diện Ban Bí thư quản lý', 2),
       ('Tổng cục trưởng và tương đương', 3),
       ('Phó Tổng cục trưởng và tương đương', 3),
       ('Vụ trưởng và tương đương', 3),
       ('Phó vụ trưởng và tương đương', 3),
       ('Trưởng phòng và tương đương', 3),
       ('Phó trưởng phòng và tương đương', 3),
       ('Cán bộ xã, phường, thị trấn', 3);
-- chuc_danh_dang
INSERT INTO chuc_danh_dang (name, cap_nhom_chuc_danh_dang)
VALUES ('Tổng Bí thư', 1),
       ('Chủ tịch nước', 1),
       ('Thủ tướng Chính phủ', 1),
       ('Chủ tịch Quốc hội', 1),
       ('Thường trực Ban Bí thư', 2),
       ('Ủy viên Bộ Chính trị', 2),
       ('Ủy viên Ban Bí thư', 2),
       ('Chủ tịch Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 2),
       ('Chánh án Toà án nhân dân tối cao', 2),
       ('Viện trưởng Viện Kiểm sát nhân dân tối cao', 2),
       ('Phó Chủ tịch nước', 2),
       ('Phó Thủ tướng Chính phủ', 2),
       ('Phó Chủ tịch Quốc hội', 2),
       ('Ủy viên Trung ương Đảng chính thức', 3),
       ('Trưởng ban, cơ quan đảng ở Trung ương', 3),
       ('Giám đốc Học viện Chính trị quốc gia Hồ Chí Minh', 3),
       ('Tổng Biên tập Báo Nhân Dân', 3),
       ('Tổng Biên tập Tạp chí Cộng sản', 3),
       ('Ủy viên Ủy ban Thường vụ Quốc hội', 3),
       ('Bộ trưởng và thủ trưởng cơ quan ngang bộ', 3),
       ('Chủ nhiệm Văn phòng Chủ tịch nước', 3),
       ('Tổng Kiểm toán Nhà nước', 3),
       ('Trưởng tổ chức chính trị - xã hội ở Trung ương', 3),
       ('Phó Chủ tịch - Tổng Thư ký Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 3),
       ('Bí thư tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 3),
       ('Phó Bí thư Thành ủy Hà Nội', 3),
       ('Phó Bí thư Thành ủy Thành phố Hồ Chí Minh', 3),
       ('Chủ tịch Hội đồng nhân dân, Ủy ban nhân dân thành phố Hà Nội', 3),
       ('Phó Chủ nhiệm Ủy ban Kiểm tra Trung ương', 3),
       ('Chủ tịch Viện Hàn lâm Khoa học xã hội Việt Nam', 3),
       ('Chủ tịch Viện Hàn lâm Khoa học công nghệ Việt Nam', 3),
       ('Chủ tịch Ủy ban Quản lý vốn nhà nước tại doanh nghiệp', 3),
       ('Tổng Giám đốc Thông tấn xã Việt Nam', 3),
       ('Tổng Giám đốc Đài Tiếng nói Việt Nam', 3),
       ('Tổng Giám đốc Đài Truyền hình Việt Nam', 3),
       ('Phó trưởng ban, cơ quan đảng ở Trung ương', 3),
       ('Phó Giám đốc Học viện Chính trị quốc gia Hồ Chí Minh', 3),
       ('Phó Tổng Biên tập Báo Nhân Dân', 3),
       ('Phó Tổng Biên tập Tạp chí Cộng sản', 3),
       ('Phó Chủ tịch Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 4),
       ('Phó Chủ tịch Hội đồng Dân tộc', 4),
       ('Phó Chủ nhiệm các Ủy ban của Quốc hội', 4),
       ('Phó Chủ nhiệm Văn phòng Quốc hội', 4),
       ('Phó Chánh án Toà án nhân dân tối cao', 4),
       ('Phó Viện trưởng Viện Kiểm sát nhân dân tối cao', 4),
       ('Thứ trưởng, phó thủ trưởng cơ quan ngang bộ', 4),
       ('Phó Chủ nhiệm Văn phòng Chủ tịch nước', 4),
       ('Phó Tổng Kiểm toán Nhà nước', 4),
       ('Phó trưởng các tổ chức chính trị - xã hội ở Trung ương', 4),
       ('Bí thư thường trực Trung ương Đoàn Thanh niên Cộng sản Hồ Chí Minh', 4),
       ('Phó bí thư tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 4),
       ('Chủ tịch Hội đồng nhân dân, chủ tịch Ủy ban nhân dân tỉnh, thành phố trực thuộc Trung ương', 4),
       ('Ủy viên Ủy ban Kiểm tra Trung ương', 4),
       ('Giám đốc Nhà xuất bản Chính trị quốc gia Sự thật', 4),
       ('Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương', 4),
       ('Trợ lý các đồng chí lãnh đạo chủ chốt của Đảng, Nhà nước', 4),
       ('Trợ lý Thường trực Ban Bí thư', 4),
       ('Viện trưởng Viện Nghiên cứu lập pháp thuộc Ủy ban Thường vụ Quốc hội', 4),
       ('Giám đốc Đại học Quốc gia Hà Nội', 4),
       ('Giám đốc Đại học Quốc gia Thành phố Hồ Chí Minh', 4),
       ('Tổng Giám đốc Bảo hiểm xã hội Việt Nam', 4),
       ('Trưởng Ban Quản lý Lăng Chủ tịch Hồ Chí Minh', 4),
       ('Chủ tịch Ủy ban giám sát tài chính quốc gia', 4),
       ('Phó Chủ tịch Ủy ban quản lý vốn nhà nước tại doanh nghiệp', 4),
       ('Tổng cục trưởng', 5),
       ('Phó Trưởng Ban Công tác đại biểu', 5),
       ('Phó Trưởng Ban Dân nguyện thuộc Ủy ban Thường vụ Quốc hội', 5),
       ('Phó Chủ tịch Viện Hàn lâm Khoa học xã hội Việt Nam', 5),
       ('Phó Chủ tịch Viện Hàn lâm Khoa học công nghệ Việt Nam', 5),
       ('Phó Tổng Giám đốc Thông tấn xã Việt Nam', 5),
       ('Phó Tổng Giám đốc Đài Tiếng nói Việt Nam', 5),
       ('Phó Tổng Giám đốc Đài Truyền hình Việt Nam', 5),
       ('Bí thư Trung ương Đoàn Thanh niên Cộng sản Hồ Chí Minh', 5),
       ('Ủy viên Thường trực Hội đồng Dân tộc', 5),
       ('Ủy viên Thường trực các Ủy ban của Quốc hội', 5),
       ('Ủy viên Ban Thường vụ Thành ủy Hà Nội', 5),
       ('Thành ủy Thành phố Hồ Chí Minh', 5),
       ('Ủy viên Thường trực Tiểu ban Bảo vệ chính trị nội bộ Trung ương', 5),
       ('Trưởng đoàn đại biểu Quốc hội chuyên trách tỉnh', 5),
       ('Ủy ban nhân dân thành phố Hà Nội', 5),
       ('Ủy viên Ban Biên tập Báo Nhân dân', 5),
       ('Ủy viên Ban Biên tập Tạp chí Cộng sản', 5),
       ('Phó trưởng ban chuyên trách hoặc ủy viên chuyên trách các ban chỉ đạo ở Trung ương', 5),
       ('Trợ lý các đồng chí lãnh đạo cấp cao của Đảng', 5),
       ('Nhà nước', 5),
       ('Tổng Biên tập Báo Điện tử Đảng Cộng sản Việt Nam', 5),
       ('Tổng Biên tập Báo Đại biểu nhân dân', 5),
       ('Giám đốc Truyền hình Quốc hội', 5),
       ('Tổng Giám đốc Cổng thông tin điện tử Chính phủ', 5),
       ('Phó Giám đốc Đại học Quốc gia Hà Nội', 5),
       ('Phó Giám đốc Đại học Quốc gia Thành phố Hồ Chí Minh', 5),
       ('Phó Tổng Giám đốc Bảo hiểm xã hội Việt Nam', 5),
       ('Phó Chánh Văn phòng Ban cán sự đảng Chính phủ', 5),
       ('Phó Chánh Văn phòng Đảng đoàn Quốc hội', 5),
       ('Phó bí thư chuyên trách công tác đảng ở các Đảng ủy', 5),
       ('Văn phòng Trung ương Đảng', 5),
       ('Văn phòng Chính phủ', 5),
       ('Văn phòng Quốc hội', 5),
       ('Bộ Ngoại giao', 5),
       ('Học viện Chính trị quốc gia Hồ Chí Minh', 5),
       ('Phó Giám đốc Nhà xuất bản Chính trị quốc gia Sự thật', 6),
       ('Phó Viện trưởng Viện Nghiên cứu lập pháp thuộc Ủy ban Thường vụ Quốc hội', 6),
       ('Phó Trưởng Ban Quản lý Lăng Chủ tịch Hồ Chí Minh', 6),
       ('Ủy viên chuyên trách Hội đồng Dân tộc và các Ủy ban của Quốc hội', 6),
       ('Ủy viên ban thường vụ tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 6),
       ('Chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam tỉnh', 6),
       ('Phó chủ tịch Hội đồng nhân dân', 6),
       ('Ủy ban nhân dân tỉnh', 6),
       ('Thành phố trực thuộc Trung ương', 6),
       ('Phó Chủ tịch Ủy ban giám sát tài chính quốc gia', 6),
       ('Phó trưởng đoàn đại biểu Quốc hội chuyên trách tỉnh', 6),
       ('Phó Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
        6),
       ('Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội không có đảng đoàn)',
        6),
       ('Phó Tổng Biên tập Báo Điện tử Đảng Cộng sản Việt Nam', 6),
       ('Phó Tổng Biên tập Báo Đại biểu nhân dân', 6),
       ('Phó Giám đốc Truyền hình Quốc hội', 6),
       ('Phó Tổng Giám đốc Cổng thông tin điện tử Chính phủ', 6),
       ('Chánh án Toà án nhân dân cấp cao', 6),
       ('Viện trưởng Viện Kiểm sát nhân dân cấp cao', 6),
       ('Giám đốc học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh', 6),
       ('Vụ trưởng, cục trưởng, viện trưởng, trưởng ban và tương đương thuộc ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương',
        7),
       ('Trưởng ban đảng, cơ quan trực thuộc tỉnh ủy, thành ủy', 7),
       ('Ủy viên Hội đồng Biên tập Nhà xuất bản Chính trị quốc gia Sự thật', 7),
       ('Tổng Thư ký Liên hiệp Hội ở Trung ương', 7),
       ('Thư ký các đồng chí lãnh đạo chủ chốt, lãnh đạo cấp cao của Đảng, Nhà nước', 7),
       ('Vụ trưởng, trưởng các cơ quan, đơn vị và tương đương của các cơ quan thuộc Chính phủ', 7),
       ('Ủy viên ban chấp hành đảng bộ tỉnh, thành phố, đảng bộ khối trực thuộc Trung ương', 7),
       ('Vụ trưởng và tương đương của Nhà xuất bản Chính trị quốc gia Sự thật, trưởng cơ quan, đơn vị của Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh',
        7),
       ('Phó Chánh án Toà án nhân dân cấp cao; Phó Viện trưởng Viện Kiểm sát nhân dân cấp cao', 7),
       ('Phó giám đốc các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh', 7),
       ('Vụ trưởng, cục trưởng, trưởng cơ quan, đơn vị và tương đương thuộc tổng cục và tương đương tổng cục', 7),
       ('Giám đốc sở, trưởng cơ quan, ban ngành, tổ chức chính trị - xã hội và tương đương cấp tỉnh', 7),
       ('Bí thư quận, huyện, thị, thành ủy, đảng ủy trực thuộc tỉnh ủy', 7),
       ('Phó tổng thư ký liên hiệp hội ở Trung ương; trưởng ban, đơn vị các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
        7),
       ('Phó chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội không có đảng đoàn)',
        7),
       ('Phó trưởng ban đảng, cơ quan trực thuộc tỉnh ủy, thành ủy', 8),
       ('Phó chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam tỉnh, thành phố', 8),
       ('Thư ký các đồng chí Ủy viên Trung ương Đảng, bộ trưởng và tương đương, bí thư tỉnh ủy, thành ủy, đảng ủy trực thuộc Trung ương',
        8),
       ('Phó vụ trưởng, phó trưởng các cơ quan, đơn vị và tương đương của các cơ quan thuộc Chính phủ', 8),
       ('Phó giám đốc sở, phó trưởng các cơ quan, ban, ngành, tổ chức chính trị - xã hội và tương đương ở cấp tỉnh', 8),
       ('Phó bí thư quận, huyện, thị, thành ủy, đảng ủy trực thuộc tỉnh ủy, thành ủy; chủ tịch Hội đồng nhân dân, Ủy ban nhân dân cấp huyện',
        8),
       ('Ủy viên ủy ban kiểm tra tỉnh ủy, thành ủy trực thuộc Trung ương', 8),
       ('Phó vụ trưởng và tương đương của Nhà xuất bản Chính trị quốc gia Sự thật, phó trưởng các cơ quan, đơn vị của Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh',
        8),
       ('Phó vụ trưởng, phó trưởng các cơ quan, đơn vị thuộc tổng cục và tương đương tổng cục', 8),
       ('Phó trưởng ban, đơn vị các hội quần chúng có đảng đoàn do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
        8),
       ('Trưởng các hội cấp tỉnh được giao biên chế', 8),
       ('Trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương.',
        9),
       ('Chi cục trưởng thuộc Cục.', 9),
       ('Trưởng phòng và tương đương của các ban, cơ quan thuộc tỉnh ủy, thành ủy, văn phòng Hội đồng nhân dân, văn phòng Ủy ban nhân dân tỉnh, thành phố.',
        9),
       ('Ủy viên ban thường vụ huyện, quận, thành, thị ủy, đảng ủy cấp trên cơ sở trực thuộc tỉnh ủy, thành ủy.', 9),
       ('Chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam cấp huyện.', 9),
       ('Phó chủ tịch Hội đồng nhân dân, Ủy ban nhân dân cấp huyện.', 9),
       ('Chi cục trưởng ở địa phương.', 9),
       ('Trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các cơ quan, đơn vị trực thuộc Chính phủ.', 9),
       ('Trưởng phòng, khoa và tương đương trực thuộc các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh; Nhà xuất bản Chính trị quốc gia Sự thật; các cơ quan, đơn vị thuộc Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh.',
        9),
       ('Trưởng phòng và tương đương của sở, các cơ quan ban, ngành, tổ chức chính trị - xã hội cấp tỉnh.', 9),
       ('Ủy viên ban chấp hành đảng bộ huyện, quận, thành, thị xã, đảng bộ cấp trên cơ sở trực thuộc tỉnh ủy, thành ủy.',
        9),
       ('Trưởng phòng và tương đương của các cơ quan, đơn vị trực thuộc tổng cục và tương đương tổng cục.', 9),
       ('Trưởng phòng, ban, cơ quan và tương đương trực thuộc huyện ủy, Ủy ban nhân dân huyện; trưởng các tổ chức chính trị - xã hội và tương đương ở cấp huyện.',
        9),
       ('Phó trưởng các hội cấp tỉnh được giao biên chế.', 9),
       ('Phó trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương.',
        10),
       ('Phó chi cục trưởng thuộc cục.', 10),
       ('Phó trưởng phòng và tương đương của các ban, cơ quan thuộc tỉnh ủy, thành ủy, văn phòng Hội đồng nhân dân, văn phòng Ủy ban nhân dân tỉnh, thành phố.',
        10),
       ('Phó chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam cấp huyện.', 10),
       ('Phó chi cục trưởng ở địa phương.', 10),
       ('Phó trưởng phòng và tương đương của các cơ quan, đơn vị thuộc Chính phủ.', 10),
       ('Phó trưởng phòng và tương đương của các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh; Nhà xuất bản Chính trị quốc gia và các cơ quan, đơn vị thuộc Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh.',
        10),
       ('Phó trưởng phòng và tương đương của sở, các cơ quan, ban ngành, tổ chức chính trị - xã hội cấp tỉnh; phó trưởng các đơn vị sự nghiệp trực thuộc sở, ngành cấp tỉnh.',
        10),
       ('Ủy viên Ủy ban kiểm tra huyện ủy, thị ủy, thành ủy, quận ủy.', 10),
       ('Phó trưởng phòng và tương đương của cơ quan, đơn vị thuộc tổng cục và tương đương tổng cục.', 10),
       ('Ủy viên Thường trực Ủy ban Mặt trận Tổ quốc cấp huyện.', 10),
       ('Phó trưởng phòng và tương đương của cơ quan, đơn vị thuộc các đơn vị trực thuộc hội, liên hiệp hội.', 10),
       ('Phó trưởng phòng, ban, cơ quan và tương đương trực thuộc huyện ủy, Ủy ban nhân dân huyện; phó trưởng các tổ chức chính trị - xã hội và tương đương ở cấp huyện.',
        10),
       ('Bí thư Đảng ủy: Tương đương chức vụ trưởng phòng, ban, cơ quan trực thuộc huyện ủy, Hội đồng nhân dân, Ủy ban nhân dân cấp huyện.',
        11),
       ('Phó bí thư đảng ủy; chủ tịch Hội đồng nhân dân, Ủy ban nhân dân xã, phường, thị trấn: Tương đương chức vụ phó trưởng phòng, ban, cơ quan trực thuộc huyện ủy, Ủy ban nhân dân cấp huyện.',
        11),
       ('Phó chủ tịch Hội đồng nhân dân, Ủy ban nhân dân xã, phường, thị trấn.', 11),
       ('Chủ tịch Ủy ban Mặt trận Tổ quốc và trưởng các tổ chức chính trị - xã hội ở xã, phường, thị trấn.', 11);

-- cap_nhom_chuc_danh_dang
-- INSERT INTO cap_nhom_chuc_danh_dang (id, name, nhom_chuc_danh_dang)
-- values (0, 'Lãnh đạo chủ chốt của Đảng và Nhà nước', 0),
--        (1, 'Lãnh đạo cấp cao của Đảng, Nhà nước và Mặt trận Tổ quốc Việt Nam', 0),
--        (2, 'Các chức danh thuộc diện Bộ Chính trị quản lý', 1),
--        (3, 'Các chức danh diện Ban Bí thư quản lý', 1),
--        (4, 'Tổng cục trưởng và tương đương', 2),
--        (5, 'Phó Tổng cục trưởng và tương đương', 2),
--        (6, 'Vụ trưởng và tương đương', 2),
--        (7, 'Phó vụ trưởng và tương đương', 2),
--        (8, 'Trưởng phòng và tương đương', 2),
--        (9, 'Phó trưởng phòng và tương đương', 2),
--        (10, 'Cán bộ xã, phường, thị trấn', 2);
-- coquan_tochuc_donvi_tuyendung
insert
into coquan_tochuc_donvi (name)
VALUES ('Tòa án nhân dân tối cao'),
       ('Viện kiểm sát nhân dân tối cao'),
       ('Kiểm toán Nhà nước'),
       ('Văn phòng Quốc hội'),
       ('Văn phòng Chủ tịch nước'),
       ('Ủy ban nhân dân cấp tỉnh'),
       ('Cơ quan của Đảng Cộng sản Việt Nam'),
       ('Cơ quan trung ương của Mặt trận Tổ quốc Việt Nam');
-- loai_quan_ham_quan_doi
insert into loai_quan_ham_quan_doi (name)
VALUES ('Sĩ quan'),
       ('Quân nhân chuyên nghiệp'),
       ('Hạ sĩ quan'),
       ('Binh sĩ');
-- cap_bac_loai_quan_ham_quan_doi
insert into cap_bac_loai_quan_ham_quan_doi (name, loai_quan_ham_quan_doi)
VALUES ('Đại tướng', 1),
       ('Thượng tướng', 1),
       ('Trung tướng', 1),
       ('Thiếu tướng', 1),
       ('Đại tá', 1),
       ('Thượng tá', 1),
       ('Trung tá', 1),
       ('Thiếu tá', 1),
       ('Đại úy', 1),
       ('Thượng úy', 1),
       ('Trung úy', 1),
       ('Thiếu úy', 1),
       ('Thượng tá quân nhân chuyên nghiệp', 2),
       ('Trung tá quân nhân chuyên nghiệp', 2),
       ('Thiếu tá quân nhân chuyên nghiệp', 2),
       ('Đại úy quân nhân chuyên nghiệp', 2),
       ('Thượng úy quân nhân chuyên nghiệp', 2),
       ('Trung úy quân nhân chuyên nghiệp', 2),
       ('Thiếu úy quân nhân chuyên nghiệp', 2),
       ('Thượng sĩ', 3),
       ('Trung sĩ', 3),
       ('Hạ sĩ', 3),
       ('Binh nhất', 4),
       ('Binh nhì', 4);
-- bac_ngach_cong_chuc
INSERT INTO bac_ngach_cong_chuc (name)
values ('Khác'),
       ('Nhân viên'),
       ('Chuyên viên cao cấp'),
       ('Chuyên viên chính'),
       ('Chuyên viên'),
       ('Cán sự- Trung cấp');
--bac_ngach_vien_chuc
INSERT INTO bac_ngach_vien_chuc (name)
values ('Ngạch viên chức cấp cao'),
       ('Ngạch viên chức chính'),
       ('Viên chức'),
       ('Ngạch viên chức cán sự'),
       ('Ngạch nhân viên');
--ngach/chuc_danh_nghe_nghiep_cong_chuc
INSERT INTO ngach_cong_chuc (id, name, bac_ngach_cong_chuc, he_so_luong_cong_chuc)
values ('01.001', 'Chuyên viên cao cấp', 1, 1),
       ('04.023', 'Thanh tra viên cao cấp', 1, 1),
       ('06.029', 'Kế toán viên cao cấp', 1, 1),
       ('06.036', 'Kiểm tra viên cao cấp thuế', 1, 1),
       ('08.049', 'Kiểm tra viên cao cấp hải quan', 1, 2),
       ('07.044', 'Kiểm soát viên cao cấp ngân hàng', 1, 2),
       ('06.041', 'Kiểm toán viên cao cấp', 1, 2),
       ('03.299', 'Chấp hành viên cao cấp', 1, 2),
       ('03.230', 'Thẩm tra viên cao cấp', 1, 2),
       ('21.187', 'Kiểm soát viên cao cấp thị trường', 1, 2),
       ('01.002', 'Chuyên viên chính', 1, 2),
       ('04.024', 'Thanh tra viên chính', 1, 3),
       ('06.030', 'Kế toán viên chính', 1, 3),
       ('06.037', 'Kiểm tra viên chính thuế', 1, 3),
       ('08.050', 'Kiểm tra viên chính hải quan', 1, 3),
       ('19.220', 'Kỹ thuật viên bảo quản chính', 1, 4),
       ('07.045', 'Kiểm soát viên chính ngân hàng', 1, 4),
       ('06.042', 'Kiểm toán viên chính', 1, 4),
       ('03.300', 'Chấp hành viên trung cấp', 1, 5),
       ('03.231', 'Thẩm tra viên chính', 1, 5),
       ('21.188', 'Kiểm soát viên chính thị trường', 1, 5),
       ('09.315', 'Kiểm dịch viên chính động vật', 1, 5),
       ('09.318', 'Kiểm dịch viên chính thực vật', 1, 6),
       ('11.081', 'Kiểm soát viên chính đê điều', 1, 6),
       ('10.225', 'Kiểm lâm viên chính', 1, 6),
       ('25.309', 'Kiểm ngư viên chính', 1, 7),
       ('25.312', 'Thuyền viên kiểm ngư chính', 1, 7),
       ('02.006', 'Văn thư chính', 1, 7),
       ('01.003', 'Chuyên viên', 2, 8),
       ('04.025', 'Thanh tra viên', 2, 8),
       ('06.031', 'Kế toán viên', 2, 8),
       ('06.038', 'Kiểm tra viên thuế', 2, 9),
       ('08.051', 'Kiểm tra viên hải quan', 2, 9),
       ('19.221', 'Kỹ thuật viên bảo quản', 2, 9),
       ('07.046', 'Kiểm soát viên ngân hàng', 2, 10),
       ('06.043', 'Kiểm toán viên', 2, 10),
       ('03.301', 'Chấp hành viên sơ cấp', 2, 10),
       ('03.232', 'Thẩm tra viên', 2, 10),
       ('03.302', 'Thư ký thi hành án', 2, 11),
       ('21.189', 'Kiểm soát viên thị trường', 2, 11),
       ('09.316', 'Kiểm dịch viên động vật', 2, 11),
       ('09.319', 'Kiểm dịch viên thực vật', 2, 11),
       ('11.082', 'Kiểm soát viên đê điều', 2, 11),
       ('10.226', 'Kiểm lâm viên', 2, 12),
       ('25.310', 'Kiểm ngư viên', 2, 12),
       ('25.313', 'Thuyền viên kiểm ngư', 2, 12),
       ('02.007', 'Văn thư', 2, 12),
       ('01.004', 'Cán sự', 3, 12),
       ('06.032', 'Kế toán viên trung cấp', 3, 9),
       ('06.039', 'Kiểm tra viên trung cấp thuế', 3, 5),
       ('08.052', 'Kiểm tra viên trung cấp hải quan', 3, 1),
       ('21.190', 'Kiểm soát viên trung cấp thị trường', 3, 2),
       ('19.222', 'Kỹ thuật viên bảo quản trung cấp', 3, 3),
       ('19.223', 'Thủ kho bảo quản', 3, 4),
       ('01.005', 'Nhân viên (văn thư, bảo vệ, lái xe, phục vụ, lễ tân, kỹ thuật và các nhiệm vụ khác…)', 4, 5),
       ('06.040', 'Nhân viên thuế', 4, 5),
       ('08.053', 'Nhân viên hải quan', 4, 7),
       ('07.048', 'Thủ kho ngân hàng', 4, 8),
       ('06.034', 'Thủ quỹ ngân hàng', 4, 5),
       ('07.047', 'Kiểm ngân', 4, 1),
       ('03.303', 'Thư ký trung cấp thi hành án', 4, 2),
       ('09.317', 'Kỹ thuật viên kiểm dịch động vật', 4, 3),
       ('09.320', 'Kỹ thuật viên kiểm dịch thực vật', 4, 4),
       ('11.083', 'Kiểm soát viên trung cấp đê điều', 4, 5),
       ('10.228', 'Kiểm lâm viên trung cấp', 4, 6),
       ('25.311', 'Kiểm ngư viên trung cấp', 4, 7),
       ('25.314', 'Thuyền viên kiểm ngư trung cấp', 4, 8),
       ('02.008', 'Văn thư trung cấp', 4, 9),
       ('06.035', 'Thủ quỹ cơ quan, đơn vị', 4, 10),
       ('19.186', 'Bảo vệ, tuần tra canh gác', 4, 15),
       ('19.224', 'Nhân viên bảo vệ kho dự trữ (Công chức loại C1)', 5, 12);
--ngach/chuc_danh_nghe_nghiep vien chuc
INSERT INTO ngach_vien_chuc (id, name, bac_ngach_vien_chuc, he_so_luong_vien_chuc)
values ('V.07.01.01', 'Giảng viên cao cấp (hạng I)', 1, 1),
       ('V.07.08.20', 'Giảng viên cao đẳng sư phạm cao cấp (hạng I)', 1, 1),
       ('V.09.02.01', 'Giảng viên giáo dục nghề nghiệp cao cấp (hạng I)', 1, 1),
       ('V.09.02.05', 'Giáo viên giáo dục nghề nghiệp hạng I', 1, 1),
       ('V.08.01.01', 'Bác sĩ cao cấp (hạng I)', 1, 1),
       ('V.08.02.04', 'Bác sĩ y học dự phòng cao cấp (hạng I)', 1, 1),
       ('V.08.08.20', 'Dược sĩ cao cấp (hạng I)', 1, 1),
       ('V.08.04.08', 'Y tế công cộng cao cấp (hạng I)', 1, 1),
       ('V.10.03.08', 'Đạo diễn nghệ thuật hạng I', 1, 1),
       ('V.10.04.12', 'Diễn viên hạng I', 1, 1),
       ('V.10.01.01', 'Huấn luyện viên cao cấp (Hạng I)', 1, 1),
       ('V.05.01.01', 'Nghiên cứu viên cao cấp (Hạng I)', 1, 1),
       ('V.05.02.05', 'Kỹ sư cao cấp (Hạng I)', 1, 1),
       ('V11.09.23', 'Âm thanh viên hạng I', 1, 1),
       ('V11.10.27', 'Phát thanh viên hạng I', 1, 1),
       ('V11.11.31', 'Kỹ thuật dựng phim hạng I', 1, 1),
       ('V11.12.35', 'Quay phim hạng I', 1, 1),
       ('V.11.01.01', 'Biên tập viên hạng I', 1, 1),
       ('V.11.02.04', 'Phóng viên hạng I', 1, 1),
       ('V.11.03.07', 'Biên dịch viên hạng I', 1, 1),
       ('V.11.04.10', 'Đạo diễn truyền hình hạng I', 1, 1),
       ('V.04.01.01', 'Kiến trúc sư Hạng I', 1, 1),
       ('V.04.02.04', 'Thẩm kế viên hạng I', 1, 1),
       ('V.10.08.25', 'Họa sĩ hạng I', 1, 1),
       ('V.07.01.02', 'Giảng viên chính (hạng II)', 1, 1),
       ('V.07.07.17', 'Giáo viên dự bị đại học hạng I', 1, 1),
       ('V.07.07.18', 'Giáo viên dự bị đại học hạng II', 1, 1),
       ('V.07.08.21', 'Giảng viên cao đẳng sư phạm cao cấp (hạng II)', 1, 1),
       ('V.09.02.02', 'Giảng viên giáo dục nghề nghiệp chính (hạng II)', 1, 1),
       ('V.09.02.06', 'Giáo viên giáo dục nghề nghiệp hạng II', 1, 1),
       ('V.07.05.13', 'Giáo viên trung học phổ thông (hạng I)', 1, 1),
       ('V.07.05.14', 'Giáo viên trung học phổ thông (hạng II)', 1, 1),
       ('V.07.04.30', 'Giáo viên trung học cơ sở hạng I', 1, 1),
       ('V.07.04.31', 'Giáo viên trung học cơ sở hạng II', 1, 1),
       ('V.07.03.27', 'Giáo viên tiểu học hạng I', 1, 1),
       ('V.07.03.28', 'Giáo viên tiểu học hạng II', 1, 1),
       ('V.07.02.24', 'Giáo viên mầm non hạng I', 1, 1),
       ('V.08.02.05', 'Bác sĩ y học dự phòng chính (hạng II)', 1, 1),
       ('V.08.01.02', 'Bác sĩ chính (hạng II)', 1, 1),
       ('V.08.08.21', 'Dược sĩ chính (hạng II)', 1, 1),
       ('V.08.05.11', 'Điều dưỡng hạng II', 1, 1),
       ('V.08.06.14', 'Hộ sinh hạng II', 1, 1),
       ('V.08.07.17', 'Kỹ thuật y hạng II', 1, 1),
       ('V.08.04.09', 'Y tế công cộng chính (hạng II)', 1, 1),
       ('V.09.03.01', 'Kiểm định viên chính kỹ thuật an toàn lao động (hạng II)', 1, 1),
       ('V.09.04.01', 'Công tác xã hội viên chính (hạng II)', 1, 1),
       ('V.10.03.09', 'Đạo diễn nghệ thuật hạng II', 1, 1),
       ('V.10.04.13', 'Diễn viên hạng II', 1, 1),
       ('V.10.05.16', 'Di sản viên hạng II', 1, 1),
       ('V.10.01.02', 'Huấn luyện viên chính (hạng II)', 1, 1),
       ('V.05.01.02', 'Nghiên cứu viên chính (Hạng II)', 1, 1),
       ('V.05.02.06', 'Kỹ sư chính (Hạng II)', 1, 1),
       ('V11.09.24', 'Âm thanh viên hạng II', 1, 1),
       ('V11.10.28', 'Phát thanh viên hạng II', 1, 1),
       ('V11.11.32', 'Kỹ thuật dựng phim hạng II', 1, 1),
       ('V11.12.36', 'Quay phim hạng II', 1, 1),
       ('V.11.01.02', 'Biên tập viên hạng II', 1, 1),
       ('V.11.02.05', 'Phóng viên hạng II', 1, 1),
       ('V.11.03.08', 'Biên dịch viên hạng II', 1, 1),
       ('V.11.04.11', 'Đạo diễn truyền hình hạng II', 1, 1),
       ('V.04.01.02', 'Kiến trúc sư Hạng II', 1, 1),
       ('V.04.02.05', 'Thẩm kế viên hạng II', 1, 1),
       ('V.10.08.26', 'Họa sĩ hạng II', 1, 1),
       ('V.03.04.10', 'Chẩn đoán viên bệnh động vật hạng II', 1, 1),
       ('V.03.05.13', 'Kiểm tra viên vệ sinh thú y hạng II', 1, 1),
       ('V.03.06.16', 'Kiểm nghiệm viên thuốc thú y hạng II', 1, 1),
       ('V.03.07.19', 'Kiểm nghiệm viên chăn nuôi hạng II', 1, 1),
       ('V.03.01.01', 'Bảo vệ viên bảo vệ thực vật hạng II', 1, 1),
       ('V.03.02.04', 'Giám định viên thuốc bảo vệ thực vật hạng II', 1, 1),
       ('V.03.03.07', 'Kiểm nghiệm viên cây trồng hạng II', 1, 1),
       ('V.06.03.07', 'Dự báo viên khí tượng thủy văn hạng II', 1, 1),
       ('V.10.06.19', 'Phương pháp viên hạng II', 1, 1),
       ('V.10.07.22', 'Hướng dẫn viên văn hóa hạng II', 1, 1),
       ('V.01.02.01', 'Lưu trữ viên chính (hạng II)', 1, 1),
       ('02.006', 'Văn thư chính', 1, 1),
       ('V.10.02.05', 'Thư viện viên hạng II', 1, 1),
       ('V.06.05.13', 'Quan trắc viên tài nguyên môi trường hạng II', 1, 1),
       ('V.07.01.03', 'Giảng viên (hạng III)', 2, 2),
       ('V.07.01.23', 'Trợ giảng (Hạng III)', 2, 2),
       ('V.07.07.19', 'Giáo viên dự bị đại học hạng III', 2, 2),
       ('V.07.08.22', 'Giảng viên cao đẳng sư phạm cao cấp (hạng III)', 2, 2),
       ('V.09.02.03', 'Giảng viên giáo dục nghề nghiệp lý thuyết (hạng III)', 2, 2),
       ('V.09.02.07', 'Giáo viên giáo dục nghề nghiệp lý thuyết hạng III', 2, 2),
       ('V.07.05.15', 'Giáo viên trung học phổ thông hạng III', 2, 2),
       ('V.07.04.32', 'Giáo viên trung học cơ sở hạng III', 2, 2),
       ('V.07.03.29', 'Giáo viên tiểu học hạng III', 2, 2),
       ('07.02.25', 'Giáo viên mầm non hạng II', 2, 2),
       ('V.08.01.03', 'Bác sĩ (hạng III)', 2, 2),
       ('V.08.02.06', 'Bác sĩ y học dự phòng (hạng III)', 2, 2),
       ('V.08.08.22', 'Dược sĩ (hạng III)', 2, 2),
       ('V.08.05.12', 'Điều dưỡng hạng III', 2, 2),
       ('V.08.06.15', 'Hộ sinh hạng III', 2, 2),
       ('V.08.07.18', 'Kỹ thuật y hạng III', 2, 2),
       ('V.08.04.10', 'Y tế công cộng (hạng III)', 2, 2),
       ('V.09.03.02', 'Kiểm định viên kỹ thuật an toàn lao động (hạng III)', 2, 2),
       ('V.09.04.02', 'Công tác xã hội viên (hạng III)', 2, 2),
       ('V.10.03.10', 'Đạo diễn nghệ thuật hạng III', 2, 2),
       ('V.10.04.14', 'Diễn viên hạng III', 2, 2),
       ('V.10.05.17', 'Di sản viên hạng III', 2, 2),
       ('V.10.01.03', 'Huấn luyện viên (hạng III)', 2, 2),
       ('V.05.01.03', 'Nghiên cứu viên (Hạng III)', 2, 2),
       ('V.05.02.07', 'Kỹ sư (Hạng III)', 2, 2),
       ('V11.09.25', 'Âm thanh viên hạng III', 2, 2),
       ('V11.10.29', 'Phát thanh viên hạng III', 2, 2),
       ('V11.11.33', 'Kỹ thuật dựng phim hạng III', 2, 2),
       ('V11.12.37', 'Quay phim hạng III', 2, 2),
       ('V.11.01.03', 'Biên tập viên hạng III', 2, 2),
       ('V.11.02.06', 'Phóng viên hạng III', 2, 2),
       ('V.11.03.09', 'Biên dịch viên hạng III', 2, 2),
       ('V.11.04.12', 'Đạo diễn truyền hình hạng III', 2, 2),
       ('V.04.01.03', 'Kiến trúc sư Hạng III', 2, 2),
       ('V.04.02.06', 'Thẩm kế viên hạng III', 2, 2),
       ('V.10.08.27', 'Họa sĩ hạng III', 2, 2),
       ('V.03.04.11', 'Chẩn đoán viên bệnh động vật hạng III', 2, 2),
       ('V.03.05.14', 'Kiểm tra viên vệ sinh thú y hạng III', 2, 2),
       ('V.03.06.15', 'Kiểm nghiệm viên thuốc thú y hạng III', 2, 2),
       ('V.03.07.20', 'Kiểm nghiệm viên chăn nuôi hạng III', 2, 2),
       ('V.03.01.02', 'Bảo vệ viên bảo vệ thực vật hạng III', 2, 2),
       ('V.03.02.05', 'Giám định viên thuốc bảo vệ thực vật hạng III', 2, 2),
       ('V.03.03.08', 'Kiểm nghiệm viên cây trồng hạng III', 2, 2),
       ('V.06.03.08', 'Dự báo viên khí tượng thủy văn hạng III', 2, 2),
       ('V.10.06.20', 'Phương pháp viên hạng III', 2, 2),
       ('V.10.07.23', 'Hướng dẫn viên văn hóa hạng III', 2, 2),
       ('V.01.02.02', 'Lưu trữ viên (hạng II)', 2, 2),
       ('02.007', 'Văn thư', 2, 2),
       ('V.10.02.06', 'Thư viện viên hạng III', 2, 2),
       ('V.06.05.14', 'Quan trắc viên tài nguyên môi trường hạng III', 2, 2);
-- moi_quan_he
INSERT into moi_quan_he (name)
VALUES ('Mẹ ruột'),
       ('Mẹ nuôi'),
       ('Ba ruột'),
       ('Ba nuôi'),
       ('Anh ruột'),
       ('Anh nuôi'),
       ('Chị ruột'),
       ('Chị nuôi'),
       ('Em nuôi'),
       ('Em ruột'),
       ('Vợ'),
       ('Con ruột'),
       ('Con nuôi');
-- bo_coquan
INSERT INTO bo_coquan (name)
VALUES ('Bộ Quốc phòng'),
       ('Bộ Công an'),
       ('Bộ Ngoại giao'),
       ('Bộ Xây dựng'),
       ('Bộ Tư pháp'),
       ('Bộ Tài chính'),
       ('Bộ Công Thương'),
       ('Bộ Giao thông Vận tải'),
       ('Bộ Lao động – Thương binh và Xã hội'),
       ('Bộ Thông tin và Truyền thông'),
       ('Bộ Văn hóa, Thể thao và Du lịch'),
       ('Bộ Giáo dục và Đào tạo'),
       ('Bộ Nông nghiệp và Phát triển nông thôn'),
       ('Bộ Kế hoạch và Đầu tư'),
       ('Bộ Y tế'),
       ('Bộ Nội vụ'),
       ('Bộ Khoa học và Công nghệ'),
       ('Bộ Tài nguyên và Môi trường'),
       ('Ủy ban Dân tộc'),
       ('Thanh tra Chính phủ'),
       ('Ngân hàng Nhà nước'),
       ('Văn phòng Chính phủ'),
       ('Viện Hàn lâm Khoa học Xã hội Việt Nam'),
       ('Viện Hàn lâm Khoa học và Công nghệ Việt Nam'),
       ('Thông tấn xã Việt Nam'),
       ('Đài Tiếng nói Việt Nam'),
       ('Đài Truyền hình Việt Nam'),
       ('Bảo hiểm Xã hội Việt Nam'),
       ('Ban Quản lý Lăng Chủ tịch Hồ Chí Minh'),
       ('Uỷ ban Quản lý vốn Nhà nước tại doanh nghiệp'),
       ('Uỷ ban Giám sát Tài chính Quốc gia');
-- don_vi
INSERT INTO don_vi (name, bo_coquan)
VALUES ('Tổng cục Thi hành án dân sự', 5),
       ('Văn phòng Bộ', 5),
       ('Văn phòng Đảng - Đoàn thể', 5),
       ('Thanh tra Bộ', 5),
       ('Vụ Các vấn đề chung về xây dựng pháp luật', 5),
       ('Vụ Pháp luật hình sự - hành chính', 5),
       ('Vụ Pháp luật dân sự - kinh tế', 5),
       ('Vụ Pháp luật quốc tế', 5),
       ('Vụ Con nuôi', 5),
       ('Vụ Tổ chức cán bộ', 5),
       ('Vụ Hợp tác quốc tế', 5),
       ('Cục Kế hoạch - Tài chính', 5),
       ('Cục Phổ biến, giáo dục pháp luật', 5),
       ('Cục Kiểm tra văn bản quy phạm pháp luật', 5),
       ('Cục Hộ tịch, quốc tịch, chứng thực', 5),
       ('Cục Trợ giúp pháp lý', 5),
       ('Cục Đăng ký quốc gia giao dịch bảo đảm', 5),
       ('Cục Bồi thường nhà nước', 5),
       ('Cục Bổ trợ tư pháp', 5),
       ('Cục Công nghệ thông tin', 5),
       ('Cục Quản lý xử lý vi phạm hành chính và theo dõi thi hành pháp luật', 5),
       ('Trung tâm Lý lịch tư pháp quốc gia', 5),
       ('Viện Chiến lược và Khoa học Pháp lý', 5),
       ('Học viện Tư pháp', 5),
       ('Tạp chí Dân chủ và Pháp luật', 5),
       ('Báo Pháp luật Việt Nam', 5),
       ('Nhà xuất bản Tư pháp', 5),
       ('Trường Đại học Luật Hà Nội', 5),
       ('Trường Cao đẳng Luật miền Nam', 5),
       ('Trường Cao đẳng Luật miền Trung', 5),
       ('Trường Cao đẳng Luật miền Bắc', 5);

-- loai_so_yeu_ly_lich_chitiet
INSERT into loai_so_yeu_ly_lich_chitiet (name)
VALUES ('QUÁ TRÌNH ĐÀO TẠO, BỒI DƯỠNG'),
       ('TÓM TẮT QUÁ TRÌNH CÔNG TÁC'),
       ('ĐẶC ĐIỂM LỊCH SỬ BẢN THÂN'),
       ('KHEN THƯỞNG, KỶ LUẬT'),
       ('QUAN HỆ GIA ĐÌNH'),
       ('HOÀN CẢNH KINH TẾ GIA ĐÌNH'),
       ('NHẬN XÉT, ĐÁNH GIÁ CỦA CƠ QUAN, TỔ CHỨC, ĐƠN VỊ SỬ DỤNG');

