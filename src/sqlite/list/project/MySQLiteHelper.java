package sqlite.list.project;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_EMPLOYEES = "employees";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_EMPNAME = "empname";
    public static final String COLUMN_AGE = "age";
	private static final String DATABASE_NAME = "empdb.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_EMPLOYEES + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_EMPNAME
			+ " text not null , " + COLUMN_AGE
			+ " integer not null);";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
		onCreate(db);
	}
}
