fun main() {
    val number = inputNumber()
    println("Sum of digits of number: ${sumDigits(number)}")
}

// ввод числа (рекурсия, пока число некорректно)
fun inputNumber(): Int {
    print("Enter the number:> ")
    val number = readLine()

    return if (number == null)
        inputNumber()
    else
        try {
            number.toInt()
        }
        catch (e: NumberFormatException) {
            inputNumber()
        }
}

// сумма цифр числа
fun sumDigits(number: Int): Int =
    if (number / 10 == 0)
        number % 10
    else
        sumDigits(number / 10) + (number % 10)