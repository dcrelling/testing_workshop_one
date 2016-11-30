package com.example.runkeeper.workshopone.lab2.trading;

import com.example.runkeeper.workshopone.lab2.dto.Stock;

/**
 * Created by davidcrelling on 11/30/16.
 */

public interface IStockBroker
{
     void perform(Portfolio portfolio, Stock stock);

}
