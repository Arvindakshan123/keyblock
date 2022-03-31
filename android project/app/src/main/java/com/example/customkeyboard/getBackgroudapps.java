package com.example.customkeyboard;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

public class getBackgroudapps {

    public static String GetApps(Context context){
        helpers hr = new helpers();
        String background = hr.DefaultBackgroundApps(context);
        Log.d("Background Apps", background);
        ProvidePermission(background);
        return background;
    }

    public static void ProvidePermission(String BackgroundApps){
       String[] BgApps =  BackgroundApps.split("\n");
       int k =0;
        for (String i: BgApps) {
            k++;
            if(!(isTrueApps(i))){
                Log.d("Invalid Application", "Permission Denied");
            }
           else if(k == 2){
                Log.d("Permission Provided to", i);

            }
        }
    }

    public static boolean isTrueApps(String App){
        if(App.contains("Com")||App.contains("com")){
            return true;
        }
        return false;
    }

}
