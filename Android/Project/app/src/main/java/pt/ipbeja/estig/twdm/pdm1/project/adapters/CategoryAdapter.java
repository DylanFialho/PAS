package pt.ipbeja.estig.twdm.pdm1.project.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.DetailsActivity;
import pt.ipbeja.estig.twdm.pdm1.project.R;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private static final String TAG = "CategoryArtAdapter";

    private List<Book> bookList;
    private Context context;

    public CategoryAdapter(Context context, List<Book> bookList){
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Book book = this.bookList.get(position);
        holder.getTextViewName().setText(book.getName());
        Glide.with(this.context).load(book.getCover()).into(holder.getImageViewCover());
        holder.getTextViewAuthor().setText(book.getAuthor());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", book.getName(), position));

                DetailsActivity.startActivity(CategoryAdapter.this.context, book.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        private final View parentLayout;
        private ImageView imageViewCover;
        private TextView textViewName;
        private TextView textViewAuthor;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewCover = itemView.findViewById(R.id.imageView15);
            this.textViewName = itemView.findViewById(R.id.textView22);
            this.textViewAuthor = itemView.findViewById(R.id.textView29);
            this.parentLayout = itemView;
        }

        public ImageView getImageViewCover() {
            return imageViewCover;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewAuthor() {
            return textViewAuthor;
        }

        public View getParentLayout() {
            return parentLayout;
        }

    }
}
