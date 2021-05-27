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
