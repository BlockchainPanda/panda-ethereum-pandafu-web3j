package eu.blockchainpanda.ethereum.pandafu.sandbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.web3j.crypto.Bip39Wallet;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.nio.file.Paths;
public class WalletCreationWithSeed {

    public static void main(String[] args) {
        String password = "password123"; // your desired password
        String destinationDir = Paths.get("H:","Java_Projects", "official", "BlockchainPanda", "panda-ethereum-pandafu-web3j", "pandafu-server","sandbox", "src", "main", "resources", "bip").toString();


        try {
            Bip39Wallet wallet = WalletUtils.generateBip39Wallet(password, new File(destinationDir));

            Credentials credentials = WalletUtils.loadBip39Credentials(password, wallet.getMnemonic());

            Credentials credentials2 = WalletUtils.loadCredentials(password, destinationDir + File.separator + wallet.getFilename());

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(credentials.getEcKeyPair());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





