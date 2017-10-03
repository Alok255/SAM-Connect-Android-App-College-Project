package location.com.mgiconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SuccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succ);

        findViewById(R.id.staus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccActivity.this,StausActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.finger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccActivity.this,FingerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.leave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccActivity.this,LeaveActivity.class);
                startActivity(intent);
            }
        });
    }
}
