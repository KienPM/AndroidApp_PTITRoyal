package example.ken.ptitroyaldemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.ken.ptitroyaldemo.model.Comment;

/**
 * Created by Ken on 18/04/2016.
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    private Context context;
    private List<Comment> commentList;

    public CommentsAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCommentUsername, tvReplyTo, tvCommentContent, tvCommentTime;
        public ImageView imgCommentAvatar;

        public CommentViewHolder(View v) {
            super(v);
            tvCommentUsername = (TextView) v.findViewById(R.id.tvCommentUsername);
            tvReplyTo = (TextView) v.findViewById(R.id.tvReplyTo);
            tvCommentContent = (TextView) v.findViewById(R.id.tvCommentContent);
            tvCommentTime = (TextView) v.findViewById(R.id.tvCommentTime);
            imgCommentAvatar = (ImageView) v.findViewById(R.id.imgCommentAvatar);
        }
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_list, parent, false);
        return new CommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.tvCommentUsername.setText(comment.getUsername());
        String replyTo = comment.getReplyTo();
        if (replyTo == null || replyTo.equals("")) {
            holder.tvReplyTo.setVisibility(View.GONE);
        } else {
            holder.tvReplyTo.setText(replyTo);
            holder.tvReplyTo.setVisibility(View.VISIBLE);
        }
        holder.tvCommentContent.setText(comment.getContent());
        holder.tvCommentTime.setText(comment.getTime());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}
