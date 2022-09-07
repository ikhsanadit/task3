package com.qtnkm.task2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        setButton()
    }

    private fun setButton() {
        showLoading(false)
        val validName = binding.rvName.text.toString().isEmpty()
        val validEmail = binding.rvEmail.text.toString().isEmpty()
        val validPassword = binding.rvPassword.text.toString().isEmpty()
        val validPhone = binding.rvPhone.text.toString().isEmpty()

        binding.buttonSignup.setOnClickListener {
            if (validName && validEmail && validPassword && validPhone){
                AlertDialog.Builder(this)
                    .setTitle("Invalid Form")
                    .setMessage("Form must be filled")
                    .setPositiveButton("Ok"){_,_ ->
                        //do nothing
                    }
                    .show()
            } else {
                Toast.makeText(this,"Sign in",Toast.LENGTH_SHORT).show().also {
                    startActivity(
                        Intent(this, SigninActivity::class.java)
                    )
                }
            }

        }


        binding.textViewSignin.setOnClickListener {
            Toast.makeText(this,"Sign in",Toast.LENGTH_SHORT).show().also {
                showLoading(true)
                startActivity(
                    Intent(this, SigninActivity::class.java)
                )
            }
        }
    }

    private fun validation() {
        showLoading(false)
        binding.rvName.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.rvName.error = validName()
            }
        }
        binding.rvEmail.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.rvEmail.error = validEmail()
            }
        }
        binding.rvPhone.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.rvPhone.error = validPhone()
            }
        }
        binding.rvPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.rvPassword.error = validPassword()
            }
        }
    }

    private fun validName(): CharSequence? {
        val nameText = binding.rvName.text.toString()
        if (nameText.length > 13){
            return "Max 13 Charracter Password"
        }
        if (nameText.length < 10){
            return "Min 10 Charracter Password"
        }
        if (!nameText.matches(".*[a-zA-Z].*".toRegex())){
            return "Must Be all digits 0-9"
        }
        return null
    }

    private fun validEmail(): String?{
        val emailText = binding.rvEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        if (emailText.isEmpty()){
            return "Email is Empty"
        }
        return null
    }

    private fun validPhone(): CharSequence? {
        val phoneText = binding.rvPhone.text.toString()
        if (phoneText.length > 13){
            return "Max 13 Charracter Password"
        }
        if (phoneText.length < 10){
            return "Min 10 Charracter Password"
        }
        if (!phoneText.matches(".*[0-9].*".toRegex())){
            return "Must Be all digits 0-9"
        }
        return null
    }

    private fun validPassword(): String?{
        val passwordText = binding.rvPassword.text.toString()
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
        if (passwordText.isEmpty()){
            return "Email is Empty"
        }
        return null
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.rdLoad.visibility = View.VISIBLE
            false -> binding.rdLoad.visibility = View.GONE
        }

    }
}