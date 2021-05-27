import kotlin.math.abs

fun main() {
    val number = inputNumber()

//    // task 1
//    println("Sum of digits (recursion up): ${sumDigitsUp(number)}")
//
//    // task 2
//    println("Sum of digits (tail recursion): ${sumDigitsTail(number)}")
//
//    // task 3.1
//    println("Mult of digits (recursion up): ${multDigitsUp(number)}")
//
//    // task 3.1
//    println("Mult of digits (tail recursion): ${multDigitsTail(number)}")
//
//    // task 3.2
//    println("Min digit (recursion up): ${minDigitUp(number)}")
//
//    // task 3.2
//    println("Min digit (tail recursion): ${minDigitTail(number)}")
//
//    // task 3.3
//    println("Max digit (recursion up): ${maxDigitUp(number)}")
//
//    // task 3.3
//    println("Max digit (tail recursion): ${maxDigitTail(number)}")
//
//    // task 4
//    println("\nSum of digits: ${calculate(number, ::sumDigitsUp)}")
//    println("Mult of digits: ${calculate(number, ::multDigitsUp)}")
//    println("Min digit: ${calculate(number, ::minDigitUp)}")
//    println("Max digit: ${calculate(number, ::maxDigitUp)}")
//
//    // task 6: проверить функцию task 5
//
//    // 1-ый и 2-ой пример: считает сумму цифр, если каждая из них больше 5
//    calculateWithCondition(number, ::sumDigitsTail, ::checkDigits)
//    calculateWithCondition(number, ::sumDigitsTail, ::checkDigits, 0)
//
//    // 3-ий пример: считает произведение цифр, если каждая из них больше 5
//    calculateWithCondition(number, ::multDigitsTail, ::checkDigits, 1)
//
//    // task 7: переписать task 13.8 с использованием
//    // только хвоствой рекурсии и тела-выражения
//    try {
//        // task 7.1
//        // println("Max prime divisor of number: ${maxPrimeDivisor(number)}")
//
//        // task 7.2
//        // println("Mult of digits not divisible by 5: ${multDigitsNotDivBy(number,5)}")
//
//        // task 7.3
//        // println("\nMax odd not prime divisor of number: ${maxOddNotPrimeDiv(number)}")
//        // println("Mult of digits: ${multDigitsUp(number)}")
//        // println("\nTheir GCD: ${task7_3(number)}")
//    }
//    catch(e: ArithmeticException) {
//        println("\nError: ${e.message}!")
//    }
    // task 8
    launchMenu(number)
}

// ввод числа
fun inputNumber(): Int {
    print("Enter the number:> ")
    val number = readLine()!!.toString()

    return try {
        number.toInt()
    }
    catch (e: NumberFormatException) {
        inputNumber()
    }
}

// task 1: сумма цифр числа (рекурсия вверх)
fun sumDigitsUp(number: Int): Int =
    if (number / 10 == 0)
        abs(number % 10)
    else
        sumDigitsUp(number / 10) + abs(number % 10)

// task 2: сумма цифр числа (хвостовая рекурсия)
fun sumDigitsTail(number: Int, sum: Int): Int =
    if (number / 10 == 0)
        sum + abs(number % 10)
    else
        sumDigitsTail(number / 10, sum + abs(number % 10))

fun sumDigitsTail(number: Int): Int =
    sumDigitsTail(number, 0)

// task 3.1: проиведение цифр числа (рекурсия вверх)
fun multDigitsUp(number: Int): Int =
    if (number / 10 == 0)
        abs(number % 10)
    else
        multDigitsUp(number / 10) * abs(number % 10)

// task 3.1: произведение цифр числа (хвостовая рекурсия)
fun multDigitsTail(number: Int, mult: Int): Int =
    if (number / 10 == 0)
        mult * abs(number % 10)
    else
        multDigitsTail(number / 10, mult * abs(number % 10))

fun multDigitsTail(number: Int): Int =
    multDigitsTail(number, 1)

// task 3.2: минимальная цифра числа (рекурсия вверх)
fun minDigitUp(number: Int): Int {
    val newNumber = number / 10
    val digit = abs(number % 10)

    return if (newNumber != 0) {
        val min = minDigitUp(newNumber)
        if (digit < min)
            digit
        else min
    }
    else digit
}

// task 3.2: минимальная цифра числа (хвостовая рекурсия)
fun minDigitTail(number: Int): Int {
    fun minDigitTail(number: Int, min: Int): Int {
        val newNumber = number / 10
        val digit = abs(number % 10)

        val newMin =
            if (digit < min)
                digit
            else min

        return if (newNumber != 0)
            minDigitTail(newNumber, newMin)
        else newMin
    }
    return minDigitTail(number, 10)
}