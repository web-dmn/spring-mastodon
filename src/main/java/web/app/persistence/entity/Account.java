package web.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

/**
 * Created by Java on 2017/05/29.
 */
@Data
@Entity
@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    @OneToOne
    private Status status;

    @Id
    private Integer id;
    //@JsonProperty("username")
    private String username;

    private String acct;

    private String display_name;

    private String avatar;

    private String url;
}
