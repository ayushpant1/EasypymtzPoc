package com.example.junitdemo.mockitopackage

class Portfolio {
    var stockService: StockService? = null
    var stocks: List<Stock>? = null
    val marketValue: Double
        get() {
            var marketValue = 0.0
            for (stock in stocks!!) {
                marketValue += stockService!!.getPrice(stock) * stock.quantity
            }
            return marketValue
        }
}