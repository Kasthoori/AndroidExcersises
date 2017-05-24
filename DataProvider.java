package application.ucsc.com.expandablemovieslist;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HP on 5/23/2017.
 */

public class DataProvider {

    public static HashMap<String, List<String>> getInfo(){


        HashMap<String, List<String>> moviesDetails = new HashMap<String, List<String>>();
        List<String> action_movies = new ArrayList<String>();

        action_movies.add("Fast and Furies");
        action_movies.add("Die Heart");
        action_movies.add("Death Race");
        action_movies.add("Terminator");
        action_movies.add("Kabali");


        List<String> commedy_movies = new ArrayList<String>();

        commedy_movies.add("Mr. Bean");
        commedy_movies.add("Stepbrothers");
        commedy_movies.add("Ther Other Guy");
        commedy_movies.add("Due Date");
        commedy_movies.add("Taxy");

        List<String> romantic_movies = new ArrayList<String>();

        romantic_movies.add("Titanic");
        romantic_movies.add("The Love");
        romantic_movies.add("Never Leave");
        romantic_movies.add("Rose");
        romantic_movies.add("Sweet Heart");

        List<String> horror_movies = new ArrayList<String>();

        horror_movies.add("Scream");
        horror_movies.add("Conjuring");
        horror_movies.add("Get Out");
        horror_movies.add("The Shiny");
        horror_movies.add("The Last Minute");

        moviesDetails.put("Action", action_movies);
        moviesDetails.put("Comedy", commedy_movies);
        moviesDetails.put("Romantic", romantic_movies);
        moviesDetails.put("Horror", horror_movies);

        return moviesDetails;









    }

}
