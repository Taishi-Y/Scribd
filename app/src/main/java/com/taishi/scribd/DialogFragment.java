package com.taishi.scribd;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.tvbarthel.lib.blurdialogfragment.BlurDialogFragment;
import fr.tvbarthel.lib.blurdialogfragment.SupportBlurDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends SupportBlurDialogFragment {


	TextView tvDescription,tvTitle;

	String description,title;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_dialog, container, false);

		tvDescription = (TextView) v.findViewById(R.id.tv_description);
		tvTitle = (TextView) v.findViewById(R.id.tv_title);

		tvDescription.setText(description);
		tvTitle.setText(title);

		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle bundle = getArguments();
		description = bundle.getString("DESCRIPTION");
		title = bundle.getString("TITLE");


	}


	@Override
	protected float getDownScaleFactor() {
		// Allow to customize the down scale factor.
		return 8.0f;
	}

	@Override
	protected int getBlurRadius() {
		// Allow to customize the blur radius factor.
		return 8;
	}

	@Override
	protected boolean isActionBarBlurred() {
		// Enable or disable the blur effect on the action bar.
		// Disabled by default.
		return true;
	}

	@Override
	protected boolean isDimmingEnable() {
		// Enable or disable the dimming effect.
		// Disabled by default.
		return false;
	}

	@Override
	protected boolean isRenderScriptEnable() {
		// Enable or disable the use of RenderScript for blurring effect
		// Disabled by default.
		return false;
	}

	@Override
	protected boolean isDebugEnable() {
		// Enable or disable debug mode.
		// False by default.
		return false;
	}

	public DialogFragment() {
		// Required empty public constructor
	}
}
