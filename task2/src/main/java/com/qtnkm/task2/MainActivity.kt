package com.qtnkm.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qtnkm.task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        actionButton()
        /*binding.buttonGet.setOnClickListener {
            startActivity(Intent(this, SigninActivity::class.java))
        }*/
    }

    private fun actionButton() {
        binding.buttonGet.setOnClickListener {
            startActivity(
                Intent(this, SigninActivity::class.java)
            )
        }
    }
}