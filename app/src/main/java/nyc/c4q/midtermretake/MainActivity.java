package nyc.c4q.midtermretake;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int num;
    private TextView loopDisplay;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Next(View view) {

        Button next = (Button) findViewById(R.id.next);

        Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginActivity);
    }

    private class AsyncTaskLoop extends AsyncTask <Integer, Integer, Integer> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = num; i <100000 ; i++) {


            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            loopDisplay.setText("Loops completed: " + values[0]);

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            loopDisplay.setText("Loops completed: " + integer);
            next.setVisibility(View.VISIBLE);

        }
    }
}
