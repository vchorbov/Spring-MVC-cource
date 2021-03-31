package application.residentEvil.domain.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@MappedSuperclass
public abstract class BaseEntity {

    private String id;

    public BaseEntity(){
    }

    @Id
    @Column(name="id", nullable = false, unique = true, updatable = false)
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
