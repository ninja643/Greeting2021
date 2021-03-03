package rs.ac.ni.pmf.android.greeting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialog extends DialogFragment
{
	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState)
	{
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		final String[] values = {"One", "Two", "Three", "Four"};

		return builder.setTitle("Pick a value")
				.setSingleChoiceItems(values, -1, (dialog, which) -> {
					Log.i("GREETING_TAG", "Selected item: " + values[which]);
				})
				.setPositiveButton(R.string.dialog_yes, ((dialog, which) -> {}))
				.setNegativeButton(R.string.dialog_no, ((dialog, which) -> {}))
				.create();
	}
}
