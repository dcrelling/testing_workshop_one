package com.example.runkeeper.workshopone.lab2.trading;

import com.example.runkeeper.workshopone.lab2.dto.Stock;

import java.math.BigDecimal;


public class StockBroker implements IStockBroker
{
    private final static BigDecimal LIMIT = new BigDecimal("0.10");
    private final IMarketWatcher market;

    public StockBroker(IMarketWatcher market)
    {
        this.market = market;
    }

    @Override
    public void perform(IPortfolio portfolio, Stock stock)
    {
        Stock liveStock = market.getQuote(stock.getSymbol());
        BigDecimal avgPrice = portfolio.getAvgPrice(stock);
        BigDecimal priceGained = liveStock.getPrice().subtract(avgPrice);
        BigDecimal percentGain = priceGained.divide(avgPrice);
        if (percentGain.compareTo(LIMIT) > 0)
        {
            portfolio.sell(stock, 10);
        }
        else if (percentGain.compareTo(LIMIT) < 0)
        {
            portfolio.buy(stock);
        }
    }

}
