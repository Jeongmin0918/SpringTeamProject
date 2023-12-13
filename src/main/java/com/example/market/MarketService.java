package com.example.market;

import com.example.MarketUserVO;

import java.util.List;

public interface MarketService {
    public int insertMarket(MarketVO vo);
    public int deleteMarket(int id);
    public int updateMarket(MarketVO vo);
    public MarketUserVO getMarket(int id);
    public List<MarketUserVO> getMarketList();
    public int updateViewCnt(int id);
    public int updateExposeTime(int id);
}
