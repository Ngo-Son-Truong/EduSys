
package com.edusys.DAO;

import com.edusys.Entity.HocVien;
import com.edusys.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class HocVienDAO extends EduSysDAO<HocVien, Integer> {

    final String INSERT_SQL = "INSERT INTO HOCVIEN(MaKH,MaNH,Diem) values(?,?,?)";
    final String UPDATE_SQL = "UPDATE HOCVIEN set MaKH = ?,MaNH = ?,Diem = ? where MaHV = ?";
    final String DELETE_SQL = "DELETE FROM HOCVIEN where MaHV =?";
    final String SELECT_ALL_SQL = "SELECT * FROM HOCVIEN";
    final String SELECT_BY_ID_SQL = "SELECT * FROM HOCVIEN where MaHV = ?";
    final String SELECT_BY_MA_KH_SQL = "SELECT * FROM HOCVIEN where MaKH = ?";
    final String SELECT_BY_KEYWORD_SQL = "select * from HocVien join NguoiHoc on NguoiHoc.MaNH = HocVien.MaNH where HoTen like ?";

    @Override
    public void insert(HocVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaKH(), entity.getMaNH(), entity.getDiem(), entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getDouble("Diem"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<HocVien> selectByKhoaHoc(int maKH) {
        return selectBySql(SELECT_BY_MA_KH_SQL, maKH);
    }
    public List<HocVien> selectByKeyWord(String key){
        String sql = "select * from HocVien join NguoiHoc on NguoiHoc.MaNH = HocVien.MaNHwhere HoTen like ?";
        return selectBySql(SELECT_BY_KEYWORD_SQL ,"%"+key+"%");
    }
}
