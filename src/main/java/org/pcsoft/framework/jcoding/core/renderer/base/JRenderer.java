package org.pcsoft.framework.jcoding.core.renderer.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.pcsoft.framework.jcoding.core.data.base.JData;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public abstract class JRenderer<T extends JData> {
    protected abstract String doRender(int indent, T data);

    public final String renderUntrimmedToString(int indent, T data) {
        return doRender(indent, data);
    }

    public final String renderToString(int indent, T data) {
        return renderToString(indent, data, false);
    }

    public final String renderToString(int indent, T data, boolean logging) {
        final var code = StringUtils.trim(doRender(indent, data));
        if (logging) {
            log.trace(code);
        }

        return code;
    }

    public final void render(int indent, T data, OutputStream out, boolean logging) throws IOException {
        final var code = renderToString(indent, data, logging);
        IOUtils.write(code, out, StandardCharsets.UTF_8);
    }

    public final void render(int indent, T data, Writer writer, boolean logging) throws IOException {
        final var code = renderToString(indent, data, logging);
        IOUtils.write(code, writer);
    }

    public final void render(int indent, T data, File file, boolean logging) throws IOException {
        try (final var out = new FileOutputStream(file)) {
            render(indent, data, out, logging);
        }
    }

    protected final String buildIndent(int indent) {
        return StringUtils.repeat(" ", indent * 2);
    }
}
