package ni.edu.uca.peliculas.bd

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="TblIdioma")
data class Idioma(
    val nombre: String,

    @PrimaryKey(autoGenerate = true)
    var idIdioma: Int = 0
) : Serializable