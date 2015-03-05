package com.acme.planning.common.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.optaplanner.core.api.domain.solution.Solution;

public abstract class AbstractXmlSolutionExporter extends AbstractSolutionExporter {

    protected static final String DEFAULT_OUTPUT_FILE_SUFFIX = "xml";

    protected AbstractXmlSolutionExporter(SolutionDao solutionDao) {
        super(solutionDao);
    }

    protected String getOutputFileSuffix() {
        return DEFAULT_OUTPUT_FILE_SUFFIX;
    }

    public abstract XmlOutputBuilder createXmlOutputBuilder();

    public void writeSolution(Solution solution, File outputFile) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(outputFile);
            Document document = new Document();
            XmlOutputBuilder xmlOutputBuilder = createXmlOutputBuilder();
            xmlOutputBuilder.setDocument(document);
            xmlOutputBuilder.setSolution(solution);
            xmlOutputBuilder.writeSolution();
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            outputter.output(document, out);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not write the file (" + outputFile.getName() + ").", e);
        } catch (JDOMException e) {
            throw new IllegalArgumentException("Could not format the XML file (" + outputFile.getName() + ").", e);
        } finally {
            IOUtils.closeQuietly(out);
        }
        logger.info("Exported: {}", outputFile);
    }

    public abstract class XmlOutputBuilder extends OutputBuilder {

        protected Document document;

        public void setDocument(Document document) {
            this.document = document;
        }

        public abstract void setSolution(Solution solution);

        public abstract void writeSolution() throws IOException, JDOMException;

        // ************************************************************************
        // Helper methods
        // ************************************************************************

    }

}
