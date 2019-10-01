package br.com.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.nybooks.R
import br.com.nybooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.txtAuthor
import kotlinx.android.synthetic.main.item_book.view.txtTitle

class BooksAdapter(
    private val booksList: List<Book>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)

        return BooksViewHolder(itemView)
    }

    override fun getItemCount() = booksList.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(booksList[position])

    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.txtTitle
        private val author = itemView.txtAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
        }

    }

}