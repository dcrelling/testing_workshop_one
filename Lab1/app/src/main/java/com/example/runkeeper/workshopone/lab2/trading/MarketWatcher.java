package com.example.runkeeper.workshopone.lab2.trading;


import com.example.runkeeper.workshopone.lab2.dto.Stock;

public interface MarketWatcher
{
    Stock getQuote(String symbol);
}
