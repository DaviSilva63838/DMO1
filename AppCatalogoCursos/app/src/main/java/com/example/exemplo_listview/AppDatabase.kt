package com.example.exemplo_listview

import android.content.ContentValues
import android.content.Context
import androidx.room.Database
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Curso::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cursoDao(): CursoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val app = context.applicationContext
                val instance = Room.databaseBuilder(app, AppDatabase::class.java, "cursos_room.db")
                    .allowMainThreadQueries() // simples pra aula
                    .addCallback(object : RoomDatabase.Callback() {
                        // Carga inicial com os cursos do strings.xml
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val iniciais = listOf(
                                app.getString(R.string.nome_tsi) to app.getString(R.string.desc_tsi),
                                app.getString(R.string.nome_eng) to app.getString(R.string.desc_eng),
                                app.getString(R.string.nome_ads) to app.getString(R.string.desc_ads),
                                app.getString(R.string.nome_mat) to app.getString(R.string.desc_mat)
                            )
                            iniciais.forEach { (nome, desc) ->
                                val values = ContentValues().apply {
                                    put("nome", nome)
                                    put("descricao", desc)
                                }
                                db.insert("cursos", OnConflictStrategy.IGNORE, values)
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}