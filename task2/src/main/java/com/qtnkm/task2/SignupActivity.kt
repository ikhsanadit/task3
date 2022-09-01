package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qtnkm.task2.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        validation()
    }

    private fun validation() {
        showLoading(false)
        binding.buttonSignup.setOnClickListener {
            if (binding.rvName.text.toString().isEmpty()) {
            Toast.makeText(this, "Full Name is Empty", Toast.LENGTH_SHORT).show()
            } else if (binding.rvName.text.toString().contains("@")){
                Toast.makeText(this, "Email must be invalid", Toast.LENGTH_SHORT).show()
            } else if (binding.rvEmail.text.toString().isEmpty()) {
                Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show()
            }  else if (binding.rvPhone.text.toString().isEmpty()) {
                Toast.makeText(this, "Phone Number is Empty", Toast.LENGTH_SHORT).show()
            } else if(binding.rvPassword.text.toString().length<5){
                Toast.makeText(this, "Password must be longer than 5", Toast.LENGTH_SHORT).show()
            } else if (binding.rvPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Sign in",Toast.LENGTH_SHORT).show().also {
                    startActivity(
                        Intent(this, SigninActivity::class.java)
                    )
                    showLoading(true)
                }
            }
        }
        binding.textViewSignin.setOnClickListener {
            Toast.makeText(this,"Sign in",Toast.LENGTH_SHORT).show().also {
                startActivity(
                    Intent(this, SigninActivity::class.java)
                )
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