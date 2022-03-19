fun main() {

    println(agoToText(60))
    println(agoToText(100))
    println(agoToText(4241))
    println(agoToText(95500))
    println(agoToText(197800))
    println(agoToText(460985))
}

fun agoToText(secAgo: Int): String {
    return when (secAgo) {
        in 0..60 -> "Был(а) только что "
        in 61..60 * 60 -> "Был(а) ${minuteTextVersion(secAgo)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "Был(а) ${hourTextVersion(secAgo)} назад"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "Был(а) сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "Был(а) вчера"
        else -> "Был(а) давно"
    }

}

fun minuteTextVersion(secAgo: Int): String {
    val minsAgo = secAgo / 60
    var minuteTextVersion = ""
    when {
        minsAgo in 2..4 || (minsAgo % 10) in 2..4 -> minuteTextVersion = "$minsAgo минуты"
        minsAgo == 1 || ((minsAgo % 10) == 1 && minsAgo != 11 && minsAgo % 100 != 11) -> minuteTextVersion =
            "$minsAgo минуту"
        else -> minuteTextVersion = "$minsAgo минут"

    }
    return minuteTextVersion
}

fun hourTextVersion(secAgo: Int): String {
    val hoursAgo = secAgo / 60 / 60
    var hourTextVersion = ""
    hourTextVersion = when {
        hoursAgo in 2..4 || (hoursAgo % 10) in 2..4 -> "$hoursAgo часа"
        hoursAgo == 1 || ((hoursAgo % 10) == 1 && hoursAgo != 11 && hoursAgo % 100 != 11) -> "$hoursAgo час"
        else -> "$hoursAgo часов"
    }
    return hourTextVersion
}