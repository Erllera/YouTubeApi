package com.geektech.testing.youtube.data.model

data class ErrorResponse(
    val error: ErrorBody? = null
)

data class ErrorBody(
    val code: Int? = null,
    val msg: String? = null
)
