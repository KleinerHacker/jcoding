package org.pcsoft.framework.jcoding;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.exception.JCodingGenerationException;
import org.pcsoft.framework.jcoding.jobject.JFileBuilder;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * The JCoding execution point. Run this to generate java code.
 */
public final class JCoding {

    public static String generateCode(final JFileBuilder fileBuilder, JCodingProcessorFactory processorFactory) throws JCodingException {
        return generateCode(fileBuilder.build(), processorFactory);
    }

    public static String generateCode(final JFileDescriptor fileDescriptor, JCodingProcessorFactory processorFactory) throws JCodingException {
        return processorFactory.getProcessor().generateCode(fileDescriptor);
    }

    public static void generateCodeToOutputStream(final JFileBuilder fileBuilder, final OutputStream out, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToOutputStream(fileBuilder, out, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToOutputStream(final JFileBuilder fileBuilder, final OutputStream out, final Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToOutputStream(fileBuilder.build(), out, charset, processorFactory);
    }

    public static void generateCodeToOutputStream(final JFileDescriptor fileDescriptor, final OutputStream out, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToOutputStream(fileDescriptor, out, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToOutputStream(final JFileDescriptor fileDescriptor, final OutputStream out, final Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        final String javaCode = generateCode(fileDescriptor, processorFactory);
        try {
            IOUtils.write(javaCode, out, charset);
        } catch (IOException e) {
            throw new JCodingGenerationException("Unable to write generated java code into output stream!", e);
        }
    }

    public static void generateCodeToFile(final JFileBuilder fileBuilder, final File file, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToFile(fileBuilder, file, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToFile(final JFileBuilder fileBuilder, final File file, Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToFile(fileBuilder.build(), file, charset, processorFactory);
    }

    public static void generateCodeToFile(final JFileDescriptor fileDescriptor, final File file, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToFile(fileDescriptor, file, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToFile(final JFileDescriptor fileDescriptor, final File file, Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        final String javaCode = generateCode(fileDescriptor, processorFactory);
        try {
            FileUtils.writeStringToFile(file, javaCode, charset);
        } catch (IOException e) {
            throw new JCodingGenerationException("Unable to write generated java code into file: " + file.getAbsolutePath(), e);
        }
    }

    public static void generateCodeToDirectory(final JFileBuilder fileBuilder, final File dir, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToDirectory(fileBuilder, dir, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToDirectory(final JFileBuilder fileBuilder, final File dir, Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToDirectory(fileBuilder.build(), dir, charset, processorFactory);
    }

    public static void generateCodeToDirectory(final JFileDescriptor fileDescriptor, final File dir, JCodingProcessorFactory processorFactory) throws JCodingException {
        generateCodeToDirectory(fileDescriptor, dir, Charset.defaultCharset(), processorFactory);
    }

    public static void generateCodeToDirectory(final JFileDescriptor fileDescriptor, final File dir, Charset charset, JCodingProcessorFactory processorFactory) throws JCodingException {
        final File packageDir = fileDescriptor.getPackageName() == null || fileDescriptor.getPackageName().trim().isEmpty() ? dir :
                new File(dir, fileDescriptor.getPackageName().replace(".", SystemUtils.FILE_SEPARATOR));
        if (!packageDir.exists()) {
            if (!packageDir.mkdirs())
                throw new JCodingGenerationException("Unable to generate package directory for java file: " + fileDescriptor.getFilename());
        }
        final File file = new File(packageDir, fileDescriptor.getFilename() + ".java");
        if (file.exists())
            throw new JCodingGenerationException("Unable to generate java file! File already exists: " + file.getAbsolutePath());

        generateCodeToFile(fileDescriptor, file, charset, processorFactory);
    }

    private JCoding() {
    }
}
