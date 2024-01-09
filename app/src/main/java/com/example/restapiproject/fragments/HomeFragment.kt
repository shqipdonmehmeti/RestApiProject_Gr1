package com.example.restapiproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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
        onClick()
    }

    private fun onClick() {
        binding.btnCreatePhone.setOnClickListener {
            createPhone()
        }
    }
    private fun createPhone() {
        val phoneRequest = PhoneRequest(
            binding.etPhoneName.text.toString(), PhoneDataRequest(
                binding.etYear.text.toString().toInt(),
                binding.etPrice.text.toString().toDouble(),
                binding.etCpuModel.text.toString(),
                binding.etHardDiskSize.text.toString()
            )
        )
        provideRetrofitInstance().addPhone(phoneRequest).enqueue(object : Callback<PhoneResponse?> {
            override fun onResponse(
                call: Call<PhoneResponse?>,
                response: Response<PhoneResponse?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()
                    Toast.makeText(requireContext(),"Item was created successfully at ${responseBody?.createdAt}",Toast.LENGTH_LONG).show()
                    val action = HomeFragmentDirections.actionNavHomeToHomeDetailsFragment(responseBody?.id)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(requireContext(),"Error happened while fetching data! ${response.errorBody()}",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<PhoneResponse?>, t: Throwable) {
                Toast.makeText(requireContext(),"Error happened probably due to internet connection / server timeout",Toast.LENGTH_LONG).show()
            }
        })
    }

}