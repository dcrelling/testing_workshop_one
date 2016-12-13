package com.example.runkeeper.workshopone.modules;

import com.example.runkeeper.workshopone.lab2.trading.StockBroker;
import com.example.runkeeper.workshopone.main.Main;

import dagger.Component;

/**
 * Created by davidcrelling on 12/4/16.
 */

@Component(modules = StockBrokerModule.class)
public interface StockBrokerComponent
{
    StockBroker initialize();
}
