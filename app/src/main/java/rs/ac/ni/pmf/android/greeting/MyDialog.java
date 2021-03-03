package rs.ac.ni.pmf.android.greeting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment
{
	private static final String TAG = "GREETING_TAG_DIALOG";

	public interface MyDialogClickListener
	{
		void onYes(MyDialog dialog);
		void onNo(MyDialog dialog);
		void onNeutral(MyDialog dialog);
	}

	private MyDialogClickListener _listener;
	private int _value;

	@Override
	public void onAttach(@NonNull final Context context)
	{
		super.onAttach(context);

		try
		{
			_listener = (MyDialogClickListener) context;
		}
		catch (final ClassCastException e)
		{
			throw new ClassCastException(context.toString() + " must implement MyDialogClickListener");
		}
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState)
	{
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder
				.setTitle(R.string.dialog_title)
				.setMessage(R.string.dialog_message)
				.setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
					_value = 10;
					_listener.onYes(this);
				})
				.setNeutralButton(R.string.dialog_neutral, ((dialog, which) -> _listener.onNeutral(this)))
				.setNegativeButton(R.string.dialog_no, (dialog, which) -> _listener.onNo(this));

		return builder.create();
	}

	public int getValue()
	{
		return _value;
	}
}
