package com.pavelwinter.myorganizer.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.pavelwinter.myorganizer.R;

import timber.log.Timber;

public class BaseFragment extends Fragment {

    private AlertDialog b;

    /**
     * @param fragment we go to here
     * @param bundle info go with
     * */
    public void goToAnotherFragment(Fragment fragment, Bundle bundle){
        try {
            String fragmentTag = fragment .getClass() .getSimpleName();
            Fragment fragmentBackStack = getFragmentManager() .findFragmentByTag(fragmentTag);
            if(fragmentBackStack != null){
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment ,fragmentTag)
                        .addToBackStack(null)
                        .commit();
            }else {
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment ,fragmentTag)
                        .addToBackStack(null)
                        .commit();
            }
        } catch (Exception e){

        }
    }




    public void showProgressbar(){
        try{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = (LayoutInflater) getActivity() .getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View dialogView = inflater.inflate(R.layout.dialog_progress_layout, null);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setCancelable(true);
            b = dialogBuilder.create();
            b.show();
        }catch (Throwable throwable){ Timber.e(throwable .getMessage());
        }
    }


    public void hideProgressbar(){
        try {
            b .dismiss();
        }catch (Throwable throwable){ Timber .e(throwable .getMessage());
        }
    }



    /**
     * 2 second long
     * */
    public void showShortMessage(String message){
        try {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }catch (Exception e){}
    }



    /**
     * 3,5 second long
     * */
    public void showLongMessage(String message){
        try {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }catch (Exception e){}
    }


}
