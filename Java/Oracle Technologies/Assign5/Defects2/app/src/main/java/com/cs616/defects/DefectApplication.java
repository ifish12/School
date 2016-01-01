package com.cs616.defects;

import android.app.Application;
import android.util.Log;

import com.cs616.defects.model.CRUDRepository;
import com.cs616.defects.model.Defect;
import com.cs616.defects.model.SampleData;
import com.cs616.defects.model.User;
import com.cs616.defects.model.stub.StubDefectRepository;
import com.cs616.defects.model.stub.StubUserRepository;

import java.io.IOException;

/**
 * Created by ian on 15-10-26.
 */
public class DefectApplication extends Application {

    public static final int REQUEST_CREATE = 1;
    public static final int REQUEST_EDIT = 2;

    // user and defect repositories
   // private static CRUDRepository<Long, User> userRepository;
//    private static CRUDRepository<Long, Defect> defectRepository;

    // stores the user who is currently using the app, hardcoded for now.
    private static User currentUser;

  //  public static User getCurrentUser() {
        //return currentUser;
   // }

    //public static CRUDRepository<Long, Defect> getDefectRepository() {
      //  return defectRepository;
   // }

  //  public static CRUDRepository<Long, User> getUserRepository() {
    //    return userRepository;
  //  }

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize the repositories to the stub classes.


        // create sample data and retrieve a sample user to be the current user.
        SampleData sampleData = new SampleData(userRepository, defectRepository);
        try {
            sampleData.populate();
            currentUser = (new StubUserRepository().read(1L));
        } catch (IOException e) {
            Log.e("DEFECTS", e.getMessage());
        }
    }
}
