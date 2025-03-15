package com.masrietech.shoppingapp

data class CounterModel(var count:Int)

class CounterRepository{
    private  var _counter=CounterModel(0)
    fun getCount()=_counter
    fun incrementCount(){
        _counter.count++
    }
    fun decrementCount(){
        _counter.count--
    }
}