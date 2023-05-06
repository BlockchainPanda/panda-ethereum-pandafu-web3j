package eu.blockchainpanda.ethereum.pandafu.contracts.extended;

import generated.ExampleConstructor;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

public class ExampleConstructorContract extends ExampleConstructor {

    protected ExampleConstructorContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ExampleConstructorContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ExampleConstructorContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider,
                                                                String contractBin, String encodedConstructor) {
        return deployRemoteCall(ExampleConstructorContract.class, web3j, credentials, contractGasProvider.getGasPrice(), contractGasProvider.getGasLimit(), contractBin, encodedConstructor);
    }
}
