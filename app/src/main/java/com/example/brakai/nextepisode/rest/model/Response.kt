package com.example.brakai.nextepisode.rest.model


class Response<T>(val status: Status, val error : Throwable? = null, val item: T? = null)

enum class Status {
    SUCCESS, FAILED
}