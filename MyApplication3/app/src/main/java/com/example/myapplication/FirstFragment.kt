package com.example.myapplication

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = mutableListOf<ItemData>()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        data.add(ItemData("Все всюди і все одразу ", "(Everything Everywhere All at Once)", R.drawable.one, this.resources.getString(R.string.firstmovie)))
            data.add(ItemData(" Топ Ґан: Меверік", "(Top Gun: Maverick)", R.drawable.two, this.resources.getString(R.string.secondmovie)))
        data.add(ItemData("Я червонію", "(Turning Red)", R.drawable.three, this.resources.getString(R.string.thirdmovie)))


        recyclerView.adapter = ItemDataAdapter(data, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}