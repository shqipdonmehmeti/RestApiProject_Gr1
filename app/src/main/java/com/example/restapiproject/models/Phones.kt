package com.example.restapiproject.models

data class Phones(
    val id : String?,
    val name : String?,
    val data : PhoneData?
)

data class PhoneData(
    val color : String?,
    val capacity : String?,
    val price : Double?,
    val generation : String?,
    val year : Int?,
    val cpuModel : String?,
    val hardDiskSize : String?,
    val strapColour : String?,
    val caseSize : String?,
    val description : String?,
    val screenSize : Double?
)

