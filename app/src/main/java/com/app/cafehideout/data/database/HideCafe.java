package com.app.cafehideout.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.cafehideout.data.dao.RatingDao;
import com.app.cafehideout.ui.rating.model.RatingModel;

/**
 * Created by Apoorv Vardhman on 04-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
@Database(entities = {RatingModel.class,},version = 2 ,exportSchema = false)
public abstract class HideCafe extends RoomDatabase {

    public abstract RatingDao ratingDao();

    /*private static HideCafe INSTANCE;
    public static HideCafe getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HideCafe.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HideCafe.class, "apoorv_hide")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen (SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };*/
}
