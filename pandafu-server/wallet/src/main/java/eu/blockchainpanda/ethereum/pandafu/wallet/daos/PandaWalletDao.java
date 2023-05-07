package eu.blockchainpanda.ethereum.pandafu.wallet.daos;

import eu.blockchainpanda.ethereum.pandafu.commons.model.MasterCredentials;

import java.io.File;

public interface PandaWalletDao {

    String generateRandomTwelveWordMnemonic();

    MasterCredentials generateMasterCredentialsFromPasswordAndMnemonic(String password, String mnemonic, File destinationDirectory);

    MasterCredentials retrieveMasterCredentialsFromPasswordAndMnemonic(String password, String mnemonic);

}
