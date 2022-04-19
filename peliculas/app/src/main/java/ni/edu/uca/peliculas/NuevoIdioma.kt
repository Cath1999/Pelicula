package ni.edu.uca.peliculas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_nuevo_idioma.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas.bd.Idioma
import ni.edu.uca.peliculas.bd.IdiomaDatabase

class NuevoIdioma: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_idioma)

        val cancelar = findViewById<Button>(R.id.btnCancelar)
        cancelar.setOnClickListener {
            val intento2 = Intent (this, MainActivity::class.java)
            startActivity(intento2)
        }

        var idIdioma: Int? = null

        if (intent.hasExtra("clasificacion")) {
            val idioma = intent.extras?.getSerializable("idioma") as Idioma

            et_nombre.setText(idioma.nombre)
            idIdioma = idioma.idIdioma
        }

        val database = IdiomaDatabase.getDatabase(this)

        btnGuardar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val idioma = Idioma(nombre)

            if (idIdioma != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    idioma.idIdioma = idIdioma
                    database.tblidioma().update(idioma)

                    this@NuevoIdioma.finish()
                }
            } else {

                CoroutineScope(Dispatchers.IO).launch {
                    database.tblidioma().insertAll(idioma)

                    this@NuevoIdioma.finish()
                }
            }
        }
    }
}