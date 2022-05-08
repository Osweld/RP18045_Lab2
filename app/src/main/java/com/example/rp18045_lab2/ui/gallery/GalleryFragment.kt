package com.example.rp18045_lab2.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rp18045_lab2.databinding.FragmentGalleryBinding
import com.example.rp18045_lab2.models.AppDatabase
import com.example.rp18045_lab2.models.entity.Propietario
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class GalleryFragment : Fragment() {
    private lateinit var database : AppDatabase
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        database = AppDatabase.getInstance(requireContext())
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        val propietarios: List<Propietario> = database.propietarioDao.getAllPropietarios()

        for(propietario in propietarios){
            textView.append("${propietario.dui} - ${propietario.nombre} - ${propietario.edad} - ${propietario.sexo} - ${propietario.estadoLaboral} - ${propietario.direccion}\n\n")
        }

        val eliminar: Button = binding.eliminarPropietario

        eliminar.setOnClickListener(){
            try{

                val dui: EditText = binding.duiDelete
                val propietario:Propietario = database.propietarioDao.getPropietario(dui.text.toString())
                database.propietarioDao.deletePropietario(propietario)
                Snackbar.make(root, "Sea eliminado el propietario", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }catch(error:Exception){

                Snackbar.make(root, "No se a podido eliminar el propietario", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}