package com.sars.connection

import java.sql.*

data class DatabaseConnection(
    private val url: String,
    private val root: String,
    private val password: String
){
    fun getConnection(): Connection {
        return DriverManager.getConnection(url, root, password)
    }
}



