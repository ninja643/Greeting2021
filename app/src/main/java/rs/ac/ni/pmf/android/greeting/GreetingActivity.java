package rs.ac.ni.pmf.android.greeting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class GreetingActivity extends AppCompatActivity
{
	private static final String TAG = "GREETING_TAG";

	private static final int REQUEST_DETAILS = 1;

	private String _name;

	private EditText _editName;
	private TextView _labelGreet;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greeting_activity);

		_editName = findViewById(R.id.editName);
		_labelGreet = findViewById(R.id.labelGreet);

		findViewById(R.id.buttonGreet).setOnLongClickListener(v -> {
			Log.i(TAG, "Long clicked the button...");
			return true;
		});

		Log.v(TAG, "onCreate()");
		if (savedInstanceState != null)
		{
			Log.d(TAG, "Saved instance: " + savedInstanceState.toString());
			final String name = savedInstanceState.getString(C.name.KEY_FULL_NAME);
			if (name != null)
			{
				_name = name;
				showName();
			}
		}
	}

	private void showName()
	{
		if (_name != null)
		{
			final String message = getResources().getString(R.string.greet_message, _name);
			_labelGreet.setText(message);
		}
	}

	@Override
	protected void onSaveInstanceState(@NonNull final Bundle outState)
	{
		Log.d(TAG, "Saving instance state...");
		if (_name != null)
		{
			outState.putString(C.name.KEY_FULL_NAME, _name);
		}

		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.v(TAG, "onStart()");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.v(TAG, "onResume()");
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.v(TAG, "onRestart()");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.v(TAG, "onPause()");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.v(TAG, "onStop()");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.v(TAG, "onDestroy()");
	}

	public void greet(View view)
	{
		_name = _editName.getText()
				.toString();
		showName();
		showSnackbar();
	}

	public void showDetails(View view)
	{
		_name = _editName.getText()
				.toString();

		final Intent intent = new Intent(this, DetailsActivity.class);
		intent.putExtra(C.name.KEY_FIRST_NAME, _name);

//		startActivity(intent);
		startActivityForResult(intent, REQUEST_DETAILS);
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data)
	{
		switch (requestCode)
		{
			case REQUEST_DETAILS:
				if (resultCode == RESULT_OK)
				{
					if (data == null)
					{
						return;
					}

//					final String firstName = data.getStringExtra(C.name.KEY_FIRST_NAME);
//					final String lastName = data.getStringExtra(C.name.KEY_LAST_NAME);
					final Person person = data.getParcelableExtra(C.name.KEY_PERSON);

					if (person.getFirstName() != null && person.getLastName() != null)
					{
						_name = String.format("%s %s", person.getFirstName(), person.getLastName());
						showName();
					}
				}
				else
				{
					showToast();
					Log.i(TAG, "Action canceled!");
				}
				break;
			default:
				super.onActivityResult(requestCode, resultCode, data);
		}
	}

	private void showSnackbar()
	{
		Snackbar.make(findViewById(R.id.greeting_activity_body), "Hello", Snackbar.LENGTH_LONG)
				.setAction("OK", v -> showToast())
				.show();
	}

	private void showToast()
	{
		//Toast.makeText(this, "Action canceled!", Toast.LENGTH_SHORT).show();
		final Toast toast = new Toast(this);
		toast.setDuration(Toast.LENGTH_LONG);

		final View toastView = getLayoutInflater().inflate(R.layout.toast_message, null);
		TextView firstLine = toastView.findViewById(R.id.toast_first_line);
		TextView secondLine = toastView.findViewById(R.id.toast_second_line);

		firstLine.setText("Action");
		secondLine.setText("canceled!");

		toast.setView(toastView);

		toast.show();
	}
}