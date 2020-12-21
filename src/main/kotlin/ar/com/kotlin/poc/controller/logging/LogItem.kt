package ar.com.kotlin.poc.controller.logging

import java.util.*

class LogItem {
    lateinit var userName:String
    lateinit var request:String
    lateinit var response:String
    lateinit var stack:String
    var httpCode:Int = 0
    lateinit var httpMethod: String
    lateinit var date: Date
    lateinit var address: String

}