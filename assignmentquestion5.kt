fun main() {
    print(" enter number you want to change in words NB: number should be in range 1 to 999999 ")
    val yourvalue = readlnOrNull()?.toIntOrNull()

    if (yourvalue != null) {
        val wordofyourvalue = numberconvetorfun(yourvalue)
        println(" $yourvalue: In in word is : $wordofyourvalue")
    } else {
        println("Entered number is invalid")
    }
}

fun numberconvetorfun(yourvalue: Int): String {
    val units = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = arrayOf("", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    return when {
        yourvalue == 0 -> "Zero"
        yourvalue < 0 -> "Minus " + numberconvetorfun(-yourvalue)
        yourvalue < 10 -> units[yourvalue]
        yourvalue in 11..19 -> teens[yourvalue - 10]
        yourvalue < 100 -> tens[yourvalue / 10] + if (yourvalue % 10 != 0) " " + units[yourvalue % 10] else ""
        yourvalue < 1000 -> units[yourvalue / 100] + " Hundred" + if (yourvalue % 100 != 0) " and " + numberconvetorfun(yourvalue % 100) else ""
        yourvalue < 1000000 -> numberconvetorfun(yourvalue / 1000) + " Thousand" + if (yourvalue % 1000 != 0) " " + numberconvetorfun(yourvalue % 1000) else ""
        else -> "please verify your number range : Range should be (1-999999)"
    }
}
