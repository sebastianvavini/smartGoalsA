package com.codecomponents.smartgoalsa.shared

import android.content.Context
import android.content.SharedPreferences

class SharedData (context: Context){
    private val sharedPreferences:SharedPreferences= context.
    getSharedPreferences("MotivatioSharedPref", Context.MODE_PRIVATE)

    public fun storeString(key:String,string:String){

        sharedPreferences.edit().putString(key,string).apply()
    }
    fun getString(key: String):String{

        return sharedPreferences.getString(key,"") ?: ""

    }
}