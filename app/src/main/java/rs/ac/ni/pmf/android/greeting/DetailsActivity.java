package rs.ac.ni.pmf.android.greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
		final String name = intent.getStringExtra(C.name.KEY_FIRST_NAME);

		if (name != null)
		{
			_editFirstName.setText(name);
		}
	}

	public void cancel(View view)
	{
		setResult(RESULT_CANCELED);
		finish();
	}

	public void save(View view)
	{
		final Intent resultIntent = new Intent();

		final Person person = new Person(_editFirstName.getText().toString(), _editLastName.getText().toString());

		resultIntent.putExtra(C.name.KEY_PERSON, person);

		setResult(RESULT_OK, resultIntent);
		finish();
	}
}