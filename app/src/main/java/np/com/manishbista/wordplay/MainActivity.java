package np.com.manishbista.wordplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

import np.com.manishbista.wordplay.adapters.CharactersAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] words = {"enormity", "literally", "colonel", "lieutenant", "unabashed", "alcoholic"};
    private EditText etWord;
    private RecyclerView recyclerView;

    private int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = findViewById(R.id.btnOK);
        Button btnClean = findViewById(R.id.btnClean);
        etWord = findViewById(R.id.etWord);
        recyclerView = findViewById(R.id.recyclerView);

//        listWords = findViewById(R.id.listWords);
//        showWord(level);


        CharactersAdapter charactersAdapter = new CharactersAdapter(MainActivity.this, shuffleWords(level));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(charactersAdapter);
        recyclerView.setLayoutManager(layoutManager);

        btnOK.setOnClickListener(this);
        btnClean.setOnClickListener(this);

//        listWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                etWord.append(parent.getItemAtPosition(position).toString());
//            }
//        });
    }

    private Character[] shuffleWords(int level){
//        char[] word = words[level].toCharArray();
        Character[] word = {'a', 'b', 'c'};

        ArrayList<Character> chars = new ArrayList<>(word.length);
        for(char c: word){
            chars.add(c);
        }

        Collections.shuffle(chars);
        Character[] shuffledWord = new Character[chars.size()];

        for(int i=0; i<shuffledWord.length; i++ ){
            shuffledWord[i] = chars.get(i);
        }
        return shuffledWord;
    }

//    private void showWord(int i){
//        Character[] word = shuffleWords(words[i]);
//        ArrayAdapter<Character> wordAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_words, word);
//        listWords.setAdapter(wordAdapter);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOK:
                break;

            case R.id.btnClean:
                etWord.getText().clear();
                break;
        }
    }
}
