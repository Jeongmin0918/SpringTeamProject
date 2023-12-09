package com.example.market;

import com.example.MarketUserVO;
import com.example.user.UserVO;
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
        String sql = "insert into market (title, price, content, howPurchase) values("
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getPrice() + "',"
                + "'" + vo.getContent() + "',"
                + "'" + vo.getHowPurchase() + "')";
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

    class MarketUserRowMapper implements RowMapper<MarketUserVO> {
        @Override
        public MarketUserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            MarketUserVO muvo = new MarketUserVO();

            MarketVO mvo = new MarketVO();
            UserVO uvo = new UserVO();

            // MarketVO properties
            mvo.setId(rs.getInt("id"));
            mvo.setTitle(rs.getString("title"));
            mvo.setPrice(rs.getInt("price"));
            mvo.setContent(rs.getString("content"));
            mvo.setHowPurchase(rs.getString("howPurchase"));
            mvo.setViewCnt(rs.getInt("viewCnt"));
            mvo.setCreateTime(rs.getTimestamp("createTime").toLocalDateTime());
            mvo.setExposeTime(rs.getTimestamp("exposeTime").toLocalDateTime());

            // UserVO properties
            uvo.setEmail(rs.getString("email"));
            uvo.setPassword(rs.getString("password"));

            // Set MarketVO and UserVO to MarketUserVO
            muvo.setMarket(mvo);
            muvo.setUser(uvo);

            return muvo;
        }
    }


    public MarketUserVO getMarket(int id){
        String sql = "SELECT * from market INNER JOIN users ON users.user_id = market.user_id where market.id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new MarketUserRowMapper());
    }

    public List<MarketUserVO> getMarketList(){
        String sql = "SELECT * from market INNER JOIN users ON users.user_id = market.user_id order by exposeTime desc;";
        return jdbcTemplate.query(sql, new MarketUserRowMapper());
    }

    public int updateViewCnt(int id) {
        String sql = "update market set viewCnt = viewCnt + 1 where id = ?";
        return jdbcTemplate.update(sql, id);
    }

//    public MarketVO updateExposeTime(int id) {
//        String sql = "UPDATE market SET exposeTime = NOW() WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new MarketRowMapper());
//    }
}
