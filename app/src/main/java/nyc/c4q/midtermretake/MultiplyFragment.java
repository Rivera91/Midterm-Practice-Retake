package nyc.c4q.midtermretake;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultiplyFragment extends Fragment {
    private View rootView;
    private TextView numberTextView;


    public MultiplyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_multiply, container, false);
        numberTextView = rootView.findViewById(R.id.text_view_multiply);

        Bundle bundle = getArguments();
        String numberFromBundle = bundle.getString("number");
        int n = Integer.valueOf(numberFromBundle) * 1000;
        numberTextView.setText(String.valueOf(n));
        return rootView;
    }

}
