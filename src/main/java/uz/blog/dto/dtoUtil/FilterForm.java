package uz.blog.dto.dtoUtil;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
public class FilterForm implements Serializable {

    @Serial
    private static final long serialVersionUID = -1183975305038088044L;

    private Integer start;

    private Integer length;

    private Map<String, Object> filter;

}
