package io.github.filipebezerra.livetalking.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 *
 * @author Filipe Bezerra
 * @version 0.0.1
 * @since 24/11/2014
 */
public class NameActivity extends Activity {

    private Button btnJoin;
    private EditText txtName;
    private TextView txtAuthorUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        btnJoin = (Button) findViewById(R.id.btnJoin);
        txtName = (EditText) findViewById(R.id.name);
        txtAuthorUrl = (TextView) findViewById(R.id.textAuthorUrl);
        Linkify.addLinks(txtAuthorUrl, Linkify.ALL);

        // Hiding the action bar
        getActionBar().hide();

        btnJoin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtName.getText().toString().trim().length() > 0) {

                    String name = txtName.getText().toString().trim();

                    Intent intent = new Intent(NameActivity.this,
                            MainActivity.class);
                    intent.putExtra("name", name);

                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
