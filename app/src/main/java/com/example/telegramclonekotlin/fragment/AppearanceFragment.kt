package com.example.telegramclonekotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramclonekotlin.R

class AppearanceFragment : Fragment() {
    var recyclerView: RecyclerView? = null
    var list = ArrayList<ListApperance>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appearance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView?.setHasFixedSize(true)
        val adapter = MyAdapter(this.activity, list)
        recyclerView?.setAdapter(adapter)
        recyclerView?.setAdapter(adapter)
        data()

    }

    private fun data() {
        list.add(ListApperance(R.drawable.img1))
        list.add(ListApperance(R.drawable.img2))
        list.add(ListApperance(R.drawable.img3))
        list.add(ListApperance(R.drawable.img4))
        list.add(ListApperance(R.drawable.img5))
        list.add(ListApperance(R.drawable.img6))
        list.add(ListApperance(R.drawable.img7))
        list.add(ListApperance(R.drawable.img8))
    }
}

data class ListApperance(var image: Int)

class MyAdapter(var context: FragmentActivity?, var list: List<ListApperance>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.apperance_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val data = list[position]

        if (true) {
            val iv_profile = holder.iv_profile

            iv_profile.setImageResource(data.image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}