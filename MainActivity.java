package application.ucsc.com.expandablemovieslist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    HashMap<String, List<String>> movies_category;
    List<String> movies_list;
    ExpandableListView  exp_list;
    MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        movies_category = DataProvider.getInfo();
        movies_list = new ArrayList<>(movies_category.keySet());

        moviesAdapter = new MoviesAdapter(this, movies_category, movies_list);

        exp_list.setAdapter(moviesAdapter);


    }
}
