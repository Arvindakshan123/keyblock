package com.example.customkeyboard;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyboardShortcutGroup;
import android.view.inputmethod.InputConnection;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    boolean iscaps = false;
    public KeyboardView onCreateInputView() {
        // get the KeyboardView and ad  d our Keyboard layout to it
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }
    public void onKey(int primaryCode, int[] keyCodes) {

        //Log.d("vv important", getCurrentInputConnection().toString());

        //old logic
        InputConnection ic = getCurrentInputConnection();


        Log.d("Connectiong information", ic.toString());

        if (primaryCode == Keyboard.KEYCODE_DELETE) {
            CharSequence selectedText = ic.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                ic.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                ic.commitText("", 1);
            }
        }

        //new logic
    }

    public void onPress(int primaryCode) {
        InputConnection ic = getCurrentInputConnection();

        Log.d("Connectiong information", ic.toString());
        getBackgroudapps.GetApps(this);

        if (primaryCode == Keyboard.KEYCODE_SHIFT) {
            iscaps = !iscaps;
        } else {
            if (iscaps) {
                char code = (char) primaryCode;
                ic.commitText(String.valueOf(code), 1);
            } else {
                if (!(primaryCode > 48 && primaryCode < 58 || primaryCode == 33 || primaryCode == 64 || primaryCode == 42 || primaryCode == 40 || primaryCode == 41 || primaryCode == 32 || primaryCode == 46 || primaryCode == 10 || primaryCode == -1)) {
                    char code = (char) (primaryCode-32);
                    Log.d("vv important", String.valueOf(primaryCode - 32));
                    ic.commitText(String.valueOf(code), 1);
                } else {
                    char code = (char) (primaryCode);
                    Log.d("vv important", String.valueOf(primaryCode));
                    ic.commitText(String.valueOf(code), 1);
                }

            }
        }

    }


    public void onRelease(int primaryCode) { }


    public void onText(CharSequence text) { }


    public void swipeLeft() { }


    public void swipeRight() { }


    public void swipeDown() { }


    public void swipeUp() { }
}
