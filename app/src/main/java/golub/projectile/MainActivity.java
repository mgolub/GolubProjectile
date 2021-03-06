package golub.projectile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

   private TextView angle;
    private TextView velocity;
    private TextView time;
    private EditText userAngle;
    private EditText userVelocity;
    private EditText userTime;
    private Button buttonCalculate;
    private TextView answer;
    private ImageView imageView1;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = this.getSharedPreferences("DEFAULT",MODE_PRIVATE);


        imageView1 = (ImageView) findViewById(R.id.imageView1);

        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView1);

        angle = (TextView) findViewById(R.id.angle);
        userAngle = (EditText)findViewById(R.id.userAngle);
        velocity = (TextView) findViewById(R.id.velocity);
        userVelocity = (EditText)findViewById(R.id.userVelocity);
        time = (TextView) findViewById(R.id.time);
        userTime = (EditText)findViewById(R.id.userTime);
        buttonCalculate = (Button)findViewById(R.id.buttonCalculate);
        answer = (TextView)findViewById(R.id.answer);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer();

            }
        });
    }
    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ANGLE", userAngle.getText().toString());
        editor.putString("VELOCITY", userVelocity.getText().toString());
        editor.putString("TIME", userTime.getText().toString());
        editor.apply();

    }


    @Override
    public void onResume(){
        super.onResume();

        userAngle.setText(preferences.getString("ANGLE",""));
        userVelocity.setText(preferences.getString("VELOCITY",""));
        userTime.setText(preferences.getString("TIME",""));


    }

    private void showAnswer() {


        Intent intent = new Intent(this, AnswerActivity.class);
        double angle = Double.parseDouble(userAngle.getText().toString());
        double velocity = Double.parseDouble(userVelocity.getText().toString());
        double time = Double.parseDouble(userTime.getText().toString());
        intent.putExtra("ANGLE", angle);
        intent.putExtra("VELOCITY", velocity);
        intent.putExtra("TIME", time);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
