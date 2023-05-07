package eu.blockchainpanda.ethereum.pandafu.commons.exceptions;

/**********************************************************************************************************************
 The exception to indicate that an error occurred while trying to retrieve information about a file.
 This exception is thrown when a specific file is being read, but there is an issue with reading its information,
 such as a security or access violation.

 @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
public class ReadingFileInfoImpossibleException extends Exception {

    public ReadingFileInfoImpossibleException(String message) {
        super(message);
    }

    public ReadingFileInfoImpossibleException(String message, Throwable cause) {
        super(message, cause);
    }
}
