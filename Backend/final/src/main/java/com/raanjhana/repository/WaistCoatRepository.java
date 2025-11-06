package com.raanjhana.repository;

import com.raanjhana.model.WaistCoatSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WaistCoatRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<WaistCoatSize> mapper = (rs, rowNum) -> {
        WaistCoatSize w = new WaistCoatSize();
        w.setPhoneNumber(rs.getString("phone_number"));
        w.setLength(rs.getDouble("length"));
        w.setChest(rs.getDouble("chest"));
        w.setGap(rs.getDouble("gap"));
        w.setWaist(rs.getDouble("waist"));
        w.setHips(rs.getDouble("hips"));
        w.setShoulder(rs.getDouble("shoulder"));
        w.setNeck(rs.getDouble("neck"));
        return w;
    };

    public int save(WaistCoatSize w) {
        String sql = "INSERT INTO waistcoat_sizes (phone_number, length, chest, gap, waist, hips, shoulder, neck) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, w.getPhoneNumber(), w.getLength(), w.getChest(), w.getGap(), w.getWaist(),
                w.getHips(), w.getShoulder(), w.getNeck());
    }

    public WaistCoatSize findByPhone(String phone) {
        String sql = "SELECT * FROM waistcoat_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone).stream().findFirst().orElse(null);
    }

    public int update(WaistCoatSize w) {
        String sql = "UPDATE waistcoat_sizes SET length=?, chest=?, gap=?, waist=?, hips=?, shoulder=?, neck=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, w.getLength(), w.getChest(), w.getGap(), w.getWaist(), w.getHips(),
                w.getShoulder(), w.getNeck(), w.getPhoneNumber());
    }

    public int delete(String phone) {
        String sql = "DELETE FROM waistcoat_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
    
}
