package com.example;

import com.example.market.MarketVO;
import com.example.user.UserVO;

public class MarketUserVO {
    private MarketVO market;
    private UserVO user;

    public MarketVO getMarket() {
        return market;
    }

    public void setMarket(MarketVO market) {
        this.market = market;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }
}

