package example.ken.ptitroyaldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.solovyev.android.views.llm.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import example.ken.ptitroyaldemo.model.Comment;
import example.ken.ptitroyaldemo.model.Post;
import example.ken.ptitroyaldemo.model.User;

public class PostDetailActivity extends AppCompatActivity {

    private User user;
    private Post post;
    private List<Comment> comments;

    private TextView tvUsername, tvTimePost, tvContent, tvNumOfLikes, tvNumOfCmts;
    private ImageView imgAvatar, imgContent, imgLike;
    private RecyclerView rvComments;
    private CommentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        post = (Post) intent.getSerializableExtra("post");
        comments = fakeData();
        initComponents();
    }

    private void initComponents() {
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvTimePost = (TextView) findViewById(R.id.tvTimePost);
        tvContent = (TextView) findViewById(R.id.tvContent);
        tvNumOfLikes = (TextView) findViewById(R.id.tvNumOfLikes);
        tvNumOfCmts = (TextView) findViewById(R.id.tvNumOfCmts);
        imgContent = (ImageView) findViewById(R.id.imgContent);
        imgLike = (ImageView) findViewById(R.id.imgLike);

        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        rvComments.setNestedScrollingEnabled(false);
        adapter = new CommentsAdapter(this, comments);
        final LinearLayoutManager mLayoutManager =
                new org.solovyev.android.views.llm.LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvComments.setLayoutManager(mLayoutManager);
        rvComments.setItemAnimator(new DefaultItemAnimator());
        rvComments.addItemDecoration(new DividerItemDecoration(this, null));
        rvComments.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Picasso.with(this)
                .load(post.getOwner().getAvatarURI())
                .placeholder(R.mipmap.ic_avatar)
                .error(R.mipmap.ic_avatar)
                .into(imgAvatar);
        tvUsername.setText(post.getOwner().getUsername());
        tvTimePost.setText(post.getTime());
        tvContent.setText(post.getContent());
        String imageURI = post.getImageURI();
        tvNumOfLikes.setText(String.valueOf(post.getNumberOfLikes()));
        tvNumOfCmts.setText(String.valueOf(post.getNumberOfComments()));
        if (imageURI != null && !imageURI.equals("")) {
            imgContent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            Picasso.with(this)
                    .load(post.getImageURI())
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_report_image)
                    .into(imgContent);
            imgContent.setVisibility(View.VISIBLE);
        } else {
            imgContent.setVisibility(View.GONE);
        }
        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLike();
            }
        });

        rvComments.getLayoutParams().height = comments.size() * 500;
    }

    public void onClickBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void onClickLike() {
        post.incLike();
        tvNumOfLikes.setText(String.valueOf(post.getNumberOfLikes()));
    }

    public List<Comment> fakeData() {
        List<Comment> list = new ArrayList<>();
        User user2 = new User("2", "Ken", "https://pbs.twimg.com/media/CYHZY4IWsAA4xSD.jpg", "");
        int i = 0;
        list.add(new Comment("1", user2, null, "3 phút trước", "This is comment " + i++));
        list.add(new Comment("2", user, user2, "2 phút trước", "This is comment " + i++));
        list.add(new Comment("3", user, null, "2 phút trước", "This is comment " + i++));

        return list;
    }
}
