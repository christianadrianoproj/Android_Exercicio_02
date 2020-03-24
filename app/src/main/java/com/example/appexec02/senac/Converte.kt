package com.example.appexec02.senac;

class Converte (val temperatura: Double,
           val tipoConversao: TemperaturaEnum) {

    fun converter() : Double {
        if (tipoConversao == TemperaturaEnum.Fahrenheit) {
            return (temperatura * 1.8) + 32
        }
        else {
            return (temperatura - 32) / 1.8;
        }
    }

}

enum class TemperaturaEnum {
    Celsios, Fahrenheit

}