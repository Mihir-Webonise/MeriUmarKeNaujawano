package sqlite.list.project;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EmployeesDataSource {
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_EMPNAME, MySQLiteHelper.COLUMN_AGE };
	
	public EmployeesDataSource(Context context) {
		// TODO Auto-generated constructor stub
		dbHelper = new MySQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Employee createEmployee(String empname, int age) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_EMPNAME, empname);
		values.put(MySQLiteHelper.COLUMN_AGE, age);
		long insertId = database.insert(MySQLiteHelper.TABLE_EMPLOYEES, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_EMPLOYEES,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Employee newComment = cursorToEmployee(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteEmployee(Employee employee) {
		long id = employee.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_EMPLOYEES, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_EMPLOYEES,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Employee employee = cursorToEmployee(cursor);
			employees.add(employee);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return employees;
	}

	private Employee cursorToEmployee(Cursor cursor) {
		Employee employee = new Employee();
		employee.setId(cursor.getLong(0));
		employee.setEmpName(cursor.getString(1));
		employee.setAge(cursor.getInt(2));
		return employee;
	}

}
