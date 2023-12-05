package com.example.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MarketDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertMarket(MarketVO vo){
        String sql = "insert into market (title, writer, price, content, howPurchase) values("
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getWriter() + "',"
                + "'" + vo.getPrice() + "',"
                + "'" + vo.getContent() + "',"
                + "'" + vo.getHowPurchase() + "')";
        return jdbcTemplate.update(sql);
    }

    public int deleteMarket(int id){
        String sql = "delete from market where id = " + id;
        return jdbcTemplate.update(sql);
    }

    public int updateMarket(MarketVO vo){
        String sql = "update market set title = '" + vo.getTitle() + "',"
                + "title='" + vo.getTitle() + "',"
                + "writer='" +vo.getWriter() + "',"
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
            vo.setWriter(rs.getString("writer"));
            vo.setPrice(rs.getInt("price"));
            vo.setContent(rs.getString("content"));
            vo.setHowPurchase(rs.getString("howPurchase"));
            vo.setCreateTime(rs.getDate("createTime"));
            vo.setExposeTime(rs.getDate("exposeTime"));
            return vo;
        }
    }

    public MarketVO getMarket(int id){
        String sql = "select * from market where id=" + id;
        return jdbcTemplate.queryForObject(sql, new MarketRowMapper());
    }

    public List<MarketVO> getMarketList(){
        String sql = "select * from market order by createtime desc";
        return jdbcTemplate.query(sql, new MarketRowMapper());
    }
}
