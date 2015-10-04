package skilleen.snakeplanet;

import java.util.ArrayList;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import skilleen.snakeplanet.Model.SnakeModel;

/**
 * Created by Scilleen on 9/30/2015.
 */

public class SnakeAdapter extends ArrayAdapter<SnakeModel> {

    private final Context context;
    private final ArrayList<SnakeModel> itemsArrayList;

    public SnakeAdapter(Context context, ArrayList<SnakeModel> itemsArrayList) {

        super(context, R.layout.snake_listview, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Get rowView from inflater
        View rowView = inflater.inflate(R.layout.snake_layout, parent, false);


        TextView labelView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.snakeListImage);


        labelView.setText(itemsArrayList.get(position).getName());
        imageView.setImageResource(itemsArrayList.get(position).getPicture());


        return rowView;
    }
}
