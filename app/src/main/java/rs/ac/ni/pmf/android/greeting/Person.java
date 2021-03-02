package rs.ac.ni.pmf.android.greeting;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable
{
	public static final Creator<Person> CREATOR = new Creator<Person>()
	{
		@Override
		public Person createFromParcel(Parcel in)
		{
			return new Person(in);
		}

		@Override
		public Person[] newArray(int size)
		{
			return new Person[size];
		}
	};
	private final String firstName;
	private final String lastName;
	private final int age;

	public Person(final String firstName, final String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		age = 0;
	}

	public Person(final String firstName, final String lastName, final int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	protected Person(Parcel in)
	{
		firstName = in.readString();
		lastName = in.readString();
		age = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(firstName);
		dest.writeString(lastName);
		dest.writeInt(age);
	}

	@Override
	public int describeContents()
	{
		return 0;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public Integer getAge()
	{
		return age;
	}
}
