package com.example.runkeeper.workshopone.main;


import com.example.runkeeper.workshopone.lab2.trading.IStockBroker;
import com.example.runkeeper.workshopone.modules.DaggerStockBrokerComponent;
import com.example.runkeeper.workshopone.modules.StockBrokerModule;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello Runkeeper!");
        IStockBroker stockBroker = DaggerStockBrokerComponent.builder()
                .stockBrokerModule(new StockBrokerModule())
                .build().initialize();
    }
}
