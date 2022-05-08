package com.example.rp18045_lab2.ui.vercelular

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rp18045_lab2.R
import com.example.rp18045_lab2.databinding.AgregarCelularFragmentBinding
import com.example.rp18045_lab2.databinding.VerCelularFragmentBinding
import com.example.rp18045_lab2.models.AppDatabase

class VerCelularFragment : Fragment() {

    private lateinit var database: AppDatabase
    private var _binding: VerCelularFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        database = AppDatabase.getInstance(requireContext())
        _binding = VerCelularFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}