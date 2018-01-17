package nyc.c4q.midtermretake.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.midtermretake.ListActivity;
import nyc.c4q.midtermretake.MultiplyFragment;
import nyc.c4q.midtermretake.R;
import nyc.c4q.midtermretake.model.Numbers;

/**
 * Created by AmyRivera on 1/16/18.
 */

public class NumbersViewHolder extends RecyclerView.ViewHolder {
    private TextView numTextView;
    private Context context;

    public NumbersViewHolder(View itemView) {
        super(itemView);
        numTextView = itemView.findViewById(R.id.text_view_number);
    }

    public void onBind(final Numbers numbers) {
        context = itemView.getContext();
        numTextView.setText(String.valueOf(numbers.getN()));
        numTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMultiply();
            }
        });
    }

    public void fragmentMultiply() {
        MultiplyFragment multiplyFragment = new MultiplyFragment();
        FragmentManager fragmentManager =((ListActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_number, multiplyFragment).addToBackStack("number_rv");
        fragmentTransaction.commit();

        String numberToNewFragment = numTextView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("number", numberToNewFragment);
        multiplyFragment.setArguments(bundle);
    }
}
