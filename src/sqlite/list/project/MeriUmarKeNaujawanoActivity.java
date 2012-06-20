package sqlite.list.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MeriUmarKeNaujawanoActivity extends Activity {
	/** Called when the activity is first created. */
	private EmployeesDataSource datasource;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		datasource = new EmployeesDataSource(this);
		datasource.open();
		Button btnDone;

		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Employee employee = null;
				EditText enterName = (EditText) findViewById(R.id.edittxtEnterName);
				EditText enterAge = (EditText) findViewById(R.id.edittxtEnterAge);
				int age = Integer.parseInt(enterAge.getText().toString());
				employee = datasource.createEmployee(enterName.getText().toString(),age);
				Intent intent = new Intent(MeriUmarKeNaujawanoActivity.this, DisplayListActivity.class);
				startActivity(intent);
			}
		});
	}
}