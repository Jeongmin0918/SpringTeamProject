package com.example.market;

import com.example.MarketUserVO;
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
    public MarketUserVO getMarket(int id) {
        return marketDAO.getMarket(id);
    }

    @Override
    public List<MarketUserVO> getMarketList() {
//        List<MarketVO> list = marketDAO.getMarketList();
//        for(MarketVO item : list){
//            System.out.println(item.getTitle() + " " + item.getViewCnt());
//        }
//        return list;
        return marketDAO.getMarketList();
    }

    @Override
    public int updateViewCnt(int id) {
        return marketDAO.updateViewCnt(id);
    }
//    @Override
//    public void updateExposeTime(int id) {
//    }
}
