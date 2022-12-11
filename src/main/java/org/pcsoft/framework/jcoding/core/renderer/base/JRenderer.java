package org.pcsoft.framework.jcoding.core.renderer.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.pcsoft.framework.jcoding.core.data.base.JData;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public abstract class JRenderer<T extends JData> {
    protected abstract String doRender(T data);

    public final String renderToString(T data) {
        return renderToString(data, false);
    }

    public final String renderToString(T data, boolean logging) {
        final var code = StringUtils.trim(doRender(data));
        if (logging) {
            log.trace(code);
        }

        return code;
    }

    public final void render(T data, OutputStream out) throws IOException {
        render(data, out, false);
    }

    public final void render(T data, OutputStream out, boolean logging) throws IOException {
        final var code = renderToString(data, logging);
        IOUtils.write(code, out, StandardCharsets.UTF_8);
    }

    public final void render(T data, Writer writer) throws IOException {
        render(data, writer, false);
    }

    public final void render(T data, Writer writer, boolean logging) throws IOException {
        final var code = renderToString(data, logging);
        IOUtils.write(code, writer);
    }

    public final void render(T data, File file) throws IOException {
        render(data, file, false);
    }

    public final void render(T data, File file, boolean logging) throws IOException {
        try (final var out = new FileOutputStream(file)) {
            render(data, out, logging);
        }
    }
}
