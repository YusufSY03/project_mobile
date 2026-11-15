package com.example.yusufsy_3tib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yusufsy_3tib.databinding.FragmentUlasanBinding

class UlasanFragment : Fragment() {
    private var _binding: FragmentUlasanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUlasanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val namaDestinasi = requireActivity().intent.getStringExtra("EXTRA_NAMA") ?: ""
        val daftarUlasan = dataUlasanDestinasi[namaDestinasi] ?: ulasanDefault

        val ulasanAdapter = UlasanAdapter(daftarUlasan) { selectedItem ->
            Toast.makeText(
                requireContext(),
                getString(R.string.toast_klik_ulasan, selectedItem.namaPengunjung, selectedItem.rating),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvUlasan.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ulasanAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}