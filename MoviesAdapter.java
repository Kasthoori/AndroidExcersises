package application.ucsc.com.expandablemovieslist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HP on 5/23/2017.
 */

public class MoviesAdapter extends BaseExpandableListAdapter{


    private Context ctx;
    private HashMap<String, List<String>> Movies_Category;
    private List<String> Movies_List;


    public MoviesAdapter(Context ctx, HashMap<String, List<String>> movies_Category, List<String> movies_List) {
        this.ctx = ctx;
        Movies_Category = movies_Category;
        Movies_List = movies_List;
    }

    @Override
    public int getGroupCount() {
        return Movies_List.size();
    }

    @Override
    public int getChildrenCount(int arg0) {
        return Movies_Category.get(Movies_List.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {
        return Movies_List.get(arg0);
    }

    @Override
    public Object getChild(int parent, int child) {
        return Movies_Category.get(Movies_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {

        String group_title = (String) getGroup(parent);

        if(convertview == null){

            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.parent_layout, parentview, false);

        }

        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null,Typeface.BOLD);
        parent_textview.setText(group_title);

        return convertview;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview, ViewGroup parentview) {

        String child_title = (String) getChild(parent, child);

        if(convertview == null){

            LayoutInflater  inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.child_layout, parentview, false);
        }

        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_title);



        return convertview;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
