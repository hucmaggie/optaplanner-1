package com.acme.planning.common.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.optaplanner.core.api.domain.solution.Solution;

public abstract class AbstractXmlSolutionImporter extends AbstractSolutionImporter {

    private static final String DEFAULT_INPUT_FILE_SUFFIX = "xml";

    protected AbstractXmlSolutionImporter(SolutionDao solutionDao) {
        super(solutionDao);
    }

    public String getInputFileSuffix() {
        return DEFAULT_INPUT_FILE_SUFFIX;
    }

    public abstract XmlInputBuilder createXmlInputBuilder();

    public Solution readSolution(File inputFile) {
        Solution solution;
        InputStream in = null;
        try {
            in = new FileInputStream(inputFile);
            SAXBuilder builder = new SAXBuilder(false);
            Document document = builder.build(in);
            XmlInputBuilder txtInputBuilder = createXmlInputBuilder();
            txtInputBuilder.setInputFile(inputFile);
            txtInputBuilder.setDocument(document);
            try {
                solution = txtInputBuilder.readSolution();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Exception in inputFile (" + inputFile + ")", e);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Exception in inputFile (" + inputFile + ")", e);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read the file (" + inputFile.getName() + ").", e);
        } catch (JDOMException e) {
            throw new IllegalArgumentException("Could not parse the XML file (" + inputFile.getName() + ").", e);
        } finally {
            IOUtils.closeQuietly(in);
        }
        logger.info("Imported: {}", inputFile);
        return solution;
    }

    public abstract class XmlInputBuilder extends InputBuilder {

        protected File inputFile;
        protected Document document;

        public void setInputFile(File inputFile) {
            this.inputFile = inputFile;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public abstract Solution readSolution() throws IOException, JDOMException;

        // ************************************************************************
        // Helper methods
        // ************************************************************************

        public String getInputId() {
            return FilenameUtils.getBaseName(inputFile.getPath());
        }

        protected void assertElementName(Element element, String name) {
            if (!element.getName().equals(name)) {
                throw new IllegalStateException("Element name (" + element.getName()
                        + ") should be " + name + ".");
            }
        }

    }

}
