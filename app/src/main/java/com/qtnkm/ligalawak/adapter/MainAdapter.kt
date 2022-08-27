package com.qtnkm.ligalawak.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.qtnkm.ligalawak.DetailActivity
import com.qtnkm.ligalawak.R
import com.qtnkm.ligalawak.network.SportsItem


class MainAdapter(private val Sport: MutableList<SportsItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = Sport[position]
        val namesport = holder.tvName
        val imageicon = holder.rvImage
        val format = holder.tvFormat

        namesport.text = sport.strSport
        format.text = sport.strFormat

        Glide.with(holder.itemView)
            .load(sport.strSportIconGreen)
            .into(imageicon)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, sport.strSport)
            intent.putExtra(DetailActivity.EXTRA_FORMAT, sport.strFormat)
            intent.putExtra(DetailActivity.EXTRA_TUMB, sport.strSportThumb)
            intent.putExtra(DetailActivity.EXTRA_DESC, sport.strSportDescription)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = Sport.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvImage: ImageView = itemView.findViewById(R.id.tv_Image)
        var tvName: TextView = itemView.findViewById(R.id.sprtName)
        var tvFormat: TextView = itemView.findViewById(R.id.rv_Format)
    }
}