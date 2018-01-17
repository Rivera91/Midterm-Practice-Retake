package nyc.c4q.midtermretake;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView loopDisplay;
    private EditText startingLoopInput;
    private Button checkLoop;
    private Button next;
    private String userInput;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); }


    public void Next(View view) {

        Button next = (Button) findViewById(R.id.next);

        Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginActivity);

        userInput = startingLoopInput.getText().toString();
        if (startingLoopInput.getText().toString().isEmpty()) {
            startingLoopInput.setError("Enter a Number");
            startingLoopInput.requestFocus();
        } else {
            try {
                num = Integer.parseInt(userInput);
                AsyncTaskLoop pc = new AsyncTaskLoop();
                pc.execute(num);
            } catch (NumberFormatException e) {
                startingLoopInput.setError("Please Enter a Number");
                startingLoopInput.requestFocus();
            }
        }
    }


   private class AsyncTaskLoop extends AsyncTask<Integer, Integer, Integer> {

       private List<Integer> loopList = new ArrayList<>();


        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            loopList.clear();
            loopDisplay.setText("Starting Loop");
            next.setVisibility(View.INVISIBLE);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = num; i < 100000; i++) {
                loopList.add(i);
                publishProgress(loopList.size());

            }
            return loopList.size();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            loopDisplay.setText("Loops completed: " + values[0]);
            next.setVisibility(View.INVISIBLE);

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            loopDisplay.setText("Loops completed: " + integer);
            next.setVisibility(View.VISIBLE);

        }
    }
}




