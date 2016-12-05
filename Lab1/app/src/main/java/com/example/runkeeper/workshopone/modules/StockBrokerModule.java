package com.example.runkeeper.workshopone.modules;

import com.example.runkeeper.workshopone.lab2.trading.IMarketWatcher;
import com.example.runkeeper.workshopone.lab2.trading.MarketWatcher;

import dagger.Module;
import dagger.Provides;


@Module
public class StockBrokerModule
{

    @Provides
    public IMarketWatcher provideMarketWatcher()
    {
        return new MarketWatcher();
    }
}
