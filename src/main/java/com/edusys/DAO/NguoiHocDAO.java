
package com.edusys.DAO;

import com.edusys.Entity.NguoiHoc;
import com.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String>{
    final String INSERT_SQL = "INSERT INTO NGUOIHOC (MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) values (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NguoiHoc set HoTen =?,NgaySinh =?,GioiTinh = ?,DienThoai=?,Email=?,GhiChu=?,MaNV=?,NgayDK=?  where MaNH = ?";
    final String DELETE_SQL = "DELETE FROM NguoiHoc where MaNH =?";
    final String SELECT_ALL_SQL = "SELECT * FROM NguoiHoc";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc where MaNH = ?";
    final String SELECT_NOT_IN_COURSE_SQL = "SELECT * FROM NguoiHoc where HoTen like ? and MaNH not in(select MaNH from HOCVIEN where MaKH=?)";
    final String SELECT_BY_KEY_WORD_SQL = "SELECT * FROM NguoiHoc where HoTen like ?";
    @Override
    public void insert(NguoiHoc entity) {
     JdbcHelper.update(INSERT_SQL, entity.getMaNH(),entity.getHoTen(),entity.getNgaySinh(),entity.isGioiTinh(), entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(), entity.getNgayDK());    
    }

    @Override
    public void update(NguoiHoc entity) {
     JdbcHelper.update(UPDATE_SQL, entity.getHoTen(),entity.getNgaySinh(),entity.isGioiTinh(), entity.getDienThoai(),entity.getEmail(),entity.getGhiChu(),entity.getMaNV(), entity.getNgayDK(),entity.getMaNH());
    }

    @Override
    public void delete(String id) {
     JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectById(String id) {
List<NguoiHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDK(rs.getDate("NgayDK"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<NguoiHoc> selectNotInCourse(int maKH, String keyword) {
        return selectBySql(SELECT_NOT_IN_COURSE_SQL, "%" + keyword+ "%",maKH);
    }

    public List<NguoiHoc> selectByKeyWord(String keyword) {
        String sql = "Select * from NguoiHoc where HoTen like ?";
        return selectBySql(SELECT_BY_KEY_WORD_SQL, "%"+keyword+"%");
    }
}
