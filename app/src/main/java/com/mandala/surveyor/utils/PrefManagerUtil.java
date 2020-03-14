package com.mandala.surveyor.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManagerUtil {
    public static final String SP_APP = "spApp";
    public static final String SP_CODE_GEDUNG = "codeGedung";
    public static final String SP_CLIENT_CODE = "codeClient";
    public static final String SP_ISLOGIN = "isLogin";
    public static final String SP_CODE_OPS = "codeOps";
    public static final String SP_CODE_PENGELUARAN = "pengeluaranCode";

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public PrefManagerUtil(Context context) {
        sp = context.getSharedPreferences(SP_APP, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveSPString(String keySP, String value) {
        editor.putString(keySP, value);
        editor.apply();
    }

    public void saveSPInt(String keySP, int value) {
        editor.putInt(keySP, value);
        editor.apply();
    }

    public void saveSPBoolean(String keySP, boolean value) {
        editor.putBoolean(keySP, value);
        editor.apply();
    }

    public String getCodeGedung() {
        return sp.getString(SP_CODE_GEDUNG, "");
    }

    public String getCodeClient() {
        return sp.getString(SP_CLIENT_CODE, "");
    }

    public Boolean getIsLogin() {
        return sp.getBoolean(SP_ISLOGIN, false);
    }

    public String getCodeOps() {
        return sp.getString(SP_CODE_OPS, "");
    }

    public String getTypePengeluaranCode() {
        return sp.getString(SP_CODE_PENGELUARAN, "");
    }

}
