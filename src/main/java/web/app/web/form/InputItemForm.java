package web.app.web.form;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Java on 2017/06/03.
 */
@Data
public class InputItemForm implements Serializable{
    @NotNull(message = "値が入力されていません。")
    @Min(1)
    @Id
    private String key;
}
