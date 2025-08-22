package com.example.calculadorapromedios.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadorapromedios.data.fakeRepository

class MainViewModel : ViewModel (){

    private val repository= fakeRepository()
    private val _promedio = MutableLiveData<Double>()

    val promedio: LiveData<Double> get ()=_promedio

    private val _guardarMensaje= MutableLiveData<String>()

    val guardarMensaje: LiveData<String> get() =_guardarMensaje

    fun calcularPromedio(n1: Double, n2: Double, n3: Double){
        val result=(n1+n2+n3) / 3
        _promedio.value= result
        _guardarMensaje.value= repository.guardarPromedio(result)
    }
}