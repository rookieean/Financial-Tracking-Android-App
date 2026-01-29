package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.data.AppDatabase
import com.example.app.data.TransactionEntity
import com.example.app.databinding.ActivityMainBinding
import com.example.app.ui.TransactionAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TransactionAdapter

    private val db by lazy { AppDatabase.getInstance(this) }
    private val transactionDao by lazy { db.transactionDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeTransactions()
        observeTotalBalance()
        setupButton()
    }

    private fun setupRecyclerView() {
        adapter = TransactionAdapter(emptyList())
        binding.rvTransactions.layoutManager = LinearLayoutManager(this)
        binding.rvTransactions.adapter = adapter
    }

    private fun setupButton() {
        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text?.toString()?.trim().orEmpty()
            val amountText = binding.etAmount.text?.toString()?.trim().orEmpty()

            if (name.isEmpty() || amountText.isEmpty()) {
                Toast.makeText(this, "Nama dan nominal wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toLongOrNull()
            if (amount == null) {
                Toast.makeText(this, "Nominal harus angka", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                val transaction = TransactionEntity(
                    name = name,
                    amount = amount
                )
                transactionDao.insert(transaction)

                withContext(Dispatchers.Main) {
                    binding.etName.text?.clear()
                    binding.etAmount.text?.clear()
                }
            }
        }
    }

    private fun observeTransactions() {
        lifecycleScope.launch {
            transactionDao.getAllTransactions().collectLatest { list ->
                adapter.submitList(list)
            }
        }
    }

    private fun observeTotalBalance() {
        lifecycleScope.launch {
            transactionDao.getTotalBalance().collectLatest { total ->
                val safeTotal = total ?: 0L
                binding.tvBalanceAmount.text = "Rp $safeTotal"
            }
        }
    }
}