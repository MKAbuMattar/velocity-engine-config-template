package io.github.mkabumattar.velocityengineconfigtemplate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private Integer id;
    private String title;
    private String description;
}
