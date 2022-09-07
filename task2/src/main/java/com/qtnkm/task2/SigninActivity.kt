package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        setButton()

    }

    private fun validation() {
        showLoading(false)
        binding.textEmailin.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.textEmailin.error = validEmail()
            }
        }
        binding.textPass.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.textPass.error = validPassword()
            }
        }
    }

    private fun validEmail(): String?{
        val emailText = binding.textEmailin.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        return null
    }

    private fun validPassword(): String?{
        val passwordText = binding.textPass.text.toString()
        if (passwordText.length < 8){
            return "Minimum 8 Charracter Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 Upper-case Charracter"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())){
            return "Must Contain 1 Lower-case Charracter"
        }
        if (!passwordText.matches(".*[@#$%^&+=].*".toRegex())){
            return "Must Contain 1 Special Charracter (@#$%^&+=)"
        }
        return null
    }

    private fun setButton() {
        showLoading(false)
        val validEmail = binding.textEmailin.text.toString().isEmpty()
        val validPassword = binding.textPass.text.toString().isEmpty()

        binding.buttonSignin.setOnClickListener {
            if (validEmail && validPassword){
                AlertDialog.Builder(this)
                    .setTitle("Invalid Form")
                    .setMessage("Email or Password must be filled")
                    .setPositiveButton("Ok"){_,_ ->
                        //do nothing
                    }
                    .show()

            }
            if(!validEmail && !validPassword){
                Toast.makeText(this,"Sign In",Toast.LENGTH_SHORT).show().also {
                    showLoading(true)
                    startActivity(
                        Intent(this, HomeActivity::class.java)
                    )
                }
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

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.rdLoad.visibility = View.VISIBLE
            false -> binding.rdLoad.visibility = View.GONE
        }
    }

}