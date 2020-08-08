package acp.xml;

import java.util.logging.Logger;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
  private static Logger logger = Logger.getLogger(MyErrorHandler.class.getName());

  public MyErrorHandler() {
  }

  public void warning(SAXParseException e) {
    logger.warning(getLineAddress(e) + "-" + e.getMessage());
  }

  public void error(SAXParseException e) {
    logger.severe(getLineAddress(e) + " - " + e.getMessage());
//    logger.warning(getLineAddress(e) + " - " + e.getMessage());
  }

  public void fatalError(SAXParseException e) {
    logger.severe(getLineAddress(e) + " - " + e.getMessage());
  }

  private String getLineAddress(SAXParseException e) {
    return e.getLineNumber() + " : " + e.getColumnNumber();
  }
}
