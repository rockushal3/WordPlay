package np.com.manishbista.wordplay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import np.com.manishbista.wordplay.R;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersHolder> {

    Context context;
    private Character[] characterList;

    public CharactersAdapter(Context context, Character[] characterList) {
        this.context = context;
        this.characterList = characterList;
    }


    @NonNull
    @Override
    public CharactersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_linear, parent,false);
        CharactersHolder charHolder = new CharactersHolder(view);
        return charHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersHolder holder, int position) {
        holder.txtChar.setText(characterList[position]);
    }


    @Override
    public int getItemCount() {
        return characterList.length;
    }

    public class CharactersHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView txtChar;

        public CharactersHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout_linear);
            txtChar = itemView.findViewById(R.id.txtChar);
        }
    }
}
