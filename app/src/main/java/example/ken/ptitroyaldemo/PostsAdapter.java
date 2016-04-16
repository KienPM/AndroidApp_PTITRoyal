package example.ken.ptitroyaldemo;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.ken.ptitroyaldemo.model.Post;

/**
 * Created by Ken on 16/04/2016.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> postList;

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername, tvTime, tvContent, tvNumOfLikes, tvNumOfCmts;
        public ImageView imgContent;

        public PostViewHolder(View v) {
            super(v);
            tvUsername = (TextView) v.findViewById(R.id.tvUsername);
            tvTime = (TextView) v.findViewById(R.id.tvTime);
            tvContent = (TextView) v.findViewById(R.id.tvContent);
            tvNumOfLikes = (TextView) v.findViewById(R.id.tvNumOfLikes);
            tvNumOfCmts = (TextView) v.findViewById(R.id.tvNumOfCmts);
            imgContent = (ImageView) v.findViewById(R.id.imgContent);
        }
    }

    public PostsAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_list, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.tvUsername.setText(post.getUsername());
        holder.tvTime.setText(post.getTime());
        holder.tvContent.setText(post.getContent());
        String imageURI = post.getImageURI();
        holder.tvNumOfLikes.setText(String.valueOf(post.getNumberOfLikes()));
        holder.tvNumOfCmts.setText(String.valueOf(post.getNumberOfComments()));
        if (imageURI != null && !imageURI.equals("")) {
            holder.imgContent.setImageURI(Uri.parse(imageURI));
            holder.imgContent.setVisibility(View.GONE);
        } else {
            holder.imgContent.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
