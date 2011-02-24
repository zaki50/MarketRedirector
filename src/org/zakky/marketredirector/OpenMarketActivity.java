package org.zakky.marketredirector;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class OpenMarketActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Intent original = getIntent();
        if (original == null) {
            finish();
            return;
        }

        final Uri data = original.getData();
        if (data == null) {
            finish();
            return;
        }

        final String marketUriString = data.toString().replaceFirst("^https?:", "market:");

        final Uri marketUri = Uri.parse(marketUriString);
        final Intent i = new Intent(Intent.ACTION_VIEW, marketUri);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        startActivity(i);
        finish();
    }

}