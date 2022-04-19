package ni.edu.uca.peliculas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_vista.*
import kotlinx.android.synthetic.main.activity_vista.tv_Nombre
import ni.edu.uca.peliculas.bd.Idioma
import ni.edu.uca.peliculas.bd.IdiomaDatabase

class IdiomaActivity : AppCompatActivity() {

    private lateinit var database: IdiomaDatabase
    private lateinit var idioma: Idioma
    private lateinit var idiomaLiveData: LiveData<Idioma>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista)

        val hecho = findViewById<Button>(R.id.btnRegresar)

        hecho.setOnClickListener {
            val intento2 = Intent (this, MainActivity::class.java)
            startActivity(intento2)
        }

        database = IdiomaDatabase.getDatabase(this)

        val idIdioma = intent.getIntExtra("id", 0)

        idiomaLiveData = database.tblidioma().get(idIdioma)

        idiomaLiveData.observe(this, Observer {
            idioma = it

            tv_Nombre.text = idioma.nombre
            tv_Id.text = idioma.idIdioma.toString()

        })
    }

}