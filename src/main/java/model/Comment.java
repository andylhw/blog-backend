package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    private long userId;
    private long postId;
    private Date date;
    private String content;

    public Comment(long userId, long postId, Date date, String content) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.content = content;
    }

    public Date changeDate(Date date) {
        this.date = date;
        return date;
    }

    public String changeContent(String content) {
        this.content = content;
        return content;
    }
}

