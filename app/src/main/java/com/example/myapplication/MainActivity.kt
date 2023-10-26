package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.DynamicLayout

class MainActivity : AppCompatActivity() {
    enum class Status {
        SOLTERO,
        CASADO,
        DIVORCIADO,
        VIUDO;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables
        var myFirstVariable = "Hola Mundo!"
        println(myFirstVariable)
        var mySecondVariable = myFirstVariable
        myFirstVariable = "Aplicaciones móviles"
        println(myFirstVariable)

        // Constantes
        val myFirstConstant = "Francisco González"
        println(myFirstConstant)
        val mySecondConstant = myFirstConstant
        // mySecondConstant = "Francisco Xavier González Flores" --> Esto no se puede realizar
        println(mySecondConstant)

        // String
        val myString = "Hola Android"
        val myString2 = "Desarrollo de plataformas móviles"
        val myString3 = myString + " " + myString2
        println(myString3)

        // Enteros (byte, short, int, long)
        val myInt = 1
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        // Decimales (Float, Double)
        val myFloat = 1.5f
        val myDouble = 1.5
        val myDouble2 = 2.6
        val myDouble3 = 1
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        // Boolean (Bool)
        val myBool = true
        val myBool2 = false
        println(myBool == myBool2)
        println(myBool && myBool2)

        //If-Else
        val myAge = 21
        if (myAge < 1) {
            println("Estas por nacer")
        } else if (myAge > 18) {
            println("Eres mayor de edad")
        } else {
            println("Eres menor de edad")
        }

        // When
        val country = "Ecuador"
        when (country) {
            "Ecuador", "Colombia", "Peru" -> {
                println("lenguage Spanish")
            }

            else -> {
                println("No se conoce el idioma")
            }
        }

        // Array
        val name = "Francisco"
        val lastname = "González"
        val age = "21"
        val university = "UTPL"

        val myArray = arrayListOf<String>()
        myArray.add(name)
        myArray.add(lastname)
        myArray.add(age)
        myArray.add(university)
        println(myArray)
        myArray.addAll(listOf("Hola", "Curso de android"))
        println(myArray)

        myArray.removeAt(4)
        println(myArray)

        myArray.forEach {
            println(it)
        }

        println(myArray.first())
        println(myArray.last())
        println(myArray.sort())
        println(myArray.count())
        myArray.clear()
        println(myArray.count())

        // Maps
        var myMap: Map<String, Int> = mapOf()

        myMap = mutableMapOf("Francisco" to 1, "Gerald" to 2, "Ramiro" to 3, "4" to 4)
        println(myMap)

        myMap["Carlos"] = 5
        myMap.put("Abigail", 6)
        println(myMap["Abigail"])

        myMap.remove("Ramiro")
        println(myMap)


        // ----- Práctica -----
        // Ejercicio 1: Algoritmo de la cédula
        val ci = arrayListOf<Int>(1, 7, 5, 1, 6, 6, 6, 5, 7, 7)
        val validator = arrayListOf<Int>(2, 1, 2, 1, 2, 1, 2, 1, 2)
        var total = 0

        for (i in 0..validator.size - 1) {
            val result = ci[i] * validator[i]
            if (result > 9) {
                val first = result.toString().first().toString().toInt()
                val last = result.toString().last().toString().toInt()
                total += first + last
            } else {
                total += result
            }
        }

        if ((40 - total) == ci.last()) {
            println("Es válida")
        } else {
            println("No es válida")
        }


        // Ejercicio 2: Array de 20 valores, listar los pares e impares
        val numbers = arrayListOf<Int>(2, 5, 7, 15, 96, 41, 5, 8, 10, 14, 27, 35, 62, 45, 24, 14, 42, 15, 63)
        val pars = numbers.filter { it % 2 == 0 }
        val impars = numbers.filter { it % 2 != 0 }

        println("Pares: $pars")
        println("Impares: $impars")


        // Ejercicio 3: Cinco grupos de datos con los siguientes valores (Persona)[Nombre, Cédula, Edad, Estado Civil]
        val people = mapOf(
            1 to mapOf(
                "Name" to "Darbie Betham",
                "Id" to "9160216573",
                "Age" to 38,
                "Status" to Status.SOLTERO
            ),
            2 to mapOf(
                "Name" to "Wanda Fairbank",
                "Id" to "5578716091",
                "Age" to 61,
                "Status" to Status.CASADO
            ),
            3 to mapOf(
                "Name" to "Bella Camus",
                "Id" to "8668600893",
                "Age" to 36,
                "Status" to Status.VIUDO
            ),
            4 to mapOf(
                "Name" to "Durward Beveridge",
                "Id" to "1152115219",
                "Age" to 76,
                "Status" to Status.SOLTERO
            ),
            5 to mapOf(
                "Name" to "Nickolas Antonognoli",
                "Id" to "3264556561",
                "Age" to 47,
                "Status" to Status.CASADO
            ),
        )

        for (person in people.values){
            val name = person["Name"] as String
            val age = person["Age"] as Int
            val status = person["Status"] as Status

            if (age > 60 && status == Status.SOLTERO) println("$name es mayor de 60 años")
        }
    }
}