package com.example.exemplo_listview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CursoDao {

    @Query("SELECT * FROM cursos ORDER BY nome ASC")
    fun getAll(): List<Curso>

    @Insert
    fun insert(curso: Curso)

    @Update
    fun update(curso: Curso)

    @Delete
    fun delete(curso: Curso)
}