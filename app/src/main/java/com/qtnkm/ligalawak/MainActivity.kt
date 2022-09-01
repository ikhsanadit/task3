package com.qtnkm.ligalawak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtnkm.ligalawak.adapter.MainAdapter
import com.qtnkm.ligalawak.databinding.ActivityMainBinding
import com.qtnkm.ligalawak.network.ApiCofig
import com.qtnkm.ligalawak.network.ApiResponse
import com.qtnkm.ligalawak.network.SportsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG: String = "MainActivity"
    private val sportlist = ArrayList<SportsItem>()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerview()
        getDataFromAPI()
    }

    private  fun showRecyclerview(){
        adapter = MainAdapter(sportlist)

        val layoutManager = LinearLayoutManager(this)
        binding.rdMain.layoutManager = layoutManager
        binding.rdMain.adapter = adapter
    }
    private fun getDataFromAPI() {
        showLoading(true)
        val client = ApiCofig.point.getSportsFromAPI()
        client.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responBody = response.body()
                    if (responBody != null) {
                        sportlist.addAll(responBody.sports)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure : ${t.message}")
            }
        })
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> binding.rdLoad.visibility = View.VISIBLE
            false -> binding.rdLoad.visibility = View.GONE
        }
    }

}