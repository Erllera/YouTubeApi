package com.geektech.testing.youtube.data.domain

class Resources<T>(val data: T?, val msg: String?, val status: Status) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resources<T> {
            return Resources(data, null, Status.SUCCESS)
        }

        fun <T> loading(): Resources<T> {
            return Resources(null, null, Status.LOADING)
        }

        fun <T> error(msg: String?): Resources<T> {
            return Resources(null, msg, Status.ERROR)
        }
    }
}