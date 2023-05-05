package eu.blockchainpanda.ethereum.pandafu.sandbox;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
public class EtherTransfer {

    public static void main(String[] args) throws Exception {

        // Connect to an Ethereum node using a web3 provider
        Web3j web3j = Web3j.build(new HttpService("http://localhost:7545"));

        // Load the sender's Ethereum account private key
        String privateKey = "0x9531c65071ea3c9ee89db4ab27b58acd213a9a35f37767acd54e64dc511efe56";

        // Create a Credentials object to sign transactions with the sender's private key
        Credentials credentials = Credentials.create(privateKey);

        // Define the recipient's Ethereum account address
        String toAddress = "0x3c7a84081DBde87d751f4DD6A559cD803df0A939";

        // Define the amount of Ether to send
        BigDecimal amount = new BigDecimal("0.5");

        // Send the Ether using the Transfer.sendFunds method
        TransactionReceipt receipt = Transfer.sendFunds(web3j, credentials, toAddress, amount, Convert.Unit.ETHER).send();

        // Print the transaction hash
        System.out.println("Transaction hash: " + receipt.getTransactionHash());
        System.out.println("Block Number: " + receipt.getBlockNumber());
        System.out.println("Block hash: " + receipt.getBlockHash());
        System.out.println("Gas Used: " + receipt.getGasUsed());
    }
}
