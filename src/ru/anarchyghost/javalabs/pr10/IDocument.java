package ru.anarchyghost.javalabs.pr10;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IDocument {
    public abstract void create() throws IOException;
    public abstract void open(JFrame frame) throws IOException;
    public abstract void save(JFrame frame) throws IOException;
    public abstract void exit(JFrame frame) throws IOException;
}
