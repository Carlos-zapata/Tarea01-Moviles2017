package com.iteso.caflores.tarea01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {

    protected EditText name;
    protected EditText phone;
    protected RadioButton female;
    protected RadioButton male;
    protected AutoCompleteTextView book;
    protected CheckBox athelte;
    protected Spinner scholarship;
    protected Button clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.activity_main_name);
        phone = (EditText) findViewById(R.id.activity_main_phone);
        female = (RadioButton) findViewById(R.id.activity_main_female);
        male = (RadioButton) findViewById(R.id.activity_main_male);
        book = (AutoCompleteTextView) findViewById(R.id.activity_main_book);
        athelte = (CheckBox) findViewById(R.id.activity_main_athlete);
        scholarship = (Spinner) findViewById(R.id.activity_main_scholarship);
        clean = (Button) findViewById(R.id.activity_main_clean);

        clean.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                AlertDialog alertDialog = new AlertDialog.Builder(ActivityMain.this).create();
                alertDialog.setTitle("Limpiar");
                alertDialog.setMessage("¿Desea limpiar el contenido?");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCELAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                name.setText("");
                                phone.setText("");
                                female.setChecked(true);
                                book.setText("");
                                athelte.setChecked(true);
                                scholarship.setSelection(0);
                            }
                        });
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                Alumno student = new Alumno();

                if (name.getText().toString().trim().equals("")) {
                    name.setError(("No se ingresó el nombre"));
                    return false;
                } else
                    student.setName(name.getText().toString());

                if (phone.getText().toString().trim().equals("")){
                    phone.setError(("No se ingresó el teléfono"));
                    return false;
                }
                else
                    student.setPhone(phone.getText().toString());


                student.setScholarship(scholarship.getSelectedItem().toString());

                if(female.isChecked())
                    student.setGendre("Femenino");
                else
                    student.setGendre("Masculino");

                if(book.getText().toString().trim().equals("")) {
                    book.setError(("No se ingresó libro favorito"));
                    return false;
                }
                else
                    student.setBook(book.getText().toString());

                if(athelte.isChecked())
                    student.setAthlete("Si");
                else
                    student.setAthlete("No");


                Toast.makeText(this, student.toString(), Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

}


