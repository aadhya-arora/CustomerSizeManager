package com.raanjhana.repository;

import com.raanjhana.model.KurtaSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class KurtaRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<KurtaSize> mapper = (rs, rowNum) -> {
        KurtaSize k = new KurtaSize();
        k.setPhoneNumber(rs.getString("phone_number"));
        k.setLength(rs.getDouble("length"));
        k.setChest(rs.getDouble("chest"));
        k.setGap(rs.getDouble("gap"));
        k.setWaist(rs.getDouble("waist"));
        k.setHips(rs.getDouble("hips"));
        k.setShoulder(rs.getDouble("shoulder"));
        k.setSleeve(rs.getDouble("sleeve"));
        k.setBicep(rs.getDouble("bicep"));
        k.setElbow(rs.getDouble("elbow"));
        k.setCuff(rs.getDouble("cuff"));
        k.setCb(rs.getDouble("cb"));
        k.setNeck(rs.getDouble("neck"));
        return k;
    };

    public int save(KurtaSize k) {
        String sql = "INSERT INTO kurta_sizes (phone_number, length, chest, gap, waist, hips, shoulder, sleeve, bicep, elbow, cuff, cb, neck) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, k.getPhoneNumber(), k.getLength(), k.getChest(), k.getGap(), k.getWaist(), k.getHips(),
                k.getShoulder(), k.getSleeve(), k.getBicep(), k.getElbow(), k.getCuff(), k.getCb(), k.getNeck());
    }

    public KurtaSize findByPhone(String phone) {
        String sql = "SELECT * FROM kurta_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone).stream().findFirst().orElse(null);
    }

    public int update(KurtaSize k) {
        String sql = "UPDATE kurta_sizes SET length=?, chest=?, gap=?, waist=?, hips=?, shoulder=?, sleeve=?, bicep=?, elbow=?, cuff=?, cb=?, neck=? WHERE phone_number=?";
        return jdbcTemplate.update(sql, k.getLength(), k.getChest(), k.getGap(), k.getWaist(), k.getHips(), k.getShoulder(),
                k.getSleeve(), k.getBicep(), k.getElbow(), k.getCuff(), k.getCb(), k.getNeck(), k.getPhoneNumber());
    }

    public int delete(String phone) {
        String sql = "DELETE FROM kurta_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
}
