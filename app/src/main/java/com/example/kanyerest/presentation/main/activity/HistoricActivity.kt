package com.example.kanyerest.presentation.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kanyerest.databinding.ActivityHistoricBinding
import com.example.kanyerest.presentation.main.viewmodel.MainViewModel
import com.example.kanyerest.ui.adapter.ListaQuotesDatabaseAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoricActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHistoricBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        createHistoricList()
    }

    private fun createHistoricList(){
        binding.recyclerViewHistory.adapter = ListaQuotesDatabaseAdapter(mainViewModel.fetchListQuotes())
    }
}