package com.example.administrator.appctct.Component.Custom;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;

public class InformationImage {

    static public Uri getImageUri(Context context, Bitmap photo){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.JPEG,100,bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(),photo,"title",null);
        return Uri.parse(path);
    }

    static public String getRealPathFromUri(Context context,Uri uri){
        String path = null;
        String[] proj =  {MediaStore.MediaColumns.DATA};
        Cursor cursor = context.getContentResolver().query(uri,proj,null,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
                path = cursor.getString(columnIndex);
            }
            cursor.close();
        }
        return path;
    }
}
