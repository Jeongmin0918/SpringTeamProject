package com.example.market;

import java.util.List;

public interface MarketService {
    public int insertMarket(MarketVO vo);
    public int deleteMarket(int id);
    public int updateMarket(MarketVO vo);
    public MarketVO getMarket(int id);
    public List<MarketVO> getMarketList();
}
