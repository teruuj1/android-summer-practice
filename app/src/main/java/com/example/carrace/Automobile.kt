package com.example.carrace

import android.widget.TextView
import kotlin.random.Random

// класс Автомобиль
open class Automobile(
    val brand: String,
    val model: String,
    val releaseYear: Int,
    val color: String,
    val registrationNumber: String
) {
    fun displayInfo() {
        println("Автомобиль: $brand $model, Год выпуска: $releaseYear, Цвет: $color, Регистрационный номер: $registrationNumber")
    }
}

// Производный класс
class Crossover(
    brand: String,
    model: String,
    yearOfManufacture: Int,
    color: String,
    registrationNumber: String,
    val driveType: String,
    val enginePower: Int
) : Automobile(brand, model, yearOfManufacture, color, registrationNumber) {
    //
}

// Класс Строитель для Автомобиля
class AutoBuilder(val brand: String) {
    private var model: String = ""
    private var releaseYear: Int = 0
    private var color: String = ""
    private var registrationNumber: String = ""
    private var driveType: String = ""
    private var enginePower: Int = 0

    fun setModel(model: String) = apply { this.model = model }
    fun setYearOfManufacture(releaseYear: Int) = apply { this.releaseYear = releaseYear }
    fun setColor(color: String) = apply { this.color = color }
    fun setRegistrationNumber(registrationNumber: String) = apply { this.registrationNumber = registrationNumber }
    fun setDriveType(driveType: String) = apply { this.driveType = driveType }
    fun setEnginePower(enginePower: Int) = apply { this.enginePower = enginePower }

    fun build(): Automobile {
        return Automobile(brand, model, releaseYear, color, registrationNumber)
    }
}

fun createRandomAutomobile(): Automobile {
    val brands = listOf("Toyota", "Ford", "BMW", "Mercedes")
    val models = listOf("Sedan", "Coupe", "Hatchback", "SUV")
    val colors = listOf("черный", "белый", "красный", "синий")
    val driveTypes = listOf("передний", "задний", "полный")

    val brand = brands[Random.nextInt(brands.size)]
    val model = models[Random.nextInt(models.size)]
    val yearOfManufacture = Random.nextInt(1990, 2024)
    val color = colors[Random.nextInt(colors.size)]
    val registrationNumber = "A" + Random.nextInt(100, 999).toString() + "BC"
    val driveType = driveTypes[Random.nextInt(driveTypes.size)]
    val enginePower = Random.nextInt(100, 300)

    return AutoBuilder(brand)
        .setModel(model)
        .setYearOfManufacture(yearOfManufacture)
        .setColor(color)
        .setRegistrationNumber(registrationNumber)
        .setDriveType(driveType)
        .setEnginePower(enginePower)
        .build()
}

//сравнения\гонки
fun organizeRaces(automobiles: List<Automobile>, resultTextView: TextView) {
    var competitors = automobiles.toMutableList()
    var round = 1
    var resultText = StringBuilder()

    while (competitors.size > 1) {
        resultText.append("--- Раунд $round ---\n")
        val nextRoundCompetitors = mutableListOf<Automobile>()
        competitors.shuffle()

        for (i in 0 until competitors.size step 2) {
            if (i == competitors.size - 1) {
                resultText.append("--- ${competitors[i].brand} - Нет пары, следующий круг\n")
                nextRoundCompetitors.add(competitors[i])
                continue
            }

            val auto1 = competitors[i]
            val auto2 = competitors[i + 1]
            val winner = if (auto1.releaseYear > auto2.releaseYear) auto1 else auto2

            resultText.append("--- Гонка между ${auto1.brand} и ${auto2.brand}, Победитель ${winner.brand}\n")
            nextRoundCompetitors.add(winner)
        }

        competitors = nextRoundCompetitors
        round++
    }
    val ultimateWinner = competitors.first()
    resultText.append("\n!!!Победитель гонок: ${ultimateWinner.brand}!!!")
    resultTextView.text = resultText.toString()
}
