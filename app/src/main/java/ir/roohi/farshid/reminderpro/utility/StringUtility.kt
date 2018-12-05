package ir.roohi.farshid.reminderpro.utility

import android.content.Context
import ir.roohi.farshid.reminderpro.R
import java.lang.StringBuilder
import java.text.DecimalFormat
import java.util.*

/**
 * Created by Farshid Roohi.
 * ReminderPro | Copyrights 11/29/18.
 */

fun randomName(len: Int = 20): String {
    val stringBuilder = StringBuilder(len)
    val character = "A1B2C3D4E5F6G7H8I9G0KLMNOP"
    var i = 0
    while (i < len) {
        stringBuilder.append(character[Random().nextInt(character.length)])
        i++
    }
    return stringBuilder.toString()
}

fun convertToTime(counter: Float): String {
    var counter = counter

    val ms = (counter % 1000).toInt() / 10
    counter = (counter.toInt() / 1000).toFloat()
    val hours = ms / (1000 * 60 * 60)
    val min = counter.toInt() / 60
    val sec = counter.toInt() - min * 60
    var hourPrefix = ""
    var minPrefix = ""
    var secPrefix = ""
//    var msPrefix = ""

    if (hours < 10)
        hourPrefix = "0"
    if (min < 10)
        minPrefix = "0"
    if (sec < 10)
        secPrefix = "0"
//    if (ms < 10)
//        msPrefix = "0"

//    return "$hourPrefix$hours : $minPrefix$min : $secPrefix$sec : $msPrefix$ms"
    return "$hourPrefix$hours : $minPrefix$min : $secPrefix$sec"
}

fun formatFileSize(size: Long): String {
    val hrSize: String

    val b = size.toDouble()
    val k = size / 1024.0
    val m = size / 1024.0 / 1024.0
    val g = size / 1024.0 / 1024.0 / 1024.0
    val t = size / 1024.0 / 1024.0 / 1024.0 / 1024.0

    val dec = DecimalFormat("0.00")

    hrSize = when {
        t > 1 -> dec.format(t) + ("  TB")
        g > 1 -> dec.format(g) + ("  GB")
        m > 1 -> dec.format(m) + ("  MG")
        k > 1 -> dec.format(k) + ("  KB")
        else -> dec.format(b) + ("  B")
    }

    return hrSize
}
