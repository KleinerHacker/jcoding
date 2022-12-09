package org.pcsoft.framework.jcoding;

import org.pcsoft.framework.jcoding.core.data.JFileBuilder;
import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.renderer.JFileRenderer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class JCoding {
    private JCoding() {
    }

    public static JFileBuilder createFile(String name) {
        return new JFileBuilder();
    }

    public static String renderFileToString(JFileData file) {
        return new JFileRenderer().renderToString(file);
    }

    public static void renderFile(JFileData file, OutputStream out) throws IOException {
        new JFileRenderer().render(file, out);
    }

    public static void renderFile(JFileData file, Writer writer) throws IOException {
        new JFileRenderer().render(file, writer);
    }

    public static void renderFile(JFileData file, File f) throws IOException {
        new JFileRenderer().render(file, f);
    }

}
