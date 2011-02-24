/*
 * Copyright 2011 YAMAZAKI Makoto <makoto1975@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id$
 */
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