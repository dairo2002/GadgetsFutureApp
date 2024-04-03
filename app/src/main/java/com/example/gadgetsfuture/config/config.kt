package com.example.gadgetsfuture.config

import android.content.SharedPreferences

class config {

    //crear una variable static
    companion object{
        lateinit var SharedPreferences: SharedPreferences
        //una variable para el token
        lateinit var token:String
        //crear una variable para almacenar la url base
        //puerto SENA:
        //const val urlBase="http://192.168.244.200:8000"
        //puerto local:
        const val urlBase="http://192.168.1.10:8000"


        const val urlTienda="${urlBase}/tienda/api/"
        const val urlCuenta="${urlBase}/cuenta/api/"
    }
}