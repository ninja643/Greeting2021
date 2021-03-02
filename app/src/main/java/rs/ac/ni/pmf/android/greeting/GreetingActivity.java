package rs.ac.ni.pmf.android.greeting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity
{
	public static final String TAG = "GREETING_TAG";

	public static final String NAME_KEY = "KEY_NAME";

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

		Log.i(TAG, "onCreate()");
		if (savedInstanceState != null)
		{
			Log.i(TAG, "Saved instance: " + savedInstanceState.toString());
			final String name = savedInstanceState.getString(NAME_KEY);
			if (name != null)
			{
				_name = name;
				showName(name);
			}
		}
	}

	private void showName(final String name)
	{
		final String message = getResources().getString(R.string.greet_message, name);
		_labelGreet.setText(message);
	}

	@Override
	protected void onSaveInstanceState(@NonNull final Bundle outState)
	{
		Log.i(TAG, "Saving instance state...");
		if (_name != null)
		{
			outState.putString(NAME_KEY, _name);
		}

		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(TAG, "onStart()");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(TAG, "onResume()");
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.i(TAG, "onRestart()");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "onPause()");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, "onStop()");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "onDestroy()");
	}

	public void greet(View view)
	{
		_name = _editName.getText().toString();

		showName(_name);
	}

	public void showDetails(View view)
	{
		_name = _editName.getText().toString();

		final Intent intent = new Intent(this, DetailsActivity.class);
		intent.putExtra(NAME_KEY, _name);
		startActivity(intent);
	}
}