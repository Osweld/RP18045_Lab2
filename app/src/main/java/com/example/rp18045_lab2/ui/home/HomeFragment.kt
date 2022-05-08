package com.example.rp18045_lab2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rp18045_lab2.databinding.FragmentHomeBinding
import com.example.rp18045_lab2.models.AppDatabase
import com.example.rp18045_lab2.models.entity.Propietario
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private lateinit var database : AppDatabase
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        database = AppDatabase.getInstance(requireContext())
        val guardar:Button = binding.guardarPropietario
        val editar:Button = binding.editarPropietario

        guardar.setOnClickListener(){

            try {
                val dui:EditText = binding.dui
                val nombre:EditText = binding.nombre
                val edad:EditText = binding.edad
                val sexo:EditText = binding.sexo
                val estado_laboral:EditText = binding.estadoLaboral
                val direccion:EditText = binding.direccion
                database.propietarioDao.insertPropietario(Propietario(dui.text.toString(),
                    nombre.text.toString(),
                    edad.text.toString(),
                    sexo.text.toString(),
                    estado_laboral.text.toString(),
                    direccion.text.toString()))

                Snackbar.make(root, "Se a guardado el propietario", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }catch (Error:Exception){
                Snackbar.make(root, "**No se a guardado el propietario**", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

        }



        editar.setOnClickListener(){

            try {
                val dui:EditText = binding.dui
                val nombre:EditText = binding.nombre
                val edad:EditText = binding.edad
                val sexo:EditText = binding.sexo
                val estado_laboral:EditText = binding.estadoLaboral
                val direccion:EditText = binding.direccion
                database.propietarioDao.updatePropietario(Propietario(dui.text.toString(),
                    nombre.text.toString(),
                    edad.text.toString(),
                    sexo.text.toString(),
                    estado_laboral.text.toString(),
                    direccion.text.toString()))

                Snackbar.make(root, "Se a actualizado el propietario", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }catch (Error:Exception){
                Snackbar.make(root, "**No se a actualizar el propietario**", Snackbar.LENGTH_LONG)
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