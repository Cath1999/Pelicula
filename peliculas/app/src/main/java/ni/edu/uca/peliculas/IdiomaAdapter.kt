package ni.edu.uca.peliculas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_idioma.view.*
import ni.edu.uca.peliculas.bd.Idioma

class IdiomaAdapter(private val mContext: Context, private val listaIdioma: List<Idioma>) : ArrayAdapter<Idioma>(mContext, 0, listaIdioma) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_idioma, parent, false)

        val idioma = listaIdioma[position]

        layout.nombre.text = idioma.nombre
        layout.idIdioma.text = "${idioma.idIdioma}"

        return layout
    }

}