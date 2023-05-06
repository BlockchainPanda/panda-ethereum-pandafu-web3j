package eu.blockchainpanda.ethereum.pandafu.sandbox;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;

public class AccountBalance {

    public static void main(String[] args) throws Exception {

        // Connect to an Ethereum node using a web3 provider
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

        // Load the sender's Ethereum account private key
        String privateKey = "0xaf9adc712df0c60906a73ebecab3954f6649cdbb693e882d4ca1f588eb62e2e5";

        // Create a Credentials object to sign transactions with the sender's private key
        Credentials credentials = Credentials.create(privateKey);

        // Get the balance of the address
        EthGetBalance ethGetBalance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
        BigInteger weiBalance = ethGetBalance.getBalance();

        BigDecimal weiBalanceD = new BigDecimal(weiBalance);
        System.out.println("Balance in WEI: " + weiBalance);
        BigDecimal etherBalance = Convert.fromWei(weiBalanceD, Convert.Unit.ETHER);
        System.out.println("Balance in ETH: " + etherBalance);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // Same but for credentials coming from a Wallet.
        String password = "password123";

        String absolutePath = Paths.get("H:","Java_Projects", "official", "BlockchainPanda", "panda-ethereum-pandafu-web3j", "pandafu-server","sandbox", "src", "main", "resources", "test").toString();

        String walletFile = "UTC--2023-05-06T16-26-07.570056400Z--699c9ef20f2f45535e5e371bbd8a15429d97f8d5.json";

        Credentials walletFileData = WalletUtils.loadCredentials(password, absolutePath.concat(File.separator).concat(walletFile));

        // Get the balance of the address
        ethGetBalance = web3j.ethGetBalance(walletFileData.getAddress(), DefaultBlockParameterName.LATEST).send();
        weiBalance = ethGetBalance.getBalance();

        weiBalanceD = new BigDecimal(weiBalance);
        System.out.println("Balance in WEI: " + weiBalance);
        etherBalance = Convert.fromWei(weiBalanceD, Convert.Unit.ETHER);
        System.out.println("Balance in ETH: " + etherBalance);


    }
}