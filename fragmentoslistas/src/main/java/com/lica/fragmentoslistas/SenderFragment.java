package com.lica.fragmentoslistas;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SenderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SenderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SenderFragment extends Fragment {


    private Comunicator myActivityParent;


    public SenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false);
    }

     @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myActivityParent = (Comunicator) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Comunicator");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myActivityParent = null;
    }

    public void senData(){
        String superHeroName = ((EditText) ((Activity) myActivityParent).findViewById(R.id.txtBoxSender)).getText().toString();

        if(!superHeroName.isEmpty()){
            ((EditText) ((Activity) myActivityParent).findViewById(R.id.txtBoxSender)).setText("");
            myActivityParent.receiverNameSuperHero(superHeroName);
        }
    }

}
