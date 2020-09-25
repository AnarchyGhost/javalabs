package ru.anarchyghost.javalabs.pr10;

import java.io.IOException;

public interface ICreateDocument {
    public IDocument CreateNew(String filename) throws IOException;
    public IDocument CreateOpen(String filename);
}
