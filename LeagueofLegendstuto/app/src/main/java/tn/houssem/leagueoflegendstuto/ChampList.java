package tn.houssem.leagueoflegendstuto;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChampList extends ArrayAdapter<Champ> {
    public ChampList(Context context, int resource, List<Champ> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Champ champ = getItem(position);
        if(convertView == null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.shapecell, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageviewcell);
        TextView name = convertView.findViewById(R.id.name);
        TextView champname = convertView.findViewById(R.id.champname);
        TextView roles = convertView.findViewById(R.id.roles);
        TextView champroles = convertView.findViewById(R.id.champroles);

        champname.setText(champ.getName());
        champroles.setText(TextUtils.join(", ",champ.getRoles()));
        imageView.setImageResource(champ.getImage());

        return convertView;
    }
}
