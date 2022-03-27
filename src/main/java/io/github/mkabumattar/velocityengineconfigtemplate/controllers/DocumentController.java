package io.github.mkabumattar.velocityengineconfigtemplate.controllers;


import io.github.mkabumattar.velocityengineconfigtemplate.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping("/")
    public String list(ModelMap model) {
        model.put("documents", documentService.getDocuments());
        return "list";
    }

    @RequestMapping("/document/{id}")
    public String detail(@PathVariable(value = "id") Integer id, ModelMap model) {
        model.put("document", documentService.getDocumentById(id));
        return "detail";
    }
}
