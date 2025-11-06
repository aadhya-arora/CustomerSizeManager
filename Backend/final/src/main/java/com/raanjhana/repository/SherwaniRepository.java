package com.raanjhana.repository;

import com.raanjhana.model.SherwaniSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SherwaniRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<SherwaniSize> mapper = (rs, rowNum) -> {
        SherwaniSize s = new SherwaniSize();
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

     public int save(SherwaniSize s) {
        String sql = "INSERT INTO sherwani_sizes (phone_number, length, chest, gap, waist, hips, shoulder, sleeve, bicep, elbow, cuff, cb, neck) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, s.getPhoneNumber(), s.getLength(), s.getChest(), s.getGap(), s.getWaist(), s.getHips(),
                s.getShoulder(), s.getSleeve(), s.getBicep(), s.getElbow(), s.getCuff(), s.getCb(), s.getNeck());
    }

    public SherwaniSize findByPhone(String phone) {
        String sql = "SELECT * FROM sherwani_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone).stream().findFirst().orElse(null);
    }

    public int update(SherwaniSize s) {
        String sql = "UPDATE sherwani_sizes SET length=?, chest=?, gap=?, waist=?, hips=?, shoulder=?, sleeve=?, bicep=?, elbow=?, cuff=?, cb=?, neck=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, s.getLength(), s.getChest(), s.getGap(), s.getWaist(), s.getHips(), s.getShoulder(),
                s.getSleeve(), s.getBicep(), s.getElbow(), s.getCuff(), s.getCb(), s.getNeck(), s.getPhoneNumber());
    }

    public int delete(String phone) {
        String sql = "DELETE FROM sherwani_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
}
