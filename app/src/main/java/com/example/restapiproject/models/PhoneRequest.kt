package com.example.restapiproject.models

data class PhoneRequest(
    val name :String?,
    val data : PhoneDataRequest?
)

data class PhoneDataRequest(
    val year : Int?,
    val price : Double?,
    val cpuModel : String?,
    val hardDiskSize : String?
)

data class PhoneResponse(
    val id : String?,
    val name : String?,
    val data : PhoneData?,
    val createdAt : String?
)
