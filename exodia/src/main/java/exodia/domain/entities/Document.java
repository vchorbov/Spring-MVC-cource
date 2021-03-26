package exodia.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document extends BaseEntity{
    private String title;
    private String content;

    public Document(){

    }

    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="content",  length = 8000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
