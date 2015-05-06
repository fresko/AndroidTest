package com.lica.fragmentoslistas;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
  * to handle interaction events.
  * create an instance of this fragment.
 */
public class ReciverFragment extends Fragment {

    Activity myParentActivity;
    List<String> superHeroes;
    ArrayAdapter<String> myAdapter;


    public ReciverFragment() {
        // Required empty public constructor
        superHeroes = new ArrayList<>();
    }
   @Override
   public void onResume(){
      super.onResume();
       ListView lv = (ListView) myParentActivity.findViewById(R.id.listreciver);

       myAdapter = new ArrayAdapter<String>(myParentActivity,android.R.layout.simple_list_item_1,superHeroes);

       lv.setAdapter(myAdapter);
       registerForContextMenu(lv);
   }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        myParentActivity.getMenuInflater()
                .inflate(R.menu.list_context, menu);

     }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(myParentActivity,
                        "Editando...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(myParentActivity,
                        "Eliminando...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(myParentActivity,
                        "Llamando...",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reciver, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myParentActivity =  activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Comunicator");
        }
    }

    public void addToList(String superHeroName) {

        superHeroes.add(superHeroName);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myParentActivity = null;
    }


}
