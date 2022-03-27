package io.github.mkabumattar.velocityengineconfigtemplate.services.impl;

import io.github.mkabumattar.velocityengineconfigtemplate.models.Document;
import io.github.mkabumattar.velocityengineconfigtemplate.services.DocumentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final Map<Integer, Document> storage = new HashMap<>();

    public DocumentServiceImpl() {
        storage.put(1, new Document(1, "Spring Framework","The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform."));
        storage.put(2, new Document(2, "ReactJS","React is a free and open-source front-end JavaScript library for building user interfaces based on UI components. It is maintained by Meta and a community of individual developers and companies."));
        storage.put(3, new Document(3, "Linux","Linux is a family of open-source Unix-like operating systems based on the Linux kernel, an operating system kernel first released on September 17, 1991, by Linus Torvalds. Linux is typically packaged in a Linux distribution."));
    }

    @Override
    public List<Document> getDocuments() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Document getDocumentById(Integer id) {
        return storage.get(id);
    }
}
