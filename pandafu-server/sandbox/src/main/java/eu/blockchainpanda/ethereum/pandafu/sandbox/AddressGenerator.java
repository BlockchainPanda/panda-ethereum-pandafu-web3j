package eu.blockchainpanda.ethereum.pandafu.sandbox;

import org.web3j.crypto.*;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressGenerator {
    public static void main(String[] args) {
        String mnemonic = "candy maple cake sugar pudding cream honey rich smooth crumble sweet treat";
        String destinationDir = Paths.get("H:","Java_Projects", "official", "BlockchainPanda", "panda-ethereum-pandafu-web3j", "pandafu-server","sandbox", "src", "main", "resources", "foo").toString();
        String password = "";
        List<Credentials> credentials = new ArrayList<>();

        try {
            Bip39Wallet wallet = WalletUtils.generateBip39WalletFromMnemonic(password, mnemonic, new File(destinationDir));
            byte[] seed = Numeric.hexStringToByteArray(wallet.getMnemonic());
            Bip32ECKeyPair masterKeypair = Bip32ECKeyPair.generateKeyPair(seed);
            for (int i = 0; i < 5; i++) {
                Bip32ECKeyPair derivedKeyPair = Bip32ECKeyPair.deriveKeyPair(masterKeypair, new int[] {44 | 0x80000000, 60 | 0x80000000, 0 | 0x80000000, 0, i});
                Credentials creds = Credentials.create(derivedKeyPair);
                credentials.add(creds);
            }
        } catch (CipherException | IOException e) {
            e.printStackTrace();
        }

        for (Credentials creds : credentials) {
            System.out.println("Public Address: " + creds.getAddress());
            System.out.println("Private Key: " + creds.getEcKeyPair().getPrivateKey());
        }
    }
}
