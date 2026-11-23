package com.example.yusufsy_3tib.catatan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yusufsy_3tib.data.AppDatabase
import com.example.yusufsy_3tib.data.entity.CatatanEntity
import com.example.yusufsy_3tib.databinding.FragmentCatatanBinding
import kotlinx.coroutines.launch

class CatatanFragment : Fragment() {
    private var _binding: FragmentCatatanBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: CatatanAdapter
    private val daftarCatatan = mutableListOf<CatatanEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatatanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = AppDatabase.getInstance(requireContext())
        adapter = CatatanAdapter(daftarCatatan) { catatan -> deleteCatatan(catatan) }

        binding.rvCatatan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCatatan.adapter = adapter
        binding.rvCatatan.addItemDecoration(
            DividerItemDecoration(
                requireContext(), DividerItemDecoration.VERTICAL
            )
        )

        binding.fabAddCatatan.setOnClickListener {
            startActivity(Intent(requireContext(), CatatanFormActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        if (_binding != null) fetchCatatan()
    }

    private fun fetchCatatan() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = db.catatanDao().getAll()
            daftarCatatan.clear()
            daftarCatatan.addAll(result)
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteCatatan(catatan: CatatanEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.catatanDao().delete(catatan)
            fetchCatatan()
        }
    }

    override fun onDestroyView() {
        binding.rvCatatan.adapter = null
        _binding = null
        super.onDestroyView()
    }
}