package com.surber.matthew.emphasis;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by wo1624bu on 9/27/16.
 */
public class EmphasisFragment extends DialogFragment {

    private final static String MESSAGE_ARG = "Emphasis text";
    boolean[] checked_items = {false, false, false};
    final CharSequence[] EMPHASIS_CHOICES = {"Capitalize","Add Exclamation Points", "Add Smiley Face"};

    public EmphasisFragment newInstance(String text){
        EmphasisFragment fragment = new EmphasisFragment();
        Bundle args =  new Bundle();
        args.putString(MESSAGE_ARG, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String message = getArguments().getString(MESSAGE_ARG);
        if (message == null) {
            message = "No text entered.";
        }
        final String FINAL_MESSAGE = message;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("What emphasis would you like?")
                .setMultiChoiceItems(EMPHASIS_CHOICES, checked_items, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean checked) {
                        checked_items[which] = checked;
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showResult(FINAL_MESSAGE);
                    }
                });
        return builder.create();
    }

    public void showResult(String rawText){

        String emphasizedText = rawText;

        if(checked_items[0]){
            emphasizedText = emphasizedText.toUpperCase();
        }
        if(checked_items[1]){
            emphasizedText += "!!!!";
        }
        if(checked_items[2]){
            emphasizedText += " :)";
        }

        AlertDialog.Builder emphBuilder = new AlertDialog.Builder(getActivity());
        emphBuilder.setTitle("Your emphasised text is...")
                .setMessage(emphasizedText)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                }).create().show();
    }
}
