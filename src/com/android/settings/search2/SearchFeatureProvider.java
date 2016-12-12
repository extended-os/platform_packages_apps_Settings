/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.search2;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;

/**
 * FeatureProvider for Settings Search
 */
public interface SearchFeatureProvider {

    /**
     * @return true to use the new version of search
     */
    boolean isEnabled();

    /**
     * Inserts the Menu items into Settings activity.
     *
     * @param menu Items will be inserted into this menu.
     * @param activity The activity that precedes SearchActivity.
     */
    void setUpSearchMenu(Menu menu, Activity activity);

    /**
     * Returns a new loader to search in index database.
     */
    DatabaseResultLoader getDatabaseSearchLoader(Context context, String query);

    /**
     * Returns a new loader to search installed apps.
     */
    InstalledAppResultLoader getInstalledAppSearchLoader(Context context, String query);

    /**
     * Returns the manager for indexing Settings data.
     */
    DatabaseIndexingManager getIndexingManager(Context context);

    /**
     * Updates the Settings indexes
     */
    void updateIndex(Context context);
}