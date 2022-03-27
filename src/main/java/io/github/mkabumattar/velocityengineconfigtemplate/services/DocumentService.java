package io.github.mkabumattar.velocityengineconfigtemplate.services;


import io.github.mkabumattar.velocityengineconfigtemplate.models.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> getDocuments();

    public Document getDocumentById(Integer id);
}
