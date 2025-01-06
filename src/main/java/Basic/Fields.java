package Basic;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter

public class Fields {

    private int id;
    private String firstname;
    private String lastname;
    private String email;

    public Fields(int id, @NonNull String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


    public Document toDocument() {
        return new Document("id", this.id)
                .append("firstname", this.firstname)
                .append("lastname", this.lastname)
                .append("email", this.email);
    }
}
