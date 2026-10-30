package com.example.yusufsy_3tib.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yusufsy_3tib.databinding.FragmentTutorial3Binding

class Tutorial3Fragment : Fragment() {
    private var _binding: FragmentTutorial3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Mulai untuk menyelesaikan tutorial dan masuk ke aplikasi
        binding.btnMulai.setOnClickListener {
            (requireActivity() as TutorialActivity).selesaiTutorial()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}