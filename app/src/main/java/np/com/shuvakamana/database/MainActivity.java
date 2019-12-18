package np.com.shuvakamana.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import np.com.shuvakamana.database.models.Student;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(np.com.manishbista.database.R.layout.activity_main);

        Button btnOK = findViewById(np.com.manishbista.database.R.id.btnOK);
        Button btnDisplay = findViewById(np.com.manishbista.database.R.id.btnDisplay);
        etName = findViewById(np.com.manishbista.database.R.id.etName);
        etEmail = findViewById(np.com.manishbista.database.R.id.etEmail);
        etPhone = findViewById(np.com.manishbista.database.R.id.etPhone);

        dbHelper = new DatabaseHelper(MainActivity.this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();

                boolean sts = dbHelper.insertStudent(new Student(0, name, email, phone));

                if(sts){
                    Toast.makeText(MainActivity.this, "Student Added Successful!", Toast.LENGTH_SHORT).show();
                    etName.getText().clear();
                    etEmail.getText().clear();
                    etPhone.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayStudentsActivity.class);
                startActivity(intent);
            }
        });

    }
}
