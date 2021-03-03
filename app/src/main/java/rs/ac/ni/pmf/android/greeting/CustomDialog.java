package rs.ac.ni.pmf.android.greeting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialog extends DialogFragment
{
	public interface CustomDialogClickListener
	{
		void onYes(String username, String password);
	}

	private CustomDialogClickListener _listener;

	@Override
	public void onAttach(@NonNull final Context context)
	{
		super.onAttach(context);

		_listener = (CustomDialogClickListener) context;
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState)
	{
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final LayoutInflater layoutInflater = requireActivity().getLayoutInflater();

		final View customLayout = layoutInflater.inflate(R.layout.custom_dialog, null);
		final EditText editUsername = customLayout.findViewById(R.id.username);
		final EditText editPassword = customLayout.findViewById(R.id.password);

		builder.setView(customLayout)
				.setPositiveButton(R.string.dialog_yes, ((dialog, which) -> {
					final String username = editUsername.getText().toString();
					final String password = editPassword.getText().toString();

					_listener.onYes(username, password);
				}))
				.setNegativeButton(R.string.dialog_no, ((dialog, which) -> {}));

		return builder.create();
	}
}
