package eu.blockchainpanda.ethereum.pandafu.commons.utilities;

import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.DirectoryIsEmptyException;
import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.DirectoryNonExistentException;
import eu.blockchainpanda.ethereum.pandafu.commons.exceptions.ReadingFileInfoImpossibleException;
import javafx.util.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = FileLister.class)
class FileListerTest {

    private static final int NUM_FILES = 5;
    private static final String FILE_PREFIX = "test-file-";
    private static final String FILE_EXTENSION = ".txt";
    private static final String DIRECTORY_NAME = "test-directory";
    @TempDir
    static File tempDir;
    private static LocalDateTime expectedCreationDate;
    private final FileLister fileLister = new FileLister();

    @BeforeAll
    static void createTestFiles() throws IOException {

        // Creating test files in a temporary directory.
        for (int i = 0; i < NUM_FILES; i++) {
            Path file = tempDir.toPath().resolve(FILE_PREFIX + i + FILE_EXTENSION);
            Files.createFile(file);
            FileTime time = FileTime.from(LocalDateTime.now().minusDays(NUM_FILES - i).atZone(ZoneId.systemDefault()).toInstant());
            Files.setLastModifiedTime(file, time);
            Instant instant = time.toInstant();
            ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
            if(i == 3) expectedCreationDate = zonedDateTime.toLocalDateTime();
        }
    }

    @Test
    @DisplayName("Retrieving List of Files in Directory")
    void testRetrieveListOfFilesInDirectory() throws DirectoryNonExistentException, DirectoryIsEmptyException, ReadingFileInfoImpossibleException {

        List<Pair<String, LocalDateTime>> fileList = fileLister.retrieveListOfFilesInDirectory(tempDir.getPath());
        assertNotNull(fileList);
        assertEquals(NUM_FILES, fileList.size());

        for (int i = 0; i < NUM_FILES; i++) {
            Pair<String, LocalDateTime> fileData = fileList.get(i);
            String expectedFileName = FILE_PREFIX + i + FILE_EXTENSION;
            assertEquals(expectedFileName, fileData.getKey());
            if(i == 3) assertEquals(expectedCreationDate, fileData.getValue());
        }
    }
}
