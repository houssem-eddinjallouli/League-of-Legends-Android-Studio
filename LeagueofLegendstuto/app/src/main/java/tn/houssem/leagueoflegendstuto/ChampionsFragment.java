package tn.houssem.leagueoflegendstuto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class ChampionsFragment extends Fragment {
    public static ArrayList<Champ> champions =new ArrayList<>();
    private ListView listView;
    private SearchView searchView;
    private Button allfilter;
    private ImageView topfilter;
    private ImageView junglefilter;
    private ImageView middlefilter;
    private ImageView adcfilter;
    private ImageView supportfilter;
    private String currentsearchtext = "";
    private String selectedfilter = "all";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champions, container, false);
        setupListView(view);
        addDataToList();
        initsearchView(view);
        initialisefilter(view);
        allfilter.setOnClickListener(houssem->{
            filterbyall(view);
        });
        topfilter.setOnClickListener(houssem->{
            filterbytop(view);
        });

        junglefilter.setOnClickListener(houssem->{
            filterbyjungle(view);
        });

        middlefilter.setOnClickListener(houssem->{
            filterbymiddle(view);
        });
        adcfilter.setOnClickListener(houssem->{
            filterbyadc(view);
        });
        supportfilter.setOnClickListener(houssem->{
            filterbysupport(view);
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void initialisefilter(View view) {
        allfilter = view.findViewById(R.id.allfilter);
        topfilter = view.findViewById(R.id.topfilter);
        junglefilter = view.findViewById(R.id.junglefilter);
        middlefilter = view.findViewById(R.id.middlefilter);
        adcfilter = view.findViewById(R.id.adcfilter);
        supportfilter = view.findViewById(R.id.supportfilter);

    }

    private void initsearchView(View view) {
        searchView = view.findViewById(R.id.searchchamp);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentsearchtext=s;
                ArrayList<Champ> filteredList = new ArrayList<>();
                for(Champ champ : champions)
                {
                    if(champ.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        filteredList.add(champ);
                    }
                }
                ChampList adapter = new ChampList(getContext(), R.layout.shapecell, filteredList);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }

    private void addDataToList() {
        if(champions.isEmpty())
        {
            champions.add(new Champ(1,"Ahri", new String[]{"Mage"}, R.drawable.ahri));
            champions.add(new Champ(2,"Akali", new String[]{"Assassin"}, R.drawable.akali));
            champions.add(new Champ(3,"Alistar", new String[]{"Tank", "Support"}, R.drawable.alistar));
            champions.add(new Champ(4,"Amumu", new String[]{"Tank"}, R.drawable.amumu));
            champions.add(new Champ(5,"Anivia", new String[]{"Mage"}, R.drawable.anivia));
            // add with more then one role
            champions.add(new Champ(6,"Annie", new String[]{"Mage", "Fighter"}, R.drawable.annie));
            champions.add(new Champ(7,"Ashe", new String[]{"Marksman", "ADC"}, R.drawable.ashe));
            //add 10 champs
            champions.add(new Champ(8,"Aurelion Sol", new String[]{"Mage"}, R.drawable.aurelionsol));
            champions.add(new Champ(9,"Azir", new String[]{"Mage"}, R.drawable.azir));
            champions.add(new Champ(10,"Bard", new String[]{"Support"}, R.drawable.bard));
            champions.add(new Champ(11,"Blitzcrank", new String[]{"Tank"}, R.drawable.blitzcrank));
            champions.add(new Champ(12,"Brand", new String[]{"Mage"}, R.drawable.brand));
            champions.add(new Champ(13,"Braum", new String[]{"Tank"}, R.drawable.braum));
        }
    }

    private void setupListView(View view) {
        listView = view.findViewById(R.id.listchamp);
        ChampList adapter = new ChampList(getContext(), R.layout.shapecell, champions);
        listView.setAdapter(adapter);
    }
    public void filterList(String role){
        selectedfilter=role;
        ArrayList<Champ> filteredList = new ArrayList<>();
        for(Champ champ : champions){
            for(String r : champ.getRoles()){
                if(r.equals(role)){
                    if(currentsearchtext=="")
                    {
                        filteredList.add(champ);

                    }
                    else {
                        if(champ.getName().toLowerCase().contains(currentsearchtext.toLowerCase()))
                        {
                            filteredList.add(champ);
                        }
                    }
                }
            }
        }
        ChampList adapter = new ChampList(getContext(), R.layout.shapecell, filteredList);
        listView.setAdapter(adapter);
    }
    public void filterbyall(View view){
        selectedfilter="all";
        searchView.setQuery("", false);
        searchView.clearFocus();

        ChampList adapter = new ChampList(getContext(), R.layout.shapecell, champions);
        listView.setAdapter(adapter);
    }
    public void filterbytop(View view){
        filterList("Top");
    }
    public void filterbyjungle(View view){
        filterList("Jungle");
    }
    public void filterbymiddle(View view){
        filterList("Mid");
    }
    public void filterbyadc(View view){
        filterList("ADC");
    }
    public void filterbysupport(View view){
        filterList("Support");
    }
}