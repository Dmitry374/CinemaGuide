package com.example.cinemaguide.data.network

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @field:SerializedName("status_message")
    val statusMessage: String,
    val success: Boolean,
    @field:SerializedName("status_code")
    val statusCode: Int
)