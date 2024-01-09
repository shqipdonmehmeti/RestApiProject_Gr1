package com.example.restapiproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restapiproject.databinding.FragmentHomeDetailsBinding
import com.example.restapiproject.helpers.Helpers
import com.example.restapiproject.models.Phones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentHomeDetailsBinding
    private val args : HomeDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPhoneById()
    }

    private fun getPhoneById() {
        Helpers.provideRetrofitInstance().getPhoneById(args.id ?: "").enqueue(object : Callback<Phones?> {
            override fun onResponse(call: Call<Phones?>, response: Response<Phones?>) {
                Log.d("TAG", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Phones?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

}