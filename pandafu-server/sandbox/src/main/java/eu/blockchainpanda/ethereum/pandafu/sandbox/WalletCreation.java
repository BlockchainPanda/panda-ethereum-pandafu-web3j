package eu.blockchainpanda.ethereum.pandafu.sandbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;


public class WalletCreation {

    public static void main(String[] args) throws Exception {

        // Generate a new random seed for the wallet
        byte[] seed = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(seed);

        // Create a new wallet file with the given password
        String password = "password123";

        String absolutePath = Paths.get("H:","Java_Projects", "official", "BlockchainPanda", "panda-ethereum-pandafu-web3j", "pandafu-server","sandbox", "src", "main", "resources", "test").toString();

        String walletFile = WalletUtils.generateNewWalletFile(password, new File(absolutePath));

        // Load the wallet from the file
        Credentials walletFileData = WalletUtils.loadCredentials(password, absolutePath.concat(File.separator).concat(walletFile));

        System.out.println("New wallet created with address: " + walletFileData.getAddress());
        System.out.println("Private key: " + walletFileData.getEcKeyPair().getPrivateKey().toString(16));
        System.out.println("Private key: " + walletFileData.getEcKeyPair().getPrivateKey().toString(16));
    }

    private static WalletFile loadWalletFile(String filePath) throws IOException {
        File file = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        WalletFile walletFile = objectMapper.readValue(file, WalletFile.class);
        return walletFile;
    }
}
