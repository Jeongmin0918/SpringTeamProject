package com.example.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MarketDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertMarket(MarketVO vo){
        String sql = "insert into market (title, price, content, howPurchase) values(?,?,?,?)";
        return jdbcTemplate.update(sql);
    }

    public int deleteMarket(int id){
        String sql = "delete from market where id = ?";
        return jdbcTemplate.update(sql);
    }

    public int updateMarket(MarketVO vo){
        String sql = "update market set title = '" + vo.getTitle() + "',"
                + "title='" + vo.getTitle() + "',"
                + "price='" +vo.getPrice() + "',"
                + "content='" +vo.getContent() + "',"
                + "howPurchase='" +vo.getHowPurchase() +
                "' where id=" + vo.getId();
        return jdbcTemplate.update(sql);
    }

    class MarketRowMapper implements RowMapper<MarketVO> {
        @Override
        public MarketVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MarketVO vo = new MarketVO();
            vo.setId(rs.getInt("id"));
            vo.setTitle(rs.getString("title"));
//            vo.setEmail(rs.getString("email"));
            vo.setPrice(rs.getInt("price"));
            vo.setContent(rs.getString("content"));
            vo.setHowPurchase(rs.getString("howPurchase"));
            Timestamp createTimeStamp = rs.getTimestamp("createTime");
            LocalDateTime createTime = createTimeStamp.toLocalDateTime();
            vo.setCreateTime(createTime);
            Timestamp exposeTimeStamp = rs.getTimestamp("exposeTime");
            LocalDateTime exposeTime = exposeTimeStamp.toLocalDateTime();
            vo.setExposeTime(exposeTime);
            return vo;
        }
    }

    public MarketVO getMarket(int id){
        String sql = "select * from market where id= ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new MarketRowMapper());
    }

    public List<MarketVO> getMarketList(){
        String sql = "select * from market order by createtime desc";
        return jdbcTemplate.query(sql, new MarketRowMapper());
    }

    public int updateViewCnt(int id) {
        String sql = "update market set viewCnt = viewCnt + 1 where id = ?";
//        jdbcTemplate.update(sql, id);
//        return getMarket(id).getViewCnt();
        return jdbcTemplate.update(sql, id);
    }

    public void updateExposeTime(int id) {
        String sql = "update market set exposeTime = now() where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
