package tn.houssem.leagueoflegendstuto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class SpellsFragment extends Fragment {
    public static ArrayList<Spell> spells =new ArrayList<>();
    private ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spells, container, false);
        setupListView(view);
        addDataToList();
        // Inflate the layout for this fragment
        return view;
    }

    private void setupListView(View view) {
        listView = view.findViewById(R.id.listspell);
        SpellsList adapter = new SpellsList(getContext(), R.layout.shapecell, spells);
        listView.setAdapter(adapter);
    }
    private void addDataToList() {
        if(spells.isEmpty())
        {
            //add 5 spells
            spells.add(new Spell(1,"Heal", "heal your champion", R.drawable.heal));
            spells.add(new Spell(2,"Flash", "flash your champion", R.drawable.flash));
            spells.add(new Spell(3,"Teleport", "teleport your champion", R.drawable.teleport));
        }

    }

}