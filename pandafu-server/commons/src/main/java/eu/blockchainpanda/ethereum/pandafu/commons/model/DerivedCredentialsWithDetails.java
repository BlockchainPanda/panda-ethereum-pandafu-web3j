package eu.blockchainpanda.ethereum.pandafu.commons.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;

import java.math.BigDecimal;
import java.math.BigInteger;

/**********************************************************************************************************************
 * This class represents credentials derived from the master credentials of a BIP-39 wallet, including a private key,
 * a public key and a public address. The class acts as a Data Transfer Object. It extends the DerivedCredentials
 * with additional info: the number of transactions the public address has received and the Balance in Wei of the
 * public address.
 *
 * BIP-39 wallets are a type of hierarchical deterministic (HD) wallet that uses a mnemonic phrase or seed to
 * generate a master keypair, which can then be used to derive a series of child keypairs, including both private
 * and public keys. Each child keypair corresponds to a specific public address on the blockchain.
 *
 *  @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/

public class DerivedCredentialsWithDetails extends DerivedCredentials {

    /******************************************************************************************************************
     * Number of transactions the public address has received.
     *****************************************************************************************************************/
    private BigInteger transactionCount;

    /******************************************************************************************************************
     * Balance in Wei (denomination of Ether) of the public address.
     *****************************************************************************************************************/
    private BigDecimal weiBalance;


    /******************************************************************************************************************
     * Constructor of the DerivedCredentials class, initializing all parameters.
     *
     * @param privateKey private key derived of the master credentials of a BIP-39 wallet, not null.
     * @param publicKey public key derived of the master credentials of a BIP-39 wallet, not null.
     * @param publicAddress public address associated with credentials derived of the master credentials of a BIP-39 wallet, not null.
     * @param transactionCount number of transactions the public address has received, not null.
     * @param weiBalance balance in Wei (denomination of Ether) of the public address, not null.
     *****************************************************************************************************************/
    @Builder
    public DerivedCredentialsWithDetails(BigInteger privateKey, BigInteger publicKey, String publicAddress,
                                         BigInteger transactionCount, BigDecimal weiBalance) {
        super(privateKey, publicKey, publicAddress);
        this.transactionCount = transactionCount;
        this.weiBalance = weiBalance;
    }

    /******************************************************************************************************************
     * Empty constructor of the DerivedCredentials class, initializing all parameters with their defaults.
     *****************************************************************************************************************/
    public DerivedCredentialsWithDetails() {

    }

    /******************************************************************************************************************
     * Getter for the transactionCount attribute of the DerivedCredentialsWithDetails class.
     *
     * @return the present value of the transactionCount attribute.
     *****************************************************************************************************************/
    public BigInteger getTransactionCount() {
        return transactionCount;
    }

    /******************************************************************************************************************
     * Setter for the transactionCount attribute of the DerivedCredentialsWithDetails class.
     *
     * @param transactionCount transactionCount number of transactions the public address has received, not null.
     *****************************************************************************************************************/
    public void setTransactionCount(BigInteger transactionCount) {
        this.transactionCount = transactionCount;
    }

    /******************************************************************************************************************
     * Getter for the weiBalance attribute of the DerivedCredentialsWithDetails class.
     *
     * @return the present value of the weiBalance attribute.
     *****************************************************************************************************************/
    public BigDecimal getWeiBalance() {
        return weiBalance;
    }

    /******************************************************************************************************************
     * Setter for the weiBalance attribute of the DerivedCredentialsWithDetails class.
     *
     * @param weiBalance balance in Wei (denomination of Ether) of the public address, not null.
     *****************************************************************************************************************/
    public void setWeiBalance(BigDecimal weiBalance) {
        this.weiBalance = weiBalance;
    }

    /******************************************************************************************************************
     * Method that returns the string representation of the present DerivedCredentialsWithDetails object.
     *
     * @return a string representation of the present object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "DerivedCredentials {" +
                "Private Key: " + super.getPrivateKey() +
                ", Public Key: " + super.getPublicKey() +
                ", Public Address: '" + super.getPublicAddress() + '\'' +
                ", TX Count=" + transactionCount +
                ", Balance in Wei: " + weiBalance +
                '}';
    }

    /******************************************************************************************************************
     * Method that returns a JSON representation of the present DerivedCredentialsWithDetails object.
     *
     * @return a JSON representation of the present object.
     *****************************************************************************************************************/
    @Override
    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    /******************************************************************************************************************
     * This inner class helps Builder for Project Lombok inheritance.
     *****************************************************************************************************************/
    public static class DerivedCredentialsWithDetailsBuilder extends DerivedCredentialsBuilder{
        DerivedCredentialsWithDetailsBuilder() {
            super();
        }
    }
}
