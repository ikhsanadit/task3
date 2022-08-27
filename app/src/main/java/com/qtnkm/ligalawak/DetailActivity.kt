package com.qtnkm.ligalawak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.qtnkm.ligalawak.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*
class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "Sport_Name"
        const val EXTRA_FORMAT = "Format_Sport"
        const val EXTRA_TUMB = "Tumb_Sport"
        const val EXTRA_DESC = "Desc_Sport"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDetail()
    }

    private fun getDetail() {
        val tvname = intent.getStringExtra(EXTRA_NAME)
        val tvformat = intent.getStringExtra(EXTRA_FORMAT)
        val tvimage = intent.getStringExtra(EXTRA_TUMB)
        val tvdscsport = intent.getStringExtra(EXTRA_DESC)

        binding.idName.text = tvname
        binding.rvFormat.text = tvformat
        binding.idSportdesc.text = tvdscsport
        Glide.with(this)
            .load(tvimage)
            .into(tvImage)
    }

}