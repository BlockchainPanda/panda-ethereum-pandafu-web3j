package eu.blockchainpanda.ethereum.pandafu.commons.exceptions;

/**********************************************************************************************************************
 The exception to indicate that an error occurred while trying to retrieve contents from a directory.
 This exception is thrown when the directory, indicated via its path, does not actually exist in the file system.

 @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
public class DirectoryNonExistentException extends Exception {

    public DirectoryNonExistentException(String message) {
        super(message);
    }

    public DirectoryNonExistentException(String message, Throwable cause) {
        super(message, cause);
    }
}
