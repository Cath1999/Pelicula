package ni.edu.uca.peliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_add.*
import ni.edu.uca.peliculas.bd.Idioma
import ni.edu.uca.peliculas.bd.IdiomaDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var listaClasificaciones = emptyList<Idioma>()

        val database = IdiomaDatabase.getDatabase(this)

        database.tblidioma().getAll().observe(this, Observer {
            listaClasificaciones = it

            val adapter = IdiomaAdapter (this, listaClasificaciones)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this, IdiomaActivity::class.java)
            intent.putExtra("id", listaClasificaciones[position].idIdioma)
            startActivity(intent)
        }

        icon_add.setOnClickListener{
            val intent = Intent (this, NuevoIdioma::class.java)
            startActivity(intent)
        }
    }
}