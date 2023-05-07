package eu.blockchainpanda.ethereum.pandafu.commons.utilities;

import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.DirectoryIsEmptyException;
import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.DirectoryNonExistentException;
import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.ReadingFileInfoImpossibleException;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class FileLister {


    /******************************************************************************************************************
     Retrieves a list of pairs representing files in the given directory, with the name and latest modification date of each file.

     @param directoryPath a string containing the path to the directory to retrieve the list of files from

     @return a list of pairs, with each pair containing the file name and its latest modification date, ordered by modification date in ascending order

     @throws DirectoryNonExistentException if the directory at the given path does not exist
     @throws DirectoryIsEmptyException if the directory at the given path is empty
     @throws ReadingFileInfoImpossibleException if there is an error when trying to read information about the files in the directory
     *****************************************************************************************************************/
    public List<Pair<String, LocalDateTime>> retrieveListOfFilesInDirectory(String directoryPath)
            throws DirectoryNonExistentException, DirectoryIsEmptyException, ReadingFileInfoImpossibleException
    {
        File directory = new File(directoryPath);

        // Asserting that directory exists and has some content.
        if (!directory.exists() || !directory.isDirectory()) {
            throw new DirectoryNonExistentException("Directory does not exist: " + directoryPath);
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            throw new DirectoryIsEmptyException("Directory is empty: " + directoryPath);
        }

        // Creating a data structure to place readings in.
        List<Pair<String, LocalDateTime>> fileList = new ArrayList<>();

        // Iterating the files in directory. Placing them in a data structure whose tuples are
        // in the form <FileName, Latest Modification>.
        for (File file : files) {
            String fileName = file.getName();
            LocalDateTime creationDate = null;
            try {
                creationDate = LocalDateTime.ofInstant(
                        Files.getLastModifiedTime(file.toPath()).toInstant(),
                        java.time.ZoneId.systemDefault()
                );
            } catch (IOException e) {
                throw new ReadingFileInfoImpossibleException("Retrieval of file latest modification date of file "
                        + fileName + " failed.");
            }
            fileList.add(new Pair<>(fileName, creationDate));
        }

        // Sorting the list so as Latest Modification is ascending.
        Collections.sort(fileList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        // Logging retrieved items (debug only).
        fileList.forEach(item -> log.info(item.getKey() + " " + item.getValue().toString()));

        log.info("Retrieved the list of {} files contained in a directory.", fileList.size());
        return fileList;
    }

}
