package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qtnkm.task2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        showLoading(false)
        binding.buttonSignout.setOnClickListener {
            Toast.makeText(this,"Sign Out", Toast.LENGTH_SHORT).show().also {
                startActivity(
                    Intent(this, SigninActivity::class.java)
                )
                showLoading(true)
            }
        }
    }
    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.rdLoad.visibility = View.VISIBLE
            false -> binding.rdLoad.visibility = View.GONE
        }
    }
}