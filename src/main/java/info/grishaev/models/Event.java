package info.grishaev.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by stas on 16/02/17.
 */
@Entity
//@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
