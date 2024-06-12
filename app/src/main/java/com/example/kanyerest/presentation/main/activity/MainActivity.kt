package com.example.kanyerest.presentation.main.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.kanyerest.R
import com.example.kanyerest.databinding.ActivityMainBinding
import com.example.kanyerest.presentation.state.QuoteState
import com.example.kanyerest.presentation.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
    }

    override fun onResume() {
        super.onResume()

        val tvQuotes = binding.tvQuotes

        mainViewModel.state.observe(this, Observer { state ->
            when (state) {
                is QuoteState.ShowItems -> {

                    tvQuotes.text = state.items

                }
                else -> Log.d("stateHomeActivity", "retornou com erro")
            }
        })

        binding.btnQuotesSearch.setOnClickListener() {
            MainScope().launch {
                mainViewModel.searchQuote()
            }
        }

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.historico_menu ->{
                    startActivity(Intent(this, HistoricActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top_appbar, menu)
        return true
    }


}