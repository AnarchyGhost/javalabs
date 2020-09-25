package ru.anarchyghost.javalabs.pr10;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class TextCreateDocument implements ICreateDocument {
    @Override
    public IDocument CreateNew(String filename) throws IOException, FileAlreadyExistsException {
        TextDocument textDocument=new TextDocument(filename);
        textDocument.create();
        return textDocument;
    }

    @Override
    public IDocument CreateOpen(String filename) {
        TextDocument textDocument=new TextDocument(filename);
        return textDocument;
    }
}
