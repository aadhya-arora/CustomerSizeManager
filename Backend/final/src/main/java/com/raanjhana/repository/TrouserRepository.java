package com.raanjhana.repository;

import com.raanjhana.model.TrouserSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TrouserRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

     private final RowMapper<TrouserSize> mapper = (rs, rowNum) -> {
        TrouserSize t = new TrouserSize();
        t.setPhoneNumber(rs.getString("phone_number"));
        t.setPleats(rs.getString("pleats"));
        t.setLength(rs.getDouble("length"));
        t.setWaist(rs.getDouble("waist"));
        t.setIl(rs.getDouble("il"));
        t.setHips(rs.getDouble("hips"));
        t.setThigh(rs.getDouble("thigh"));
        t.setR(rs.getDouble("r"));
        t.setKnee(rs.getDouble("knee"));
        t.setCalf(rs.getDouble("calf"));
        t.setBottom(rs.getDouble("bottom"));
        return t;
    };

     public int save(TrouserSize t) {
        String sql = "INSERT INTO trouser_sizes (phone_number, pleats, length, waist, il, hips, thigh, r, knee, calf, bottom) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                t.getPhoneNumber(), t.getPleats(), t.getLength(), t.getWaist(),
                t.getIl(), t.getHips(), t.getThigh(), t.getR(), t.getKnee(), t.getCalf(), t.getBottom());
    }

     public TrouserSize findByPhone(String phone) {
        String sql = "SELECT * FROM trouser_sizes WHERE phone_number = ?";
        return jdbcTemplate.query(sql, mapper, phone)
                .stream().findFirst().orElse(null);
    }

     public int update(TrouserSize t) {
        String sql = "UPDATE trouser_sizes SET pleats=?, length=?, waist=?, il=?, hips=?, thigh=?, r=?, knee=?, calf=?, bottom=? WHERE phone_number=?";
        return jdbcTemplate.update(sql,
                t.getPleats(), t.getLength(), t.getWaist(), t.getIl(), t.getHips(),
                t.getThigh(), t.getR(), t.getKnee(), t.getCalf(), t.getBottom(), t.getPhoneNumber());
    }
    
    public int delete(String phone) {
        String sql = "DELETE FROM trouser_sizes WHERE phone_number=?";
        return jdbcTemplate.update(sql, phone);
    }
}
