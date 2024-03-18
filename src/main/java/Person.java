import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {

    private String id;
    private String name;
    private List<Address> addresses;


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!=Person.class) {
            return false;
        }
        return Objects.equals(((Person) obj).getId(), this.getId());
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.getId());
    }
}
