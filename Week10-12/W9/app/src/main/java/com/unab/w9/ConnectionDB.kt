package com.unab.w9

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConnectionDB (
    context: Context?,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
        ): SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table article(id_Article int primary key, description text, price real)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}