package eu.blockchainpanda.ethereum.pandafu.commons.exceptions;

/**********************************************************************************************************************
 The exception to indicate that an error occurred while trying to retrieve contents from a directory.
 This exception is thrown when the directory, indicated via its path, does exist but has no content.

 @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
public class DirectoryIsEmptyException extends Exception {

    public DirectoryIsEmptyException(String message) {
        super(message);
    }

    public DirectoryIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

}
