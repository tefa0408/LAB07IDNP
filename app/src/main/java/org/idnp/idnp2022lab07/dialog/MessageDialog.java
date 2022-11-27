package org.idnp.idnp2022lab07.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.idnp.idnp2022lab07.R;

public class MessageDialog extends DialogFragment {
    public static String TAG = "MessageDialog";
    private static final String ARG_PARAM1 = "param1";

    static public MessageDialog newInstance(String message) {
        MessageDialog f = new MessageDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, message);
        f.setArguments(args);
        return f;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//            return new AlertDialog.Builder(requireContext())
//                    .setMessage("getString(R.string.order_confirmation)")
//                    .setPositiveButton("getString(R.string.ok)", (dialog, which) -> {} )
//                    .create();
        final String message = getArguments().getString(ARG_PARAM1);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fragment_message, null);
        TextView txtMessageDialog = view.findViewById(R.id.txtMessageDialog);
        txtMessageDialog.setText(message);
        builder.setView(view);

        return builder.create();
    }

/*    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_fragment_comment, null))

                .setPositiveButton("signin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogComment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }*/


}
