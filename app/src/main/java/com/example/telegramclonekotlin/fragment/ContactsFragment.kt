package com.example.telegramclonekotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramclonekotlin.R

class ContactsFragment : Fragment() {
    var recyclerViewContact: RecyclerView? = null
    var list = ArrayList<ListData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewContact = view.findViewById(R.id.recyclerViewContact)
        recyclerViewContact?.setLayoutManager(
            LinearLayoutManager(activity)
        )
        recyclerViewContact?.setHasFixedSize(true)
        val adapter = ContactAdapter(this.activity, list)
        recyclerViewContact?.setAdapter(adapter)
        recyclerViewContact?.setAdapter(adapter)
        data()
    }

    private fun data() {
        list.add(ListData(R.drawable.img1, "Юлдашева Назира Мирмақсудовна", "online"))
        list.add(
            ListData(
                R.drawable.img2,
                "Ибрагимова Шахло",
                "online"
            )
        )
        list.add(
            ListData(
                R.drawable.img3,
                "Холмуратов Азизбек Баходиржонович",
                "online"
            )
        )
        list.add(
            ListData(
                R.drawable.img4,
                "Мухитдинова Гулноз Уктамбаевна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img5,
                "Мирсаидова Шахноза Шавкатовна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img6,
                "Абдуназаров Жавохирбек Ойбек ўғли",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img7,
                "Валиева Ханифахон Негматовна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img8,
                "Шамансурова Гулноза Хасановна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img1,
                "Юлдашева Назира Мирмақсудовна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img2,
                "Ибрагимова Шахло",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img3,
                "Холмуратов Азизбек Баходиржонович",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img4,
                "Мухитдинова Гулноз Уктамбаевна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img5,
                "Мирсаидова Шахноза Шавкатовна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img6,
                "Абдуназаров Жавохирбек Ойбек ўғли",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img7,
                "Валиева Ханифахон Негматовна",
                "last seen recently"
            )
        )
        list.add(
            ListData(
                R.drawable.img8,
                "Шамансурова Гулноза Хасановна",
                "last seen recently"
            )
        )
    }
}

data class ListData(var image: Int, var name: String, var title: String)

class ContactAdapter(var context: FragmentActivity?, var list: List<ListData>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var name: TextView
        var title: TextView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            name = itemView.findViewById(R.id.name)
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        val data = list[position]

        if (true) {
            val iv_profile = holder.iv_profile
            val name = holder.name
            val title = holder.title

            iv_profile.setImageResource(data.image)
            name.setText(data.name)
            title.setText(data.title)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
