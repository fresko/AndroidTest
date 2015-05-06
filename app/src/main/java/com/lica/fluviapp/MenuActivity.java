package com.lica.fluviapp;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by FRESKO2 on 01/05/2015.
 */
public class MenuActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.item2:
                Toast.makeText(this,
                        "Compartiendo...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                break;
            case R.id.item4:
                break;
            case R.id.action_settings:
                break;
        }

        return true;
    }

  }

