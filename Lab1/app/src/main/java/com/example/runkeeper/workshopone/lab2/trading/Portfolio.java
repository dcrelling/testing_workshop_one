package com.example.runkeeper.workshopone.lab2.trading;

import com.example.runkeeper.workshopone.lab2.dto.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Portfolio implements IPortfolio
{
    private Map<String, List<Stock>> stockMap = new HashMap<String, List<Stock>>();

    @Override
    public void buy(Stock stock)
    {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if (stocks != null)
        {
            stocks.add(stock);
        }
        else
        {
            stocks = new ArrayList<Stock>();
            stocks.add(stock);
            stockMap.put(stock.getSymbol(), stocks);
        }
    }

    @Override
    public void sell(Stock stock, int quantity)
    {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if (stocks == null)
        {
            throw new IllegalStateException(stock.getSymbol() + " not bought");
        }

        if (stocks.size() < quantity)
        {
            quantity = stocks.size();
        }

        for (int i = quantity - 1; i >= 0; i--)
        {
            stocks.remove(i);
        }
    }

    @Override
    public BigDecimal getAvgPrice(Stock stock)
    {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        BigDecimal avgPrice = BigDecimal.ZERO;
        if (stocks != null)
        {
            for (Stock aStock : stocks)
            {
                avgPrice = avgPrice.add(aStock.getPrice());
            }

            avgPrice = avgPrice.divide(new BigDecimal(stocks.size()));
        }

        return avgPrice;
    }

    @Override
    public BigDecimal getCurrentValue()
    {
        BigDecimal avgPrice = BigDecimal.ZERO;
        for (String stockId : stockMap.keySet())
        {
            for (Stock stock : stockMap.get(stockId))
            {
                avgPrice = avgPrice.add(stock.getPrice());
            }
        }

        return avgPrice;
    }

}
