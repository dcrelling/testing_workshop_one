package com.example.runkeeper.workshopone.lab2.trading;

import com.example.runkeeper.workshopone.lab2.dto.Stock;

import java.math.BigDecimal;

/**
 * Created by davidcrelling on 11/30/16.
 */

public interface IPortfolio
{
    void buy(Stock stock);

    void sell(Stock stock, int quantity);

    BigDecimal getAvgPrice(Stock stock);

    BigDecimal getCurrentValue();
}
