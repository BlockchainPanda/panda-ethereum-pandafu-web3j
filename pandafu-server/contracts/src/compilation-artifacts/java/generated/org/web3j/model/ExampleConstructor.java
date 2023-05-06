package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
    public static final String BINARY = "608060405234801561001057600080fd5b506040516101ab3803806101ab83398101604081905261002f91610054565b600080546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b610118806100936000396000f3fe6080604052348015600f57600080fd5b5060043610603c5760003560e01c806326b85ee1146041578063a8a7b89514606f578063adad7a9e14609e575b600080fd5b6000546053906001600160a01b031681565b6040516001600160a01b03909116815260200160405180910390f35b609c607a36600460b4565b600080546001600160a01b0319166001600160a01b0392909216919091179055565b005b609c600080546001600160a01b03191633179055565b60006020828403121560c557600080fd5b81356001600160a01b038116811460db57600080fd5b939250505056fea26469706673582212208b951a8ee7786dc7dd2e251b98069c0059c72d295177d0470a0dfcbbcb3371c164736f6c634300080e0033";

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

    public static RemoteCall<ExampleConstructor> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _someAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _someAddress)));
        return deployRemoteCall(ExampleConstructor.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ExampleConstructor> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _someAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _someAddress)));
        return deployRemoteCall(ExampleConstructor.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ExampleConstructor> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _someAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _someAddress)));
        return deployRemoteCall(ExampleConstructor.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ExampleConstructor> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _someAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _someAddress)));
        return deployRemoteCall(ExampleConstructor.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
