package vn.edu.usth.facebookclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vn.edu.usth.facebookclient.Comment;
import vn.edu.usth.facebookclient.R;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private Context context;
    private ArrayList<Comment> commentArrayList;

    public CommentAdapter(Context context, ArrayList<Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout row_comment
        View view = LayoutInflater.from(context).inflate(R.layout.row_comment,parent, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        //Get the data !!!
        Comment modelComment = commentArrayList.get(position);
        String id = modelComment.getId();
        String name = modelComment.getName();
        String published = modelComment.getPublished();
        String comment = modelComment.getComment();
        String image = modelComment.getProfile();

        //format GMT date format to proper format dd/MM/yyyy
        String gmtDate = published;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy K:mm a");
        String formatteDate = "";
        try {
            Date date = dateFormat.parse(gmtDate);
            formatteDate = dateFormat1.format(date);
        } catch (ParseException e) {

            // Show date from API if exception
            formatteDate = published;
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        //Set data

        holder.nameTv.setText(name);
        holder.dateTv.setText(formatteDate);
        holder.commentTv.setText(comment);
        try{
            Picasso.get().load(image).into(holder.profileCircle);
        } catch (Exception e) {
            holder.profileCircle.setImageResource(R.drawable.placeholder_image);
        }
    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder{

        // row_comment view
        ImageView profileCircle;
        TextView nameTv, dateTv, commentTv;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);

            profileCircle = itemView.findViewById(R.id.profileCircle);
            nameTv = itemView.findViewById(R.id.nameTv);
            dateTv = itemView.findViewById(R.id.dateTv);
            commentTv = itemView.findViewById(R.id.commentTv);


        }
    }
}
