package generated;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.8.
 */
@SuppressWarnings("rawtypes")
public class ExampleConstructor extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_MYADDRESS = "myAddress";

    public static final String FUNC_SETMYADDRESS = "setMyAddress";

    public static final String FUNC_SETMYADDRESSTOMSGSENDER = "setMyAddressToMsgSender";

    @Deprecated
    protected ExampleConstructor(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ExampleConstructor(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ExampleConstructor(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ExampleConstructor(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    @Deprecated
    public static ExampleConstructor load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExampleConstructor(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ExampleConstructor load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExampleConstructor(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ExampleConstructor load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ExampleConstructor(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ExampleConstructor load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ExampleConstructor(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> myAddress() {
        final Function function = new Function(FUNC_MYADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setMyAddress(String _myAddress) {
        final Function function = new Function(
                FUNC_SETMYADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _myAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setMyAddressToMsgSender() {
        final Function function = new Function(
                FUNC_SETMYADDRESSTOMSGSENDER,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }
}
