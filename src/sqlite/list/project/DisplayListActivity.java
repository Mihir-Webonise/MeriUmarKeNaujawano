package sqlite.list.project;

import java.util.List;

import sqlite.list.project.Employee;
import sqlite.list.project.EmployeesDataSource;
import sqlite.list.project.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DisplayListActivity extends ListActivity{
	private EmployeesDataSource datasource;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displaylist);

		datasource = new EmployeesDataSource(this);
		datasource.open();

		List<Employee> values = datasource.getAllEmployees();

		// Use the SimpleCursorAdapter to show the
		// elements in a ListView
		ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

}
