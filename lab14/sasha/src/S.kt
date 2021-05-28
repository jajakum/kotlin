import kotlin.math.pow

fun main(){
    //menu()
//println(fact(15))
    print(solution())
}

fun enterNumb():Int = readLine()!!.toInt()

fun task6(num: Int) = println("Сумма цифр $num = ${sumOfDigits(num)}")

//task 7
fun sumOfDigits(num: Int):Int {
    var sum = 0
    var numb=num

    while(numb!=0) {
        sum += numb% 10
        numb /= 10
    }
    return sum
}

fun maxDigit(num: Int): Int{
    var numb=num
    var max=numb%10

    while(numb!=0) {
        if(numb%10 > max) max=numb%10
        numb /= 10
    }
    return max
}

fun minDigit(num: Int): Int{
    var numb=num
    var min=numb%10

    while(numb!=0) {
        if(numb%10 < min) min=numb%10
        numb /= 10
    }
    return min
}

fun multDigit(num: Int): Int{
    var numb=num/10
    var mult=num%10

    while(numb!=0) {
        mult*=numb%10
        numb /= 10
    }
    return mult
}

//task 8.1
fun sumOfEvenNumbNotPrime(x: Int):Int{
    var n=1
    var sum=0

    while(n<x){
        if(n%2==0 && gcd(n,x)>1) sum++
        n++
    }
    return sum
}
fun gcd(a: Int, b: Int): Int =
    when {
        (a == b) -> a
        (a > b) -> gcd(a - b, b)
        else -> gcd(a, b - a)
    }

//task 8.2
fun maxDigitNotDiv3(num: Int): Int{
    var numb = num
    var max = 0
    var digit: Int

    while(numb != 0) {
        digit = numb % 10
        if(digit > max && digit % 3 != 0) max = digit
        numb /= 10
    }
    return max
}

//task 8.3
fun task8_3(num: Int): Int = maxDigitNotPrimeNotDivBy(num)*sumOfDigitsLess5(num)

fun maxDigitNotPrimeNotDivBy(num: Int): Int{
    var numb=1
    var max=0
    while(numb < num){
        if(gcd(num,numb) > 1 && numb % smallestDiv(num) != 0) max=numb
        numb++
    }
    return max
}

fun smallestDiv(num: Int): Int{
    var numb=num
    var d=numb
    var res:Int=d

    while(d>1)
    { if(numb % d ==0)
        res=d
        d--
    }
    return res
}

fun sumOfDigitsLess5(num: Int): Int{
    var sum = 0
    var numb=num

    while(numb!=0) {
        if(numb % 10 < 5)
            sum += numb% 10

        numb /= 10
    }
    return sum
}

//task 9
fun menu(){
    println("МЕНЮ:")
    println("1)Сумма цифр числа")
    println("2)Максимальная цифра числа")
    println("3)Минимальная цифра числа")
    println("4)Произведение цифр числа")
    println("5)Количество четных чисел, не взаимно простых с данным")
    println("6)Максимальная цифра числа, не делящаяся на 3")
    println("7)Произведение максимального числа, не взаимно простого\n" +
            "с данным, не делящегося на наименьший делитель исходно числа, и\n" +
            "суммы цифр числа, меньших 5")
    println("8)Выйти")

    print("Введите номер метода:")
    var i=enterNumb()

    var num: Int=0
    if(i!=8) {
        print("Введите число:")
        num=enterNumb()
    }

    when (i) {
        1 -> println("Результат: ${sumOfDigits(num)}")
        2 -> println("Результат: ${maxDigit(num)}")
        3 -> println("Результат: ${minDigit(num)}")
        4 -> println("Результат: ${multDigit(num)}")
        5 -> println("Результат: ${sumOfEvenNumbNotPrime(num)}")
        6 -> println("Результат: ${maxDigitNotDiv3(num)}")
        7 -> println("Результат: ${task8_3(num)}")
        8 -> return
        else -> println("Ошибка! Неправильный ввод!!!")
    }

    readLine()
    menu()
}

//task 10.20
fun task10_20()= sumOfDigits(fact(15))

fun fact(numb: Int): Int  =
    when(numb)
    {
        0 -> 1
        else -> numb*fact(numb-1)
    }


//task 10.40
fun solution():Int {
    var res = 1
    var i=0
    while(i<7){
        res*=getDigit(10.0.pow(i).toInt())
        i++
    }
    return res
}

fun getDigit(n:Int):Int {
    var r=0//верхняя граница предыд.блока
    var s = 0//верхняя граница текущего блока
    var k = 0//текущий блок

    while (s < n) {
        r = s
        s+= 9 * 10.0.pow(k++).toInt() * k
    }
    var h = n - r - 1
    var t: Int= 10.0.pow(k - 1).toInt() + h / k
    var p: Int = h % k

    return  digOfNumb(reverseNum(t),p+1)
}

fun digOfNumb(num: Int, div: Int): Int =
    when(div) {
        1 -> num%10
        else -> digOfNumb(num/10,div-1)
    }

fun reverseNum(num1: Int, num2: Int = 0): Int =
    when(num1){
        0 -> num2
        else -> reverseNum(num1/10,num2*10+num1%10)
    }
