package com.example.runkeeper.workshopone.lab2.trading;


import com.example.runkeeper.workshopone.lab2.dto.Stock;

import java.math.BigDecimal;

public class MarketWatcher implements IMarketWatcher
{
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
