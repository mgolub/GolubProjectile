package golub.projectile;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Projectile p = new Projectile(Double.parseDouble(userAngle.getText().toString()),
                         Double.parseDouble(userVelocity.getText().toString()),
                        Double.parseDouble(userTime.getText().toString()));
                double x = p.getX();
                double y = p.getY();
                answer.setText("X = " + x + " Y = " + y);

            }
        });
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
    @Override
    protected void onResume() {
        super.onResume();

    }



}
