package location.com.mgiconnect;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static location.com.mgiconnect.R.id.spinner;

public class LeaveActivity extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemSelectedListener{

    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private Button buttonRegister;
    private Spinner spinnerText;
    private DatePicker datePicker;
    private DatePicker datePicker1;

    private static final String REGISTER_URL = "http://androidloginreg.esy.es/leave_data.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        datePicker = (DatePicker) findViewById(R.id.dpStart);
        datePicker1 = (DatePicker) findViewById(R.id.dpEnd);
        editTextName = (EditText) findViewById(R.id.email);
        editTextUsername = (EditText) findViewById(R.id.sub);

        spinnerText =(Spinner)  findViewById(spinner);
        buttonRegister = (Button) findViewById(R.id.submit);

        buttonRegister.setOnClickListener(this);

        // Spinner click listener
        spinnerText.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Madical");
        categories.add("Vacation");
        categories.add("Other");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerText.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View v) {


        if(v == buttonRegister){
            registerUser();
        }
    }
    private void registerUser() {
        String email = editTextName.getText().toString().trim().toLowerCase();
        String sub = editTextUsername.getText().toString().trim().toLowerCase();

        String spinner = spinnerText.getSelectedItem().toString().trim().toLowerCase();
        String dpStart = datePicker.getYear() + "-" + datePicker.getMonth() + 1 + "-" + datePicker.getDayOfMonth();
        String dpEnd = datePicker1.getYear() + "-" + datePicker1.getMonth() + 1 + "-" + datePicker1.getDayOfMonth();




        register(email,sub,spinner,dpStart,dpEnd);
    }

    private void register(String email, String sub,String spinner,String dpStart,String dpEnd) {
        String urlSuffix = "?name="+email+"&username="+sub+"&spinner="+spinner+"&dpStart="+dpStart+"&dpEnd="+dpEnd;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LeaveActivity.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }

}
