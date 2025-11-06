package com.raanjhana.repository;

import com.raanjhana.model.ShirtSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ShirtRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<ShirtSize> mapper = (rs, rowNum) -> {
        ShirtSize s = new ShirtSize();
        s.setPhoneNumber(rs.getString("phone_number"));
        s.setLength(rs.getDouble("length"));
        s.setChest(rs.getDouble("chest"));
        s.setGap(rs.getDouble("gap"));
        s.setWaist(rs.getDouble("waist"));
        s.setHips(rs.getDouble("hips"));
        s.setShoulder(rs.getDouble("shoulder"));
        s.setSleeve(rs.getDouble("sleeve"));
        s.setBicep(rs.getDouble("bicep"));
        s.setElbow(rs.getDouble("elbow"));
        s.setCuff(rs.getDouble("cuff"));
        s.setCb(rs.getDouble("cb"));
        s.setNeck(rs.getDouble("neck"));
        return s;
    };

    public int save(ShirtSize s) {
        String sql = "INSERT INTO shirt_sizes (phone_number, length, chest, gap, waist, hips, shoulder, sleeve, bicep, elbow, cuff, cb, neck) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, s.getPhoneNumber(), s.getLength(), s.getChest(), s.getGap(), s.getWaist(), s.getHips(),
                s.getShoulder(), s.getSleeve(), s.getBicep(), s.getElbow(), s.getCuff(), s.getCb(), s.getNeck());
    }

    public ShirtSize findByPhone(String phone) {
        String sql = "SELECT * FROM shirt_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone).stream().findFirst().orElse(null);
    }

    public int update(ShirtSize s) {
        String sql = "UPDATE shirt_sizes SET length=?, chest=?, gap=?, waist=?, hips=?, shoulder=?, sleeve=?, bicep=?, elbow=?, cuff=?, cb=?, neck=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, s.getLength(), s.getChest(), s.getGap(), s.getWaist(), s.getHips(), s.getShoulder(),
                s.getSleeve(), s.getBicep(), s.getElbow(), s.getCuff(), s.getCb(), s.getNeck(), s.getPhoneNumber());
    }

    public int delete(String phone) {
        String sql = "DELETE FROM shirt_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
}
