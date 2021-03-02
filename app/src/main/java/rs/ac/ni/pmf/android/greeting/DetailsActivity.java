package rs.ac.ni.pmf.android.greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity
{
	private EditText _editFirstName;
	private EditText _editLastName;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		_editFirstName = findViewById(R.id.editFirstName);
		_editLastName = findViewById(R.id.editLastName);

		final Intent intent = getIntent();
		final String name = intent.getStringExtra(GreetingActivity.NAME_KEY);

		if (name != null)
		{
			_editFirstName.setText(name);
		}
	}
}