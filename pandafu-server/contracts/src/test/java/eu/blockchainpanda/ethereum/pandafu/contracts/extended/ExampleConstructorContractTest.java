package eu.blockchainpanda.ethereum.pandafu.contracts.extended;

import org.springframework.core.io.ClassPathResource;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

class ExampleConstructorContractTest {
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(5000000);
    private static final BigInteger GAS_PRICE = Convert.toWei("20", Convert.Unit.GWEI).toBigInteger();

    public static void main(String[] args) throws Exception {

        // Web3j instance
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

        // Load the sender's Ethereum account private key
        String privateKey = "0xaf9adc712df0c60906a73ebecab3954f6649cdbb693e882d4ca1f588eb62e2e5";

        // Create a Credentials object to sign transactions with the sender's private key
        Credentials credentials = Credentials.create(privateKey);

        ClassPathResource resourceAbi = new ClassPathResource("generated/" + "ExampleConstructor" + ".json");
        ClassPathResource resourceBin = new ClassPathResource("generated/" + "ExampleConstructor" + ".bin");

        String contractBin;
        String contractAbi;

        try {
            contractAbi = org.apache.commons.io.FileUtils.readFileToString(resourceAbi.getFile(), StandardCharsets.UTF_8);
            contractBin = org.apache.commons.io.FileUtils.readFileToString(resourceBin.getFile(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException(e);
        }

        ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

        ExampleConstructorContract contract = ExampleConstructorContract.deploy(web3j, credentials, gasProvider, contractBin).send();
    }
}