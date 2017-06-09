package web.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Java on 2017/05/29.
 */
@Data
@Entity
@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    @Id
    private Integer id;
    private String content;
    private String created_at;

    //@JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private Account account;
}
