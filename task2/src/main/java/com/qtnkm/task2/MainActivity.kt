package com.qtnkm.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.qtnkm.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        actionButton()
    }

    private fun actionButton() {
        showLoading(false)
        binding.buttonGet.setOnClickListener {
            startActivity(
                Intent(this, SigninActivity::class.java)
            )
            showLoading(true)
        }
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.rdLoad.visibility = View.VISIBLE
            false -> binding.rdLoad.visibility = View.GONE
        }
    }
}