package com.example.restapiproject.api

import com.example.restapiproject.api.ServiceApi.Companion.API_OBJECT_ENDPOINT
import com.example.restapiproject.models.PhoneRequest
import com.example.restapiproject.models.PhoneResponse
import com.example.restapiproject.models.Phones
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {

    @GET(API_OBJECT_ENDPOINT)
    fun getPhones(): Call<List<Phones>>

    @POST(API_OBJECT_ENDPOINT)
    fun addPhone(@Body phoneRequest: PhoneRequest) : Call<PhoneResponse>


    companion object {
        const val API_OBJECT_ENDPOINT = "objects"
    }
}