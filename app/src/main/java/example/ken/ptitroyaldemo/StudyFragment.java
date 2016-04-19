package example.ken.ptitroyaldemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

import example.ken.ptitroyaldemo.model.Post;
import example.ken.ptitroyaldemo.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    private List<Post> posts;
    private RecyclerView rvStudyPosts;
    private PostsAdapter adapter;
    private View rootView;
    private SwipyRefreshLayout swipyRefreshStudy;

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_study, container, false);
        rvStudyPosts = (RecyclerView) rootView.findViewById(R.id.rvStudyPosts);
        adapter = new PostsAdapter(getActivity(), posts);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvStudyPosts.setLayoutManager(layoutManager);
        rvStudyPosts.setItemAnimator(new DefaultItemAnimator());
        rvStudyPosts.setAdapter(adapter);

        swipyRefreshStudy = (SwipyRefreshLayout) rootView.findViewById(R.id.swipyRefreshStudy);
        swipyRefreshStudy.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    refresh();
                } else {
                    loadMore();
                }
                swipyRefreshStudy.setRefreshing(false);
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        posts = fakeData();
    }

    private List<Post> fakeData() {
        int i = 1;
        List<Post> list = new ArrayList<>();
        User user2 = new User("2", "Ken", "https://pbs.twimg.com/media/CYHZY4IWsAA4xSD.jpg", "");
        list.add(new Post(String.valueOf(i), MainActivity.user, "1 giờ trước", "This is a test " + i++, "https://apa340.files.wordpress.com/2013/04/anonymous.jpg", 5, 14, false));
        list.add(new Post(String.valueOf(i), user2, "2 giờ trước", "This is a test " + i++, "http://i1274.photobucket.com/albums/y436/Jillwellington/edit27of116_zps85bbba76.jpg", 5, 14, true));
        list.add(new Post(String.valueOf(i), MainActivity.user, "3 giờ trước", "This is a test " + i++, "", 5, 14, false));

        return list;
    }

    private void refresh() {
        Toast.makeText(getActivity(), "Refresh", Toast.LENGTH_SHORT).show();
        posts.addAll(fakeData());
        adapter.notifyDataSetChanged();
    }

    private void loadMore() {
        Toast.makeText(getActivity(), "Load more", Toast.LENGTH_SHORT).show();
    }
}
