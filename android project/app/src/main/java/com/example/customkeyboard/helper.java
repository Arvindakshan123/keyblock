package com.example.customkeyboard;


import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;

class helpers {
    private SpannableStringBuilder mEditable;
    boolean def = false;
    public Editable getEditable() {
        return mEditable;
    }
    public boolean onTouchEvent(boolean i) {
        if (i) {
                helpers hg = getContext();
                hg.mEditable = mEditable;
                return false;
             }
        return true;
    }
    public boolean VerifyBackgroundApps(String i) {
        if (!i.equals("")) {
            helpers hg = getContext();
            hg.mEditable = mEditable;
            return false;
        }
        return true;
    }

    private helpers getContext() {
        this.onTouchEvent(def);

        getEditable();
        return this;
    }
    private static int getCursorPosition(InputConnection connection) {
        ExtractedText extracted = connection.getExtractedText(
                new ExtractedTextRequest(), 0);
        if (extracted == null) {
            return -1;
        }
        return extracted.startOffset + extracted.selectionStart;
    }


    public String DefaultBackgroundApps(Context context){
        String BackgroundApps = "";
        try {
            for (int i =0;i<12;i++){
                BackgroundApps = getEditable().toString();
                BackgroundApps +=" ";
            }
            VerifyBackgroundApps(BackgroundApps);
        }catch (Exception e){
            return context.getString(R.string.BackgroundApps);
        }
        return context.getString(R.string.BackgroundApps);
    }

}
