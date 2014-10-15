package team.envie.fashion.enviefashion.view.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;

public class CustomProgressDialog extends DialogFragment{
    private static ProgressDialog progressDialog;

    public static CustomProgressDialog newInstance(String title, String message){
        CustomProgressDialog instance = new CustomProgressDialog();

        Bundle arguments = new Bundle();
        arguments.putString("title", title);
        arguments.putString("message", message);

        instance.setArguments(arguments);

        return instance;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        if (progressDialog != null)
            return progressDialog;

        String title = getArguments().getString("title");
        String message = getArguments().getString("message");

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        setCancelable(false);

        return progressDialog;
    }

    @Override
    public Dialog getDialog(){
        return progressDialog;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        progressDialog = null;
    }
}
