package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qtnkm.task2.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        validation()
    }

    private fun validation() {
        binding.buttonSignin.setOnClickListener {
            if (binding.textEmailin.text.toString() == "ikhsan@gmail.com" && binding.textPass.text.toString() == "aditya11"){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(this, HomeActivity::class.java)
                )
            }else if(binding.textEmailin.text.toString().isEmpty() && binding.textPass.text.toString().isEmpty()){
                Toast.makeText(this, "Email or Password is Empty", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Email or Password Salah",Toast.LENGTH_SHORT).show()
            }
        }
        binding.textViewSignup.setOnClickListener {
            Toast.makeText(this,"Sign Up",Toast.LENGTH_SHORT).show().also {
                startActivity(
                    Intent(this, SignupActivity::class.java)
                )
            }
        }
    }

}