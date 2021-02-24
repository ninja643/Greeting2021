package rs.ac.ni.pmf.android.greeting;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity
{
	public static final String TAG = "GREETING_TAG";

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
	}

	public void greet(View view)
	{
		final String name = _editName.getText().toString();
		final String message = getResources().getString(R.string.greet_message, name);

		_labelGreet.setText(message);
	}
}