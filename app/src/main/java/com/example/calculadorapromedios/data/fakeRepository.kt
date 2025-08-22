package com.example.calculadorapromedios.data

class fakeRepository {
    fun guardarPromedio(promedio: Double): String{
        //simula guardar en base de datos
        return "Promedio ${String.format("%.2f", promedio)} guardado exitosamente"
    }
}