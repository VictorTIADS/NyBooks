package br.com.nybooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse(
    @Json(name = "title") val bookTitle: String,
    @Json(name = "author") val bookAuthor: String,
    @Json(name = "description") val bookDescription: String
)