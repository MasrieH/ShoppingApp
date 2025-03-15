package com.masrietech.shoppingapp

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterVM:ViewModel() {
    private val _repository:CounterRepository=CounterRepository()
    private val _count= mutableIntStateOf(_repository.getCount().count)
    val count: MutableState<Int> = _count //Expose count as Immutable
    fun increment()
    {
       _repository.incrementCount()
    _count.value=_repository.getCount().count
    }
    fun decrement()
    {
        _repository.decrementCount()
        _count.value=_repository.getCount().count
    }
}