package com.example.runkeeper.workshopone.lab2.trading;


import com.example.runkeeper.workshopone.lab2.dto.Stock;

import java.math.BigDecimal;

public class MarketWatcher implements IMarketWatcher
{
    private static final String TAG = MarketWatcher.class.getName();
    private String name;

    public MarketWatcher(String name)
    {
        this.name = name;
    }

    @Override
    public Stock getQuote(String symbol)
    {
        return buildStock(symbol);
    }

    private Stock buildStock(String symbol)
    {
        return new Stock("PYPL", "PayPal Holding Inc", new BigDecimal(39.55));

    }
}
