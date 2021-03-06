
Create database QL		
go

Use QL
go
Create table USERS(
TaiKhoan nvarchar(50),
MatKhau nvarchar(50),
ChucNang nvarchar(50)
)
go
Create table SINHVIEN(
MaSV nvarchar(30),
HoTen nvarchar(50),
NgaySinh nvarchar(50),
GioiTinh bit,
DiaChi nvarchar(50),
constraint PK_SINHVIEN primary key (MaSV),
)
go
Create table BANGDIEM
(
MaSV nvarchar(30),
DiemTA float,
DiemTH float,
DiemGDQP float,
DiemTB float,
constraint PK_BANGDIEM primary key (MaSV),
Constraint FK_BANGDIEM_SINHVIEN foreign key (MaSV) references SINHVIEN(MASV),
)
go

----------------Nhập liệu---------------------

--Users
Insert into Users
values('ANV','123','GV')

Insert into Users
values('BNV','123','DT')

Insert into Users
values('CNV','123','GV')

Insert into Users
values('DNV','123','DT')

Insert into Users
values('ENV','123','GV')

--SinhVien
Insert into SINHVIEN
values('PH001',N'Nguyễn Văn A','01-01-1997',1,N'Hà Nội')

Insert into SINHVIEN
values('PH002',N'Nguyễn Văn B','07-01-1997',1,N'Thái Nguyên')

Insert into SINHVIEN
values('PH003',N'Nguyễn Văn C','02-01-1997',0,N'Hà Nam')

Insert into SINHVIEN
values('PH004',N'Nguyễn Văn D','03-01-1997',1,N'Ninh Bình')

Insert into SINHVIEN
values('PH005',N'Nguyễn Văn E','04-01-1997',0,N'Nam Định')

Insert into SINHVIEN
values('PH006',N'Nguyễn Văn F','05-01-1997',1,N'Thái Bình')

--BANGDIEM

Insert into BANGDIEM
values('PH001',7,8.5,8.5,8)


Insert into BANGDIEM
values('PH002',5,9,8,7.3)


Insert into BANGDIEM
values('PH003',0,5,8,4.3)


Insert into BANGDIEM
values('PH004',9,7,10,8.7)


Insert into BANGDIEM
values('PH005',7,5,6,6)


----select bảng
select * from Users
select * from SinhVien
select * from BangDiem