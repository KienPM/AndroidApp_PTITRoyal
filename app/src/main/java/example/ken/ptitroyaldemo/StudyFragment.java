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

import java.util.ArrayList;
import java.util.List;

import example.ken.ptitroyaldemo.model.Post;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    private List<Post> posts;
    private RecyclerView rvStudyPosts;
    private PostsAdapter adapter;
    private View rootView;

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_study, container, false);
        posts = fakeData();
        rvStudyPosts = (RecyclerView) rootView.findViewById(R.id.rvStudyPost);
        adapter = new PostsAdapter(posts);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvStudyPosts.setLayoutManager(layoutManager);
        rvStudyPosts.setItemAnimator(new DefaultItemAnimator());
        rvStudyPosts.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private List<Post> fakeData() {
        List<Post> list = new ArrayList<>();

        list.add(new Post("Ken", "15:54-16/04/2016", "This is a test", "", 5, 14));
        list.add(new Post("Ken", "15:54-16/04/2016", "This is a test 2", "", 5, 14));

        return list;
    }
}
