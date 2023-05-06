package eu.blockchainpanda.ethereum.pandafu.sandbox;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
public class EtherTransfer {

    public static void main(String[] args) throws Exception {

        // Connect to an Ethereum node using a web3 provider
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

        // Load the sender's Ethereum account private key
        String privateKey = "545b7748031eadb709ba541b650405e04d41b60735a33f79472f8a352a66889f";

        // Create a Credentials object to sign transactions with the sender's private key
        Credentials credentials = Credentials.create(privateKey);

        // Define the recipient's Ethereum account address
        String toAddress = "0x5279c4899A511Ff2192e62E08f0257FC277e8A1A";

        // Define the amount of Ether to send
        BigDecimal amount = new BigDecimal("1000.01");

        // Send the Ether using the Transfer.sendFunds method
        TransactionReceipt receipt;

        try {
            receipt = Transfer.sendFunds(web3j, credentials, toAddress, amount, Convert.Unit.ETHER).send();

            if (receipt.isStatusOK()) {
                // Print the transaction hash
                System.out.println("Transaction hash: " + receipt.getTransactionHash());
                System.out.println("Block Number: " + receipt.getBlockNumber());
                System.out.println("Block hash: " + receipt.getBlockHash());
                System.out.println("Gas Used: " + receipt.getGasUsed());
            } else {
                throw new TransactionException("Transaction failed with status: " + receipt.getStatus());
            }
        } catch (RuntimeException e) {
            if (e.getMessage().contains("insufficient funds")) {
                // Handle insufficient funds exception here
                System.out.println("Oops: " + "insufficient funds for gas * price + value");
            } else {
                 System.out.println("Oops: " + e.getMessage());
            }
        }
    }
}
