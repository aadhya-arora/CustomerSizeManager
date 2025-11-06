package com.raanjhana.repository;

import com.raanjhana.model.CoatSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CoatRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<CoatSize> mapper = (rs, rowNum) -> {
        CoatSize c = new CoatSize();
        c.setPhoneNumber(rs.getString("phone_number"));
        c.setLength(rs.getDouble("length"));
        c.setChest(rs.getDouble("chest"));
        c.setGap(rs.getDouble("gap"));
        c.setWaist(rs.getDouble("waist"));
        c.setHips(rs.getDouble("hips"));
        c.setShoulder(rs.getDouble("shoulder"));
        c.setSleeve(rs.getDouble("sleeve"));
        c.setBicep(rs.getDouble("bicep"));
        c.setElbow(rs.getDouble("elbow"));
        c.setCuff(rs.getDouble("cuff"));
        c.setCb(rs.getDouble("cb"));
        c.setNeck(rs.getDouble("neck"));
        return c;
    };

    public int save(CoatSize c) {
        String sql = "INSERT INTO coat_sizes (phone_number, length, chest, gap, waist, hips, shoulder, sleeve, bicep, elbow, cuff, cb, neck) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, c.getPhoneNumber(), c.getLength(), c.getChest(), c.getGap(), c.getWaist(), c.getHips(),
                c.getShoulder(), c.getSleeve(), c.getBicep(), c.getElbow(), c.getCuff(), c.getCb(), c.getNeck());
    }

    public CoatSize findByPhone(String phone) {
        String sql = "SELECT * FROM coat_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone).stream().findFirst().orElse(null);
    }

    public int update(CoatSize c) {
        String sql = "UPDATE coat_sizes SET length=?, chest=?, gap=?, waist=?, hips=?, shoulder=?, sleeve=?, bicep=?, elbow=?, cuff=?, cb=?, neck=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, c.getLength(), c.getChest(), c.getGap(), c.getWaist(), c.getHips(), c.getShoulder(),
                c.getSleeve(), c.getBicep(), c.getElbow(), c.getCuff(), c.getCb(), c.getNeck(), c.getPhoneNumber());
    }

    public int delete(String phone) {
        String sql = "DELETE FROM coat_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
}
