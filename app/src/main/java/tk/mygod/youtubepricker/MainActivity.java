package tk.mygod.youtubepricker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri data = getIntent().getData();
        if (data != null) {
            String path = "https://u.f-q.me" + data.getEncodedPath();
            String temp = data.getEncodedQuery();
            if (temp != null) path += '?' + temp;
            if ((temp = data.getEncodedFragment()) != null) path += '#' + temp;
            if (!TextUtils.isEmpty(path)) startActivity(new Intent().setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, path).setType("text/plain"));
        }
        finish();
    }
}
