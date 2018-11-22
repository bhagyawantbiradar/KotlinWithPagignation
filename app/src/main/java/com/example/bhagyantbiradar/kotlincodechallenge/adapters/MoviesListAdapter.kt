package com.example.bhagyantbiradar.kotlincodechallenge.adapters

import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bhagyantbiradar.kotlincodechallenge.R
import com.example.bhagyantbiradar.kotlincodechallenge.activities.MovieDetails.MovieDetailsActivity
import com.example.bhagyantbiradar.kotlincodechallenge.activities.main.MainActivity
import com.example.bhagyantbiradar.kotlincodechallenge.activities.main.MainPresenter
import com.example.bhagyantbiradar.kotlincodechallenge.pojos.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search.view.*

class MoviesListAdapter(private val context: Context, private val searchList: ArrayList<Search>, presenter: MainPresenter) :
    RecyclerView.Adapter<MoviesListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: MoviesListAdapter.ViewHolder, position: Int) {
        val searchItem = searchList[position]
        holder.itemView.tvTitle.text = searchItem.title
        holder.itemView.tvReleaseDate.text = searchItem.year
        Picasso.with(context)
            .load(searchItem.poster)
            .centerCrop()
            .fit()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.itemView.ivPoster)

        holder.itemView.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(context,MovieDetailsActivity::class.java)
                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context as MainActivity,holder.itemView.ivPoster,"poster")
                intent.putExtra("movie",searchItem)
                context.startActivity(intent,optionsCompat.toBundle())
            }

        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    fun growList(newSearchList : List<Search>){
        searchList.addAll(newSearchList)
        notifyDataSetChanged()
    }

}