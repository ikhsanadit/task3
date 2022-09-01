package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
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

        binding.buttonSignout.setOnClickListener {
            Toast.makeText(this,"Sign Out", Toast.LENGTH_SHORT).show().also {
                startActivity(
                    Intent(this, SigninActivity::class.java)
                )
            }
        }
    }
}