package rs.ac.ni.pmf.android.greeting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyListDialog extends DialogFragment
{
	private static final String TAG = "GREETING_TAG_LIST";

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState)
	{
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		final String[] values = {"One", "Two", "Three", "Four"};

		builder.setTitle("Pick a value")
				.setItems(values, (dialog, which) -> {
					Log.i(TAG, "Selected item: " + values[which]);
				});

		return builder.create();
	}
}
