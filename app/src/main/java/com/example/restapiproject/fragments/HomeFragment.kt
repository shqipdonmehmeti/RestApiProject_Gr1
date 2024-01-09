package com.example.restapiproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.restapiproject.databinding.FragmentHomeBinding
import com.example.restapiproject.helpers.Helpers
import com.example.restapiproject.helpers.Helpers.provideRetrofitInstance
import com.example.restapiproject.models.PhoneDataRequest
import com.example.restapiproject.models.PhoneRequest
import com.example.restapiproject.models.PhoneResponse
import com.example.restapiproject.models.Phones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPhone()
    }

    private fun createPhone() {
        val phoneRequest = PhoneRequest("Cacttus Education Phone", PhoneDataRequest(
            2024,100.0,"Snapdragon","500GB"
        ))
        provideRetrofitInstance().addPhone(phoneRequest).enqueue(object : Callback<PhoneResponse?> {
            override fun onResponse(
                call: Call<PhoneResponse?>,
                response: Response<PhoneResponse?>
            ) {
                Log.d("TAG", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<PhoneResponse?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

}