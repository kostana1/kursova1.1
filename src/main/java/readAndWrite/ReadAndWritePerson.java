package readAndWrite;

import com.enumex.EGender;
import com.enumex.EStatus;
import com.person.Person;

import java.util.Date;

public class ReadAndWritePerson extends Person{

    public ReadAndWritePerson(String name, EGender gender, Date dateOfBirth, String interests, EStatus status) {
        super(name, gender, dateOfBirth, interests, status);
    }
}
