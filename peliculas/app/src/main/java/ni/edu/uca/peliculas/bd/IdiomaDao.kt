package ni.edu.uca.peliculas.bd

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IdiomaDao {

    @Query("SELECT * from tblidioma")
    fun getAll(): LiveData<List<Idioma>>

    @Query("SELECT * from tblidioma WHERE idIdioma = :id")
    fun get(id: Int): LiveData<Idioma>

    @Insert
    fun insertAll (vararg clasificacion: Idioma)

    @Update
    fun update(idioma: Idioma)

    @Delete
    fun delete(idioma: Idioma)

}