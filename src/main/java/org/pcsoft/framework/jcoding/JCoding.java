package org.pcsoft.framework.jcoding;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JFileBuilder;
import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.renderer.JFileRenderer;
import org.pcsoft.framework.jcoding.core.validation.JFileValidator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

@Slf4j
public final class JCoding {
    private JCoding() {
    }

    public static JFileBuilder createFile(String name) {
        log.info("Create file " + name);
        return new JFileBuilder(name);
    }

    public static String renderFileToString(JFileData file) {
        log.info("Validate file " + file.getName());
        JFileValidator.getInstance().validate(file);
        log.info("Render file " + file.getName());
        return JFileRenderer.getInstance().renderToString(0, file, true);
    }

    public static void renderFile(JFileData file, OutputStream out) throws IOException {
        log.info("Validate file " + file.getName());
        JFileValidator.getInstance().validate(file);
        log.info("Render file " + file.getName());
        JFileRenderer.getInstance().render(0, file, out, true);
    }

    public static void renderFile(JFileData file, Writer writer) throws IOException {
        log.info("Validate file " + file.getName());
        JFileValidator.getInstance().validate(file);
        log.info("Render file " + file.getName());
        JFileRenderer.getInstance().render(0, file, writer, true);
    }

    public static void renderFile(JFileData file, File f) throws IOException {
        log.info("Validate file " + file.getName());
        JFileValidator.getInstance().validate(file);
        log.info("Render file " + file.getName());
        JFileRenderer.getInstance().render(0, file, f, true);
    }
}
