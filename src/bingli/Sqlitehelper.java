package bingli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlitehelper extends SQLiteOpenHelper{

	public Sqlitehelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public Sqlitehelper(Context context, CursorFactory factory) {
		super(context, "myBingLi", factory, 1);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table bingli(" +
				"id integer primary key autoincrement," +
				"name varchar(20)," +
				"leixing varchar(20)," +
				"hospital varchar(20)," +
				"keshi varchar(20)," +
				"doctor varchar(20)," +
				"juti varchar(50)," +
				"jianyi varchar(50))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
