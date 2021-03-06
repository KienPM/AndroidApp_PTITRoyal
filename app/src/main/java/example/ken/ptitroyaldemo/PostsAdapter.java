package example.ken.ptitroyaldemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import example.ken.ptitroyaldemo.model.Post;

/**
 * Created by Ken on 16/04/2016.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> postList;
    private Context context;

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername, tvTimePost, tvContent, tvNumOfLikes, tvNumOfCmts;
        public ImageView imgAvatar, imgContent, imgLike, imgComment;

        public PostViewHolder(View v) {
            super(v);
            imgAvatar = (ImageView) v.findViewById(R.id.imgAvatar);
            tvUsername = (TextView) v.findViewById(R.id.tvUsername);
            tvTimePost = (TextView) v.findViewById(R.id.tvTimePost);
            tvContent = (TextView) v.findViewById(R.id.tvContent);
            tvNumOfLikes = (TextView) v.findViewById(R.id.tvNumOfLikes);
            tvNumOfCmts = (TextView) v.findViewById(R.id.tvNumOfCmts);
            imgContent = (ImageView) v.findViewById(R.id.imgContent);
            imgLike = (ImageView) v.findViewById(R.id.imgLike);
            imgComment = (ImageView) v.findViewById(R.id.imgComment);
        }
    }

    public PostsAdapter(Context context) {
        this.context = context;
    }

    public PostsAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_list, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, final int position) {
        Post post = postList.get(position);
        Picasso.with(context)
                .load(post.getOwner().getAvatarURI())
                .placeholder(R.mipmap.ic_avatar)
                .error(R.mipmap.ic_avatar)
                .into(holder.imgAvatar);
        holder.tvUsername.setText(post.getOwner().getUsername());
        holder.tvTimePost.setText(post.getTime());
        holder.tvContent.setText(post.getContent());
        String imageURI = post.getImageURI();
        holder.tvNumOfLikes.setText(String.valueOf(post.getNumberOfLikes()));
        holder.tvNumOfCmts.setText(String.valueOf(post.getNumberOfComments()));
        if (imageURI != null && !imageURI.equals("")) {
            Picasso.with(context)
                    .load(post.getImageURI())
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_report_image)
                    .into(holder.imgContent);
            holder.imgContent.setVisibility(View.VISIBLE);
        } else {
            holder.imgContent.setVisibility(View.GONE);
        }

        if (post.isLiked()) {
            holder.imgLike.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_like));
        } else {
            holder.imgLike.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_like_inactive));
        }

        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLike(postList.get(position), holder);
            }
        });

        holder.imgComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickComment(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    private void onClickLike(Post post, PostViewHolder holder) {
        if (post.isLiked()) {
            post.decLike();
            holder.imgLike.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_like_inactive));
        } else {
            post.incLike();
            holder.imgLike.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_like));
        }
        post.setLiked(!post.isLiked());
        holder.tvNumOfLikes.setText(String.valueOf(post.getNumberOfLikes()));
    }

    private void onClickComment(int position) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        intent.putExtra("user", MainActivity.user);
        intent.putExtra("post", postList.get(position));
        context.startActivity(intent);
    }
}
