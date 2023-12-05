package com.example.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServicelmpl implements MarketService {
    @Autowired
    MarketDAO marketDAO;

    @Override
    public int insertMarket(MarketVO vo) {
        return marketDAO.insertMarket(vo);
    }

    @Override
    public int deleteMarket(int id) {
        return marketDAO.deleteMarket(id);
    }

    @Override
    public int updateMarket(MarketVO vo) {
        return marketDAO.updateMarket(vo);
    }

    @Override
    public MarketVO getMarket(int id) {
        return marketDAO.getMarket(id);
    }

    @Override
    public List<MarketVO> getMarketList() {
        return marketDAO.getMarketList();
    }
}
