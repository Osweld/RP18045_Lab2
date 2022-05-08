package com.example.rp18045_lab2.ui.celularagregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rp18045_lab2.databinding.AgregarCelularFragmentBinding
import com.example.rp18045_lab2.models.AppDatabase


class AgregarCelularFragment : Fragment() {
    private lateinit var database: AppDatabase
    private var _binding: AgregarCelularFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        database = AppDatabase.getInstance(requireContext())
        _binding = AgregarCelularFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
