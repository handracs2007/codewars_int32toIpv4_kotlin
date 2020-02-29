import kotlin.math.pow

fun String.toBase10(): String {
    var number = 0
    number = this.reversed().foldIndexed(number) { index, sum, element ->
        sum + ((element - '0') * 2.0.pow(index.toDouble()).toInt())
    }

    return number.toString().reversed()
}

fun longToIP(ip: UInt): String {
    var base2 = ip.toString(2)
    var finalIp = ""

    while (base2.isNotEmpty()) {
        val temp = base2.takeLast(8)
        val el = temp.toBase10()

        finalIp += "$el."

        base2 = if (base2.length - 8 >= 0) {
            base2.take(base2.length - 8)
        } else {
            ""
        }
    }

    while (finalIp.filter { it == '.' }.count() != 4)
        finalIp += "0."

    return finalIp.substring(0, finalIp.length - 1).reversed()
}

fun main() {
    println(longToIP(2154959208u))
    println(longToIP(0u))
    println(longToIP(2149583361u))
}