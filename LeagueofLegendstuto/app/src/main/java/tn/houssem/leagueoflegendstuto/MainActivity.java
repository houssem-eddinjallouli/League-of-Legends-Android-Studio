package tn.houssem.leagueoflegendstuto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    FrameLayout leagueoflegendsframelayout;
    Button championbtn, spellbtn, infobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        leagueoflegendsframelayout = findViewById(R.id.framelayoutcontainer);
        championbtn = findViewById(R.id.championbtn);
        spellbtn = findViewById(R.id.spellbtn);
        infobtn = findViewById(R.id.infobtn);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayoutcontainer, new ChampionsFragment()).commit();
        championbtn.setOnClickListener(v -> getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutcontainer, new ChampionsFragment()).commit());
        spellbtn.setOnClickListener(v -> getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutcontainer, new SpellsFragment()).commit());
        infobtn.setOnClickListener(v -> getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutcontainer, new InfosFragment()).commit());
    }
}