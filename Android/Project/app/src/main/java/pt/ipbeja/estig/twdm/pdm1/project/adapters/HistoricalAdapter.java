package pt.ipbeja.estig.twdm.pdm1.project.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.DetailsActivity;
import pt.ipbeja.estig.twdm.pdm1.project.R;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;

public class HistoricalAdapter extends RecyclerView.Adapter<HistoricalAdapter.HistoricalViewHolder>{
    private static final String TAG = "HistoricalAdapter";

    private List<Book> bookList;
    private Context context;

    public HistoricalAdapter(Context context, List<Book> bookList){
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoricalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_historical, parent, false);
        return new HistoricalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricalViewHolder holder, int position) {
        Book book = this.bookList.get(position);
        holder.getTextViewName().setText(book.getName());
        Glide.with(this.context).load(book.getCover()).into(holder.getImageViewCover());
        //holder.getTextViewDesc().setText(book.getAuthor());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", book.getName(), position));

                DetailsActivity.startActivity(HistoricalAdapter.this.context, book.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }


    public static class HistoricalViewHolder extends RecyclerView.ViewHolder{

        private final View parentLayout;
        private ImageView imageViewCover;
        private TextView textViewName;
        private TextView textViewDesc;

        public HistoricalViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewCover = itemView.findViewById(R.id.imageView3);
            this.textViewName = itemView.findViewById(R.id.textView16);
            // this.textViewDesc = itemView.findViewById(R.id.bookDesc);
            this.parentLayout = itemView;
        }

        public ImageView getImageViewCover() {
            return imageViewCover;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDesc() {
            return textViewDesc;
        }

        public View getParentLayout() {
            return parentLayout;
        }

    }
}
