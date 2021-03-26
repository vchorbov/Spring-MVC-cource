package exodia.models.binding;

import org.springframework.web.bind.annotation.GetMapping;

public class DocumentScheduleBindingModel {
    private String title;
    private String content;

    public DocumentScheduleBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
