package com.example.kanyerest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kanyerest.databinding.QuoteHistoricItemBinding
import com.example.kanyerest.domain.model.QuoteDatabaseModel

class ListaQuotesDatabaseAdapter(private val quotesDatabase: LiveData<List<QuoteDatabaseModel>>) :
    RecyclerView.Adapter<ListaQuotesDatabaseAdapter.QuotesViewHolder>() {

    class QuotesViewHolder(val binding: QuoteHistoricItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        return QuotesViewHolder(
            QuoteHistoricItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.binding.tvMensagem.text = quotesDatabase.value?.get(position)?.quote
        holder.binding.tvDataMensagem.text = quotesDatabase.value?.get(position)?.date
    }

    override fun getItemCount(): Int{
        return if(quotesDatabase.value != null){
            quotesDatabase.value?.size!!
        } else{
            0
        }
    }
}