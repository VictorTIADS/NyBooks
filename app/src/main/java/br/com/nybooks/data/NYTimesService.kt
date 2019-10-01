package br.com.nybooks.data

import br.com.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesService {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "9vg1j1IWI2hKXwDmS33qtEdVNVKjeL7f",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>

}