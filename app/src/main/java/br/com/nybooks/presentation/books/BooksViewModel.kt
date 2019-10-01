package br.com.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.nybooks.data.ApiService
import br.com.nybooks.data.model.Book
import br.com.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData = MutableLiveData<List<Book>>()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (results in bookBodyResponse.bookResults) {
                            val book = Book(
                                title = results.bookDetails[0].bookTitle,
                                author = results.bookDetails[0].bookAuthor
                            )

                            books.add(book)
                        }
                    }

                    booksLiveData.value = books

                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
    }

}