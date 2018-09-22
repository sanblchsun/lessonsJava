package ru.geekbrains.java3.dz.dz3.FilippovAlex;

import com.sun.istack.internal.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;

class StreamEnumeration implements Enumeration<InputStream> {

    private Enumeration<String> fileNames;

    StreamEnumeration(@NotNull Vector<String> list) {
        this.fileNames = list.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return fileNames.hasMoreElements();
    }

    @Override
    public InputStream nextElement() {
        try {
            return new FileInputStream(fileNames.nextElement());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}